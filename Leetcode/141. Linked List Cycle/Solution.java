/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Initialize two pointers: fast and slow
        ListNode fast =  head;
        ListNode slow = head;

        // Check if the linked list has zero or one node
        if(head == null || head.next == null)
            return false;

        // Loop until either fast pointer reaches the end or the two pointers meet
        while(fast != null || fast.next != null) {
            // Move the slow pointer one step forward
            slow = slow.next;
            // Move the fast pointer two steps forward
            fast = fast.next.next;
            
            // Check if the two pointers meet, indicating a cycle
            if(slow == fast)
                return true;
        }
        
        // If the loop finishes without returning true, there is no cycle
        return false;
    }
}
