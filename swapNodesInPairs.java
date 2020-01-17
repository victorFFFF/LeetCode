/*
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 

//My solution

class swapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNode pointer = head;
        ListNode temp;
        ArrayList< ListNode > list = new ArrayList<>();
        int count = 0;
        int even = 0;
        int odd = 1;
        
        //Add all nodes to array
        while( pointer != null)
        {
            temp = pointer.next;
            pointer.next = null;
            list.add(pointer);
            pointer = temp;
            count++;
        }
            head = list.get(1);
         
        //Reverse 2 nodes at time 
        for(int i = 0; i < count/2 ; i++)
        {
            pointer = list.get(odd);
            pointer.next = list.get(even);
            pointer.next.next = null;
            
            even += 2;
            odd += 2;           
        }
        odd = 3;
        pointer= head;
        
        //Combine all the reversed Nodes
        for( int i = 0; i < count/2-1 ; i++)
        {
            while(pointer.next != null)
                pointer = pointer.next;
            pointer.next = list.get(odd);
            odd += 2;    
            
        }
        //Add the last remaining node if the total number is odd;
           if( count % 2 != 0)
           {
               pointer = head;
               while( pointer.next != null)
                   pointer = pointer.next;
               
               pointer.next = list.get(count-1);
           }
        return head;
    }
}



//Simple solution but not my solution

public ListNode swapNodesInPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
        ListNode first = current.next;
        ListNode second = current.next.next;
        first.next = second.next;
        current.next = second;
        current.next.next = first;
        current = current.next.next;
    }
    return dummy.next;
}
