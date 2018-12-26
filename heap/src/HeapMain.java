/**
 * Created by ryan on 10/2/17.
 */
public class HeapMain {

    public static void main(String[] args) {


        PriorityQueue queue = new PriorityQueue();
        queue.printQueue();
        queue.enqueue(13);
        queue.enqueue(20);
        queue.enqueue(15);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(7);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.enqueue(4);
        queue.enqueue(3);

        queue.printQueue();

        System.out.println("Removing: " + queue.remove());
        queue.printQueue();
        System.out.println("Removing: " + queue.remove());
        queue.printQueue();
        System.out.println("Removing: " + queue.remove());
        queue.printQueue();
        System.out.println("Removing: " + queue.remove());
        queue.printQueue();
        System.out.println("Removing: " + queue.remove());
        queue.printQueue();
        System.out.println("Removing: " + queue.remove());
        queue.printQueue();

    }
}
