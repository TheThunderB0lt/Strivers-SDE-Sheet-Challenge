import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<String> findPermutations(String s) {

        // Write your code here.

        return permutation("",s);

 

    }

 

    public static List<String> permutation(String p, String up){

 

        if(up.isEmpty()){

            List<String> list = new ArrayList<>();

            list.add(p);

            return list;

        }

 

        char ch = up.charAt(0);

        List<String> ans = new ArrayList<>();

 

        for(int i=0; i<=p.length(); i++){

 

            String first = p.substring(0,i);

            String second = p.substring(i);

 

            ans.addAll(permutation(first+ch+second, up.substring(1)));

 

        }

        return ans;

    }
}