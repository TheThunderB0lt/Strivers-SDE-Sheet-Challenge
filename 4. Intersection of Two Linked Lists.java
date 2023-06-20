/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        Node A = firstHead;
        Node B = secondHead;

        while(A != B){
            A = A.next;
            B = B.next;
            if(A == B) return A.data;
            if(A == null) A = secondHead;
            if(B == null) B = firstHead;
        }
        return A.data;
    }
}