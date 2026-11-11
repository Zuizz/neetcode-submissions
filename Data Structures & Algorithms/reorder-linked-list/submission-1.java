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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevslow = head;

        if(head.next == null)
            return;

        while(fast!=null && fast.next!=null)
        {
            prevslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevslow.next = null;
        ListNode curr = slow;
        ListNode prev = null;

        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode first = head;
        ListNode second = prev;
        while(first != null && second != null)
        {
            ListNode nextfirst = first.next;
            ListNode nextsecond = second.next;

            first.next = second;
            if(nextfirst == null)
                break;
            second.next = nextfirst;

            first = nextfirst;
            second = nextsecond;   
        }
    }
}
