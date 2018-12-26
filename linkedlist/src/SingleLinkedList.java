/**
 * Created by ryan on 6/9/17.
 */
public class SingleLinkedList extends List {

    public Node prependNode(int value) {
        Node node = new Node();
        node.setValue(value);
        if(size == 0){
            this.tail = node;
        } else {
            node.setNext(head);
        }
        size++;
        this.head = node;
        return head;
    }

    public Node appendNode(int value) {
        Node node = new Node();
        node.setValue(value);

        if(size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
        }
        this.tail = node;
        size++;
        return tail;
    }

    public void clear(){
        Node node = this.head;

        while(node != null) {
            Node tmp = node.getNext();
            node.setNext(null);
            node = tmp;
        }
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
