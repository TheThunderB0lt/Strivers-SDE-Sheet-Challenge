import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static int compareVersions(String a, String b) 
    {
        String[] ver1 = a.split("\\.");
        String[] ver2 = b.split("\\.");

        int i = 0;
        int n = ver1.length, m = ver2.length;

        while(i < n || i < m){
            if(i < n && i < m){
                if(Double.parseDouble(ver1[i]) < Double.parseDouble(ver2[i])){
                    return -1;
                }else if(Double.parseDouble(ver1[i]) > Double.parseDouble(ver2[i]))
                    return 1;
            }
            else if(i < n){
                if(Double.parseDouble(ver1[i]) != 0){
                    return 1;
                }    
            }
            else if(i < m){
                if(Double.parseDouble(ver2[i]) != 0){
                    return -1;
            }
            }
            i++;
        }
        return 0;
    }
}