import java.util.* ;
import java.io.*; 

/****************************************************************/
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

/*****************************************************************/

public class Solution {

    public static boolean isPalindrome(LinkedListNode<Integer> head) {

		//MID
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

		//Rev
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = slow;

        while (curr != null) {
            LinkedListNode<Integer> nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }


        LinkedListNode<Integer> p1 = head;
        LinkedListNode<Integer> p2 = prev;

        while (p2 != null) {
            if (!p1.data.equals(p2.data)) {
                return false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
	}
}