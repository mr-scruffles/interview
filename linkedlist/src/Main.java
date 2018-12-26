/**
 * Created by ryan on 6/9/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("LinkedList Entry point");


        SingleLinkedList slist = new SingleLinkedList();
        slist.prependNode(0);
        slist.prependNode(1);
        slist.prependNode(2);
        slist.prependNode(3);
        slist.printList();

        SingleLinkedList slist1 = new SingleLinkedList();
        slist1.appendNode(0);
        slist1.appendNode(1);
        slist1.appendNode(2);
        slist1.appendNode(3);
        slist1.printList();

        System.out.println("Double Linked List");
        DoubleLinkedList dlist = new DoubleLinkedList();
        dlist.appendNode(0).appendNode(1).appendNode(2).appendNode(3);
        dlist.printList();
        dlist.printListReverse();

    }
}
