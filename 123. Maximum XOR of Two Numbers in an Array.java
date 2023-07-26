import java.util.* ;
import java.io.*; 
public class Solution {

    static class TrieNode{
        TrieNode zero;
        TrieNode one;
    }
    static class Trie{
        TrieNode root = new TrieNode();
        public void insert(int n){
           TrieNode curr = root;
            for(int i =31;i>=0;i--){
                int num = (n>>i)&1;
                if(num == 0){
                    if(curr.zero == null){
                    TrieNode newNode = new TrieNode();
                    curr.zero = newNode;
                    }
                        curr = curr.zero;
                }else{
                    if(curr.one == null){
                        TrieNode newNode = new TrieNode();
                        curr.one = newNode;
                    }
                    curr = curr.one;
                }
            }
        }

      public int findMaxXor(int n) {
    TrieNode curr = root;
    int ans = 0;
    for (int i = 31; i >= 0; i--) {
        int num = (n >> i) & 1;
        if (num == 0) {
            if (curr.one != null) {
                ans = ans + (1 << i);
                curr = curr.one;
            } else {
                curr = curr.zero;
            }
        } else {
            if (curr.zero != null) {
                ans = ans + (1 << i);
                curr = curr.zero;
            } else {
                curr = curr.one;
            }
        }
    }
    return ans;
      }
   }
    public static int maximumXor(int[] A) {
        Trie trie = new Trie();
        for(int i =0;i<A.length;i++){
            trie.insert(A[i]);
        }
        int ans =0;
        for(int i = 0;i<A.length;i++){
            ans = Math.max(ans, trie.findMaxXor(A[i]));
        }
        return ans;
    }
}