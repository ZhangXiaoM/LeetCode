
/*

https://leetcode.com/problems/implement-queue-using-stacks/description/

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue),
as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 */


package com.zmc;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.print(obj.peek());
        obj.push(3);
        System.out.print(obj.peek());
    }


}


class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s2.empty()) s1.push(s2.pop());
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}