/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
          HashSet<ListNode> s= new HashSet<>();
          ListNode curr= head;
          while(curr!=null){
            if(s.contains(curr)){
                return curr;
            }
            s.add(curr);
            curr= curr.next;
          }
          return null;
    }

}