public ListNode removeNthFromEnd(ListNode head, int n) {
    // Create a dummy node as the previous node of the head
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    // Initialize two pointers: fast and slow
    ListNode fast = dummy;
    ListNode slow = dummy;

    // Move the fast pointer n nodes ahead
    for (int i = 0; i <= n; i++) {
        fast = fast.next;
    }

    // Move the fast and slow pointers simultaneously until the fast pointer reaches the end
    while (fast != null) {
        fast = fast.next;
        slow = slow.next;
    }

    // Remove the Nth node by updating the next pointer of the slow pointer
    slow.next = slow.next.next;

    // Return the modified linked list
    return dummy.next;
}
