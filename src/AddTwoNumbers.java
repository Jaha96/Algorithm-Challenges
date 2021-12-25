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

//        ListNode l1 = setList(0);
//        ListNode l2 = setList(0);

        ListNode l1 = new ListNode(9);
        ListNode l2 = setList(999999991);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }


    static int getNumbers(ListNode listNode){
        if (listNode.next != null){
            int v = getNumbers(listNode.next);
            v = v * 10 + listNode.val;
            return v;
        }
        return listNode.val;
    }

    static ListNode setList(long numbers){
        if(numbers!=0){
            ListNode l = new ListNode((int)numbers%10);
            l.next = setList(numbers / 10);
            return l;
        }
        return null;
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int l1Number = getNumbers(l1);
        int l2Number = getNumbers(l2);
        int sum = l1Number + l2Number;
        if(sum == 0)
            return new ListNode(0);
        return setList(sum);
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
