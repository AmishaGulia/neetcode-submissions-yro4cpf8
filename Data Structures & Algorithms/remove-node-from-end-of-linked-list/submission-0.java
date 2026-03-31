/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Step 2: Move fast ahead by n+1 steps
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Step 3: Move slow and fast until fast hits null
        ListNode slow = dummy;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Step 4: Remove node
        slow.next = slow.next.next;
        
        // Return updated list
        return dummy.next;
    }
    
    public static void main(String args[]){

    }
}

