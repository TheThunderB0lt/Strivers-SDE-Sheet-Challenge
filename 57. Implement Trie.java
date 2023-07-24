class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    public Node get(char ch){
        return links[ch - 'a'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
}

public class Trie {
    //Initialize your data structure here
    private static Node root;

    Trie() {
        //Write your code here
        root = new Node();
    }

    //Inserts a word into the trie
    public static void insert(String word) {
        //Write your code here
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);

            if(!node.containsKey(curr)){
                node.put(curr, new Node());
            }

            node = node.get(curr);
        }
        node.setEnd();
    }


    //Returns if the word is in the trie
    public static boolean search(String word) {
        //Write your code here
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);
            
            if(!node.containsKey(curr)) return false;

            node = node.get(curr);
        }

        if(node.isEnd()) return true;
        return false;
    }
    
    //Returns if there is any word in the trie that starts with the given prefix
    public static boolean startsWith(String prefix) {
        //Write your code here
        Node node = root;
        for(int i=0; i<prefix.length(); i++){
            char curr = prefix.charAt(i);

            if(!node.containsKey(curr)) return false;

            node = node.get(curr);
        }

        return true;
    }
}