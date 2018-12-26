public class Node {

    private int value;
    private Node next;
    private Node prev;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Node getPrev() {
        return this.prev;
    }

    public Node getNext(){
        return this.next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
