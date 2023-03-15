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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode dummy = new ListNode(0);
          ListNode curr = dummy;
          int carry = 0;
  
          while (l1 != null || l2 != null) {
              int sum = carry;
  
              if (l1 != null) {
                  sum += l1.val;
                  l1 = l1.next;
              }
  
              if (l2 != null) {
                  sum += l2.val;
                  l2 = l2.next;
              }
  
              curr.next = new ListNode(sum % 10);
              carry = sum / 10;
              curr = curr.next;
          }
  
          if (carry > 0) {
              curr.next = new ListNode(carry);
          }
  
          return dummy.next;
      }
  }
  
  public class Main {
      public static void main(String[] args) {
          ListNode l1 = new ListNode(2);
          l1.next = new ListNode(4);
          l1.next.next = new ListNode(3);
  
          ListNode l2 = new ListNode(5);
          l2.next = new ListNode(6);
          l2.next.next = new ListNode(4);
  
          Solution solution = new Solution();
          ListNode result = solution.addTwoNumbers(l1, l2);
          while (result != null) {
              System.out.print(result.val + " ");
              result = result.next;
          }
      }
  }