/**
 * Created by ryan on 6/9/17.
 */
public class DoubleLinkedList extends List{

    public DoubleLinkedList appendNode(int value) {
        Node node = new Node();
        node.setValue(value);

        if(size == 0){
            this.head = node;
            this.tail = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            this.tail = node;
        }

        size ++;
        return this;
    }

    public DoubleLinkedList prependNode(int value) {
        Node node = new Node();
        node.setValue(value);
        if(size == 0){
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }

        size++;
        return this;
    }

    public void printListReverse(){
        Node node = this.tail;

        while(node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getPrev();
        }
        System.out.println();
    }
}
