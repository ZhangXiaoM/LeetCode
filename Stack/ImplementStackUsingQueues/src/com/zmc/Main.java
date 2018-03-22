
/*

https://leetcode.com/problems/implement-stack-using-queues/description/

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively.
You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */


package com.zmc;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.print(s.top());
        System.out.print(s.pop());
        s.push(3);
        System.out.print(s.top());
    }
}


class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int top;
        int size = q1.size();
        for (int i = 0; i < size - 1; ++i) q2.offer(q1.poll());
        top = q1.poll();
        while (!q2.isEmpty()) q1.offer(q2.poll());
        return top;
    }

    /** Get the top element. */
    public int top() {
        int top;
        int size = q1.size();
        for (int i = 0; i < size - 1; ++i) q2.offer(q1.poll());
        top = q1.peek();
        q2.offer(q1.poll());
        while (!q2.isEmpty()) q1.offer(q2.poll());
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}