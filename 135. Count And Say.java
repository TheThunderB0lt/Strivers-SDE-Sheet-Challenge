import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static String writeAsYouSpeak(int n) 
    {
        if(n == 1){
            return "1";
        }else if(n == 2){
            return "11";
        }
        String s = "11";
        for(int i =3;i<=n;i++){
            String temp = "";
            int j =0;int count =1;
            s = s+"&";
            while(j<s.length()-1){
                if(j+1<s.length()&&s.charAt(j) == s.charAt(j+1)){
                    count++;j++;
                }else{
                    temp = temp + Integer.toString(count) + s.charAt(j);
                    count =1;
                    j++;
                }
            }
            s = temp;
        }
        return s;
    
    }
}