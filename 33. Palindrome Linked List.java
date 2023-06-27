import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {
    public static LinkedListNode<Integer> getMid(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> forward = null;

        while (curr != null) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;
    }

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return true;
        }

        LinkedListNode<Integer> middle = getMid(head);
        LinkedListNode<Integer> headB = middle.next;
        middle.next = null;
		headB = reverse(headB);

        while (head != null && headB != null) {
            if (!head.data.equals(headB.data)) {
                return false;
            }

            head = head.next;
            headB = headB.next;
        }

        return true;
    }
}

import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {
	// Method 1: using 3 methods
    // public static LinkedListNode<Integer> getMid(LinkedListNode<Integer> head) {
    //     LinkedListNode<Integer> slow = head;
    //     LinkedListNode<Integer> fast = head;

    //     while (fast.next != null && fast.next.next != null) {
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }

    //     return slow;
    // }

    // public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
    //     LinkedListNode<Integer> prev = null;
    //     LinkedListNode<Integer> curr = head;
    //     LinkedListNode<Integer> forward = null;

    //     while (curr != null) {
    //         forward = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = forward;
    //     }

    //     return prev;
    // }

    // public static boolean isPalindrome(LinkedListNode<Integer> head) {
    //     if (head == null || head.next == null) {
    //         return true;
    //     }

    //     LinkedListNode<Integer> middle = getMid(head);
    //     LinkedListNode<Integer> headB = middle.next;
    //     middle.next = null;
	// 	headB = reverse(headB);

    //     while (head != null && headB != null) {
    //         if (!head.data.equals(headB.data)) {
    //             return false;
    //         }

    //         head = head.next;
    //         headB = headB.next;
    //     }

    //     return true;

	// Method2 : using single method
	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		if(head == null || head.next == null) return true;

		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
		LinkedListNode<Integer> prev = null;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			LinkedListNode<Integer> temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}

		LinkedListNode<Integer> firstHalf = prev;
    	LinkedListNode<Integer> secondHalf = slow;

		if(fast != null) {
			secondHalf = secondHalf.next;
		}

		while (firstHalf != null && secondHalf != null) {
        if (!firstHalf.data.equals(secondHalf.data))
            return false;

        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
    	}
		return true;
    }
}