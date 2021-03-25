/**

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 
class RemoveNthNodefromList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        
        ListNode current = head;
        ListNode right = null;
      
        Stack<ListNode> stack = new Stack <>();
        int counter = 0;
        
        
        while( current != null )
        {
            stack.push(current);
            current = current.next;
        }
        
        while( counter < n )
        {  
            right = current;
            current = stack.pop();    
            counter++;
        }
        
       if( stack.size() > 0)
       {
        stack.pop().next = right;
        return head;
       }
        else 
            return head.next;      
       
    }
}