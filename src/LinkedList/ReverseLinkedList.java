package LinkedList;

public class ReverseLinkedList {

    //complexity oN and space oN
    public static ListNode reverseList(ListNode head) {

        if(head == null) return null ;

        ListNode newNode = new ListNode(head.val, null);

        while(head != null){

            head = head.next;
            if(head == null) break;
            newNode = new ListNode(head.val,newNode);
        }

        return newNode;

    }

    //try complexity oN and space o1
    public static ListNode reverseList_2(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;

    }



    public static void main(String[] args) {
        // Test case 1: [0, 1, 2, 3]
        ListNode head1 = createLinkedList(new int[]{0, 1, 2, 3});
        ListNode reversed1 = reverseList_2(head1);
        System.out.println(linkedListToString(reversed1)); // Expected: [3, 2, 1, 0]

        // Test case 2: []
        ListNode head2 = createLinkedList(new int[]{});
        ListNode reversed2 = reverseList_2(head2);
        System.out.println(linkedListToString(reversed2)); // Expected: []

        // Test case 3: [1]
        ListNode head3 = createLinkedList(new int[]{1});
        ListNode reversed3 = reverseList_2(head3);
        System.out.println(linkedListToString(reversed3)); // Expected: [1]


    }
    // Helper function to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }
    // Helper function to convert a linked list to a string
    public static String linkedListToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}


