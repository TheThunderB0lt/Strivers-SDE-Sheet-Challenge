import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		//write your code here
		int i=0, j=0, n = input.length(), max = 0;

        HashMap<Character, Integer> map = new HashMap<>();

 

        while(j < n){

            char ch = input.charAt(j);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

 

            if(map.size() < j - i + 1){

                while(map.size() < j - i + 1){

                    char c = input.charAt(i++);

                    if(map.get(c) == 1) map.remove(c);

                    else map.put(c, map.get(c)-1);

                } j++;

            }

            else if(map.size() == j - i + 1){

                max = Math.max(max,  j - i + 1);

                j++;

            }

        }

 

        return max;
	}
}
