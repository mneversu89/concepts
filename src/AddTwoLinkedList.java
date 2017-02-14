import java.util.Objects;

/**
 * Created by manish on 2/13/17.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoLinkedList {
    //handling using recursion
    // assuming the listnode will fit into memory and get lost
    // and nodes is starting from its units place as head
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(Objects.isNull(l1) && Objects.isNull(l2)) {
            return null;
        }
        return addNodes(0, l1, l2);
    }

    private ListNode addNodes(int carry, ListNode l1, ListNode l2) {
        if(l1 == null && l2==null && carry == 0) {
            return null;
        }
        int value = carry;
        if(l1 != null) {
             value = value+ l1.val;
        }
        if(l2 != null) {
             value = value + l2.val;
        }

        ListNode result = new ListNode(value%10);
        if(l1 != null && l2 != null) {
            ListNode more = addNodes(value >= 10 ? 1 : 0, l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next);
            result.next = more;
            }
        return result;
    }

    public static void main(String args[]) {
        //TestCase
        ListNode Tl1 = new ListNode(2);
        ListNode Tl2 = new ListNode(4);
        ListNode Tl3 = new ListNode(3);
        Tl1.next = Tl2;
        Tl2.next = Tl3;
        ListNode Kl1 = new ListNode(5);
        ListNode Kl2 = new ListNode(6);
        ListNode Kl3 = new ListNode(4);
        Kl1.next = Kl2;
        Kl2.next = Kl3;
        AddTwoLinkedList addTwoLinkedList = new AddTwoLinkedList();
        ListNode head= addTwoLinkedList.addTwoNumbers(Tl1, Kl1);
        if(head != null) {
            ListNode it = head;
            do {
                System.out.println(it.val);
                it = it.next;
            }while(it != null);
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
