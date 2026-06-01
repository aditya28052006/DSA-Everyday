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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursive step:
        // Reverse the linked list starting
        // from the second node (head.next).
        ListNode newHead = reverseList(head.next);
        
        // Save a reference to the node following
        // the current 'head' node.
        ListNode front = head.next;
        
        // Make the 'front' node point to the current
        // 'head' node in the reversed order.
        front.next = head;
        
        // Break the link from the current 'head' node
        // to the 'front' node to avoid cycles.
        head.next = null;
        
        // Return the 'newHead,' which is the new
        // head of the reversed linked list.
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            // It's a palindrome by definition
            return true;
        }
    
        // Initialize two pointers, slow and fast,
        // to find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
    
        // Traverse the linked list to find the
        // middle using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            // Move slow pointer one step at a time
            slow = slow.next;
    
            // Move fast pointer two steps at a time
            fast = fast.next.next;
        }
    
        // Reverse the second half of the 
        // linked list starting from the middle
        ListNode newHead = reverseList(slow.next);
    
        // Pointer to the first half
        ListNode first = head;
    
        // Pointer to the reversed second half
        ListNode second = newHead;
        while (second != null) {
            // Compare data values of
            // nodes from both halves
    
            // If values do not match, the
            // list is not a palindrome
            if (first.val != second.val) {
                
                // Reverse the second half back
                // to its original state
                reverseList(newHead);
    
                // Not a palindrome
                return false;
            }
    
            // Move the first pointer
            first = first.next;
    
            // Move the second pointer
            second = second.next;
        }
    
        // Reverse the second half back
        // to its original state
        reverseList(newHead);
    
        // The linked list is a palindrome
        return true;
    }
}