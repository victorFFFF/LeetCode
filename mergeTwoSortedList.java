/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class mergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head;
        ListNode pointer;
        
        
    if(l1 == null  && l2 == null )
        return null;
    else
    {
                        int lower;

                       if( l1 == null)
                           return l2;

                       if( l2 == null)
                           return l1;

                        if(l1.val < l2.val)
                         {
                            lower = l1.val;
                            l1 = l1.next;
                         }
                        else
                            {
                            lower = l2.val;
                            l2 = l2.next;
                             }

                head = new ListNode(lower);
                pointer = head;


        
        //While nethier of the LL are not empty we keep comparing and inserting
        while( l1 != null && l2 != null)  
        {
                if( l2.val > l1.val)
                {
                  pointer.next = new ListNode(l1.val);  
                  l1 = l1.next;
                  pointer = pointer.next;          
                }
                else 
                {
                    pointer.next = new ListNode(l2.val);
                    l2 = l2.next;
                    pointer = pointer.next;
                }
        }
        
        
        if(l1 == null)
            {
                while(l2 != null)
                {
                    pointer.next = new ListNode(l2.val);
                    l2 = l2.next;
                    pointer = pointer.next;
                }
             }
        else if(l2== null)
        {
            while(l1 != null)
            {
                pointer.next = new ListNode(l1.val);
                l1= l1.next;
                pointer = pointer.next;
            }
        }
        
        return head;
    } 
            
            
        
    }
}
