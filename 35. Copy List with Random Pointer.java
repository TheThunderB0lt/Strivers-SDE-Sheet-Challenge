import java.io.*;
import java.util.* ;

/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		// Write your code here.
		// HashMap<LinkedListNode, LinkedListNode> map = new HashMap<>();
		// LinkedListNode<Integer> temp = head;
		// while(temp != null) {
		// 	LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(temp.data);
		// 	map.put(temp, newNode);
		// 	temp = temp.next;
		// }

		// LinkedListNode<Integer> t = head;
		// while(t != null) {
		// 	LinkedListNode<Integer> node = map.get(t);
		// 	node.next = (t.next != null) ? map.get(t.next) : null;
		// 	node.random = (t.random != null) ? map.get(t.random) : null;
		// 	t = t.next;
		// }
		// return map.get(head);

		LinkedListNode<Integer> temp = head;
		while(temp != null) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(temp.data);
			newNode.next = temp.next;
			temp.next = newNode;
			temp = temp.next.next;
		}

		LinkedListNode<Integer> itr = head;
		while(itr != null) {
			if(itr.random != null) {
				itr.next.random = itr.random.next;
			}
			itr = itr.next.next;
		}

		LinkedListNode<Integer> dummy = new LinkedListNode<Integer>(0);
		itr = head;
		temp = dummy;
		LinkedListNode<Integer> fast;
		while(itr != null) {
			fast = itr.next.next;
			temp.next = itr.next;
			itr.next = fast;
			temp = temp.next;
			itr = fast;
		}
		return dummy.next;
	}
}
