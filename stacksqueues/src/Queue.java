import java.util.ArrayList;

public class Queue {
    private static class QueueNode {

        private int data;
        private QueueNode next;

        public QueueNode(int value) {
           this.data = value;
        }
    }

    private QueueNode back;
    private QueueNode front;

    public Queue enqueue(int value) {
        QueueNode node = new QueueNode(value);

        if(this.back == null) {
            this.back = node;
            this.front = node;
        } else {
            this.back.next = node;
            this.back = node;
        }

        return this;
    }
    public int dequeue(){
        if (this.front == null) {
            return -1;
        }

        QueueNode node = this.front;
        this.front = node.next;
        node.next = null;

        return node.data;
    }

    public void printQueue() {
        QueueNode node = this.front;

        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
