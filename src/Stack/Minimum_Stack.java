package Stack;

import java.util.Stack;

public class Minimum_Stack {

    Stack<Integer> obj;
    Stack<Integer> minS;


    public Minimum_Stack() {
        obj = new Stack<>();
        minS = new Stack<>();
    }

    public void push(int val) {
        if(obj.empty()){
            minS.push(val);
        }
        if(!obj.empty() && obj.peek()> val){
            minS.push(val);
        }
        obj.push(val);
    }
    public void pop() {
        if(obj.peek() == minS.peek()){
            minS.pop();
        }
        obj.pop();
    }

    public int top() {
        return obj.peek();
    }

    public int getMin() {
        return minS.peek();
    }


    public static void main(String[] args) {

        Minimum_Stack minStack = new Minimum_Stack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println(minStack.getMin()); // return 0
        minStack.pop();
        System.out.println(minStack.top());    // return 2
        System.out.println(minStack.getMin()); // return 1

    }
}
