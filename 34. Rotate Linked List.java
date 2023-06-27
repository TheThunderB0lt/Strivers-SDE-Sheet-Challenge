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
 };

 *****************************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if(head == null || head.next == null || k == 0) return head;

        int len = 1;
        Node curr = head;
        while(curr.next != null) {
            len++;
            curr = curr.next;
        }

        curr.next = head;
        k = k % len;
        k = len - k;
        while(k-- > 0) curr = curr.next;

        head = curr.next;
        curr.next = null;

        return head;
    }
}