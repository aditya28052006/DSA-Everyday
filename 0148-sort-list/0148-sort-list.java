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

    public ListNode findMiddle(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoList(ListNode list1,ListNode list2){
        ListNode dummyNode= new ListNode(-1);
        ListNode temp=dummyNode;
        while(list1!=null && list2!=null ){
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } 
            else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move the temporary pointer
            // to the next node
            temp = temp.next; 
        }

         // If any list still has remaining
        // elements, append them to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        // Return the merged list starting 
        // from the next of the dummy node
        return dummyNode.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find the middle of the list
        // using the findMiddle function
        ListNode middle = findMiddle(head);
        
        // Divide the list into two halves
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;
        
        // Recursively sort the left and right halves
        left = sortList(left);
        right = sortList(right);
        
        // Merge the sorted halves using the
        // mergeTwoSortedLinkedLists function
        return mergeTwoList(left, right);
    }
}