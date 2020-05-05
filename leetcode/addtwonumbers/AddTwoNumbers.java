package addtwonumbers;

/**
 * @author: guoyongkui
 * @date: 2020/5/5 19:35
 * @projectName: holdon
 * @description:
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int i = 0;
        ListNode result = null;
        ListNode listNode = null;
        boolean isAdd = false;
        while (l1 != null || l2 != null){
            int sum = 0;

            if (l1 == null) {
                sum = l2.val;
            }else if (l2 == null){
                sum = l1.val;
            }else {
                sum = l1.val + l2.val;
            }
            if (isAdd) {
                sum++;
            }
            ListNode temp = null;
            if (sum >= 10){
                temp = new ListNode(sum%10);
                isAdd = true;
            }else {
                temp = new ListNode(sum);
                isAdd = false;
            }

            if (i == 0){
                listNode = temp;
                result = listNode;
            }else {
                listNode.next = temp;
                listNode = temp;
            }
            i++;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (isAdd){
            ListNode temp = new ListNode(1);
            listNode.next = temp;
        }
        return result;

    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(6);
        l11.next = l12;
        l12.next = l13;


        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode listNode = addTwoNumbers(l11, l21);
        System.out.println("sssss");


    }



}
