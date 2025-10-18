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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr=head;
        int count=0;
        while(curr!=null){
        count++;
        curr=curr.next;
        }
        if(n==count) return head.next;
      ListNode slow=head;
        for(int i=0;i<count-n-1;i++){
          slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}