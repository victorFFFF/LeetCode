/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        HashMap<ListNode, Integer> map = new HashMap<>();

        while (head != null) {
            if (map.get(head) == null)
                map.put(head, 1);
            else
                return true;
            head = head.next;

        }
        return false;

    }
}