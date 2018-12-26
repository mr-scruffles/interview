/**
 * Created by ryan on 6/9/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Stacks and Queues");

        Stack stack = new Stack();
        stack.push(1).push(2).push(3).push(4);
        stack.printStack();

        System.out.println("Peeking value: " + stack.peek());
        stack.printStack();
        System.out.println("Popping value: " + stack.pop());
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("Stack isEmpty? " + stack.isEmpty());


        System.out.println("Intializing Queue");
        Queue queue = new Queue();
        queue.enqueue(1).enqueue(2).enqueue(3);

        queue.printQueue();

        queue.dequeue();
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }
}
