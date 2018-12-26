/**
 * Created by ryan on 6/9/17.
 */
public class List {

    protected Node head;
    protected Node tail;
    protected int size;

    public void printList(){
        Node node = head;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
