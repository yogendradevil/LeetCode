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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(l1 != null || l2 != null || c != 0){
        int sum = c;
            if(l2 != null){
                sum += l2.val; 
                l2 = l2.next;
            }
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            ListNode temp = new ListNode(sum%10);
            curr.next = temp;
            curr = curr.next;
            c = sum/10;
        }
        return head.next;
    }
}