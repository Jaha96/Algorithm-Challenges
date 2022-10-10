import org.w3c.dom.NodeList;

/*
        You are given two non-empty linked lists representing two non-negative integers.
        The digits are stored in reverse order, and each of their nodes contains a single
        digit. Add the two numbers and return the sum as a linked list.

        You may assume the two numbers do not contain any leading zero,
        except the number 0 itself.

        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
*/


public class AddTwoNumbers {

    public static void main(String[] args){
        System.out.println("Hello world");

        ListNode l1 = new ListNode(9, new ListNode(1, new ListNode(6)));
        ListNode l2 = new ListNode(0);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNumbers(l1, l2, 0);
    }

    public static ListNode addNumbers(ListNode l1, ListNode l2, int carry) {
        ListNode result = new ListNode();
        int sum = 0;
        if(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            result.val = sum % 10;
            result.next = addNumbers(l1.next, l2.next, sum / 10);
        }else{
            if (l1 == null && l2 == null && carry == 0)
                return null;
            ListNode nextVal = null;
            int l1Val = 0, l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                nextVal = l1.next;
            }
            if (l2 != null) {
                l2Val = l2.val;
                nextVal = l2.next;
            }
            sum = l1Val + l2Val + carry;
            result.val = sum % 10;
            if(sum / 10 != 0 || nextVal != null)
                result.next = addNumbers(nextVal, null, sum / 10);
        }
        return  result;
    }



}



//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static String printNumbers(ListNode listNode){
        String retStr = String.valueOf(listNode.val);
        if (listNode.next != null){
            String v = printNumbers(listNode.next);
            retStr = retStr + "-->" + v;
            return retStr;
        }
        return retStr;
    }

    public String toString(){
        return printNumbers(this);
    }
}
