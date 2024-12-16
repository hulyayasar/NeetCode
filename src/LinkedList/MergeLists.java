package LinkedList;

public class MergeLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode merged = new ListNode();
        ListNode curr = merged;

        while(list1 != null && list2!=null){

            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 != null){
            curr.next = list1;
        }if(list2 != null){
            curr.next = list2;
        }

        return merged.next;

    }
}