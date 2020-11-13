/**
 Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode temp = head;
        ListNode prev = head;
        
        
        if( head == null)
            return head;
        
        
        while(current != null)
        {
             current = current.next;
          if( current != null )
          {
            if( prev.val != current.val)
            {
                prev.next = current;
                prev = current;
            }

          }
        }
        prev.next = null;
        return head;
    }
}