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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->
                Integer.compare(a.val, b.val));
        
        for(ListNode n: lists){
            if(n != null){
                pq.offer(n);
            }  
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            // 接到结果链表
            cur.next = min;
            cur = cur.next;
            if(min.next != null){
                pq.offer(min.next);
            }
        }
        return dummy.next;
    }
}
