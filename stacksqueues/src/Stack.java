import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class Stack {

   private class StackNode {
       private int data;
       private StackNode next;

       public StackNode(int data) {
           this.data = data;
       }
   }

   private StackNode top;


   public Stack push(int value) {
        StackNode node = new StackNode(value);

        if(this.top == null){
            this.top = node;
        } else {
            node.next = this.top;
            this.top = node;
        }
        return this;
   }

    public int pop(){

       if(this.top == null) {
           return -1;
       }
       int data = this.top.data;

       StackNode node = this.top;
       this.top = node.next;
       node.next = null;

       return data;
    }

    public int peek(){
        if(this.top == null) {
            return -1;
        }

        return this.top.data;
    }

    public Boolean isEmpty() {
        return this.top == null;
    }

    public void printStack() {
        StackNode node = this.top;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
       System.out.println();
    }
}
