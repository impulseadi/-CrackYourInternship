/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;5
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;}
        ListNode a=headA;
        ListNode b=headB;
        
            //if a and b have different length, then we will stop the loop after second transition
            while(a!=b){
                a = a==null ? headB : a.next;
                b = b==null ? headA : b.next;
            }
            return a;
        }
}
