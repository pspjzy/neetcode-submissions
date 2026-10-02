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
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // 先把后面的链表反转
        ListNode newHead = reverseList(head.next);
        // 把当前节点接到后面
        head.next.next = head;
        // 断开原来的连接
        head.next = null;
        return newHead;

    }
}
