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
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;

        if(head.next == null)
            return null;

        while(curr != null)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode revhead = prev;
        if(n==1)
            revhead = revhead.next;
        else
        {
            for(int i=1;i<n-1;i++)
            {
                prev = prev.next; 
            }
            prev.next = prev.next.next;
        }        

        curr = revhead;
        prev = null;

        while(curr != null)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        

        return prev;
    }
}
