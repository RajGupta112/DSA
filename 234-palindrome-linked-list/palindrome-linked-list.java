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
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) {

            // No change is needed;
            // return the current head
            return head;
        }
        ListNode curr= head;
        ListNode prev= null;
        while(curr!=null){
            ListNode front= curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
         ListNode slow= head;
         ListNode fast = head;
          while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast=fast.next.next;
          }
       ListNode temp= reverse(slow);
      
      ListNode first=head;
      ListNode second=temp;
      while(second!=null){
        if(first.val!=second.val){
            return false;
        }
        first=first.next;
        second=second.next;
      
      }
      return true;
    }
}