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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null ){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        while(slow != null){
            slow = slow.next;
            len++;
        }
        if(k >= len){
            k = k%len;
        }
        slow = head;
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}