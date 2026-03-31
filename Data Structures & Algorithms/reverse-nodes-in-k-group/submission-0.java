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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Step 1: Check if we have at least k nodes
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count < k) return head; // less than k nodes left

        // Step 2: Reverse k nodes
        ListNode prev = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 3: Recursively reverse the rest
        head.next = reverseKGroup(curr, k);

        // prev is new head of reversed group
        return prev; 
    }
}
