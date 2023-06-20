import java.io.*;
import java.util.* ;

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		if(first == null) return second;
        if(second == null) return first;

        LinkedListNode<Integer> t = new LinkedListNode<>(0);
        LinkedListNode<Integer> dummy = t;

        while(first != null && second != null){
            if(first.data <= second.data){
                t.next = first;
                first = first.next;
            } else {
                t.next = second;
                second = second.next;
            }
            t = t.next;
        }

        if(first != null){
            t.next = first;
        } else {
            t.next = second;
        }

        return dummy.next;
	}
}
