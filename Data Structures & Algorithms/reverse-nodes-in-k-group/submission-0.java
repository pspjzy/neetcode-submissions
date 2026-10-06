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
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // 找当前组的第 k 个节点
            ListNode kth = getKth(groupPrev, k);

            // 剩余不足 k 个，不反转
            if (kth == null) {
                break;
            }

            // 下一组的开头
            ListNode groupNext = kth.next;

            // 当前组原来的头
            // 反转后会变成尾
            ListNode oldGroupStart = groupPrev.next;

            // 反转当前这一组
            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;

            while (cur != groupNext) {
                ListNode temp = cur.next;

                cur.next = prev;

                prev = cur;
                cur = temp;
            }

            // 把前一部分连接到反转后的新头
            groupPrev.next = kth;

            // 移动 groupPrev
            groupPrev = oldGroupStart;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode cur, int k) {
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }

        return cur;
    }
}
