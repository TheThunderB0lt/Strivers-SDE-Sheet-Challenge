class TrieNode {
    public final TrieNode[] children;
    public int wordCount;

    TrieNode() {
        children = new TrieNode[26]; // Assuming lowercase English letters only
        wordCount = 0;
    }
}

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return 0;
            }
            curr = curr.children[index];
        }
        return curr.wordCount;
    }

    public int countWordsStartingWith(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return 0;
            }
            curr = curr.children[index];
        }
        return countAllWords(curr);
    }

    private int countAllWords(TrieNode node) {
        int count = node.wordCount;
        for (TrieNode child : node.children) {
            if (child != null) {
                count += countAllWords(child);
            }
        }
        return count;
    }

    public void erase(String word) {
        if (countWordsEqualTo(word) > 0) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                curr = curr.children[index];
            }
            curr.wordCount--;
        }
    }
}
