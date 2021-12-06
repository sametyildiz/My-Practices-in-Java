package my_practice.leetcode.easyproblems;

public class Problem21 {
    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     *
     * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
     *
     * Return the head of the merged linked list.
     *
     *  */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode node = new ListNode();
        ListNode tmpNode = new ListNode();
        while (list1 != null || list2 != null){
            if( list2.next == null || list1.val < list2.val){
                node = new ListNode( list1.val , tmpNode);
                tmpNode = node;
                list1 = list1.next;
            }
            else if( list1.next == null || list2.val < list1.val){
                node = new ListNode( list2.val , tmpNode);
                tmpNode = node;
                list2 = list2.next;
            }else{
                node = new ListNode( list1.val , tmpNode);
                tmpNode = node;
                node = new ListNode( list2.val , tmpNode);
                tmpNode = node;

                list1 = list1.next;
                list2 = list2.next;
            }
        }
        return node;
    }

    /*public ListNode addToListNode(int[] array){
        ListNode lastNode = new ListNode(array[array.length-1]);
        ListNode node = new ListNode();
        for(int i = array.length-2 ; i > -1 ; i--){
            node = new ListNode(array[i] , lastNode);
            lastNode = node;
        }
        return node;
    }*/

    public ListNode addToListNode(int[] array){

        ListNode node = new ListNode();
        ListNode tmpNode = new ListNode();
        int i = 0;
        while(i < array.length) {
           node = new ListNode(array[i], i++ == 0 ? null : tmpNode);
           tmpNode = node;
        }
        return node;
    }
    public ListNode addToListNode(ListNode inputNode){

        ListNode node = new ListNode();
        ListNode tmpNode = new ListNode();
        while(inputNode != null) {
            node = new ListNode(inputNode.val , tmpNode);
            tmpNode = node;
            inputNode = inputNode.next;
        }
        return node;
    }

    public void printListNode(ListNode node){
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
