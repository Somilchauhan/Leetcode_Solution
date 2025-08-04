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

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head.next;

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast.next == null) return fast.next;
        if(fast.next.next == null) return fast.next.next;

        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        }

        return slow;
    }
}