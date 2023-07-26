import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private int capacity;
    private int minFrequency;
    private Map<Integer, Integer> keyToValue;
    private Map<Integer, Integer> keyToFrequency;
    private Map<Integer, LinkedHashSet<Integer>> frequencyToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToValue = new HashMap<>();
        this.keyToFrequency = new HashMap<>();
        this.frequencyToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (keyToValue.containsKey(key)) {
            increaseFrequency(key);
            return keyToValue.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFrequency(key);
        } else {
            if (keyToValue.size() >= capacity) {
                evictLFU();
            }
            keyToValue.put(key, value);
            keyToFrequency.put(key, 1);
            frequencyToKeys.putIfAbsent(1, new LinkedHashSet<>());
            frequencyToKeys.get(1).add(key);
            minFrequency = 1;
        }
    }

    private void increaseFrequency(int key) {
        int frequency = keyToFrequency.get(key);
        keyToFrequency.put(key, frequency + 1);
        frequencyToKeys.get(frequency).remove(key);

        if (frequencyToKeys.get(frequency).isEmpty()) {
            frequencyToKeys.remove(frequency);
            if (frequency == minFrequency) {
                minFrequency++;
            }
        }

        frequencyToKeys.putIfAbsent(frequency + 1, new LinkedHashSet<>());
        frequencyToKeys.get(frequency + 1).add(key);
    }

    private void evictLFU() {
        LinkedHashSet<Integer> keys = frequencyToKeys.get(minFrequency);
        int evictKey = keys.iterator().next();
        keys.remove(evictKey);
        keyToValue.remove(evictKey);
        keyToFrequency.remove(evictKey);
    }
}