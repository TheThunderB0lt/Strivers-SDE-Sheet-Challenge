import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		HashSet<String> dict = new HashSet<>(dictionary); // Convert given list dict to hashset for O(1) lookup
		ArrayList<String> answer = new ArrayList<>();

		helper(s, "", answer, dict);

		return answer;
	}

	public static void helper(String uString, String pString, ArrayList<String> answer, HashSet<String> dict)
	{
		if(uString.length() == 0)
		{
			answer.add(pString.trim());
			return;
		}

		for(int i = 0; i < uString.length(); i++)
		{
			if(dict.contains(uString.substring(0, i + 1))) 
			helper(uString.substring(i + 1), pString + " " + uString.substring(0, i + 1), answer, dict);
		}
	}
}