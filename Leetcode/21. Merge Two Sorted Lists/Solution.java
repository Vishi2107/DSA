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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node as the head of the merged list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        // Iterate through the lists until either one reaches the end
        while (list1 != null && list2 != null) {
            // Merge Lists based on the node values
            if (list1.val <= list2.val) {
                // Connect the current node to list1
                curr.next = list1;
                list1 = list1.next; // Move list1 to the next node
            } else {
                // Connect the current node to list2
                curr.next = list2;
                list2 = list2.next; // Move list2 to the next node
            }
            
            curr = curr.next; // Move curr to the next node in the merged list
        }
        
        // Append the remaining nodes of the non-empty list to the merged list
        curr.next = (list1 != null) ? list1 : list2;
        
        // Return the head of the merged list (after the dummy node)
        return dummy.next;
    }
}
