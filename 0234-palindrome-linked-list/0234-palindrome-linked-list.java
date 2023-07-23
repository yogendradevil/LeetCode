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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode start = slow.next;
        ListNode pre = null;
        ListNode nx = start;
        while(nx != null){
            start = nx;
            nx = nx.next;
            start.next = pre;
            pre = start;
        }
        while(start != null){
            if(head.val != start.val){
                return false;
            }
            head = head.next;
            start = start.next;
        }
        return true;
    }
}