import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        // Write your code here.
        int len1 = str1.length();

        int len2 = str2.length();

        if(len1 != len2) return false;

 

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < len1; i++){

            char ch = str1.charAt(i);

            if(map.containsKey(ch)){

                map.put(ch, map.get(ch) + 1);

            }else{

                map.put(ch, 1);

            }

        }

        for(int i = 0; i < len2; i++){

            char ch = str2.charAt(i);

            if(map.containsKey(ch)){

                if(map.get(ch) == 0){

                    return false;

                }else{

                    map.put(ch, map.get(ch) - 1);

                }

            }else{

                return false;

            }

        }

        return true;
    }
}