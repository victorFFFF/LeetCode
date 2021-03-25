/*
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// My solution

class swapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        ListNode current = head;
        ListNode newList = null;
        int val = 1;
        Queue<ListNode> oddQ = new LinkedList<>();
        Queue<ListNode> evenQ = new LinkedList<>();

        if (head == null)
            return null;
        if (head.next == null)
            return head;

        while (current != null) {
            // EVEN
            if (val % 2 == 0)
                evenQ.add(current);
            // ODD
            else
                oddQ.add(current);

            current = current.next;
            val++;
        }

        for (int i = 0; i < val - 1; i++) {
            if (newList == null) {
                newList = evenQ.remove();
                head = newList;
            } else {
                if (i % 2 == 0 && evenQ.size() > 0)
                    newList.next = evenQ.remove();
                else
                    newList.next = oddQ.remove();

                newList = newList.next;
                newList.next = null;
            }
        }
        return head;
    }

}
