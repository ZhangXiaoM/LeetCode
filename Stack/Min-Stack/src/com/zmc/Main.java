
/*

https://leetcode.com/problems/min-stack/description/

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

 */


package com.zmc;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MinStack minStack = new MinStack();
        minStack.push(5);
        System.out.print(minStack.getMin());
        minStack.push(3);
        System.out.print(minStack.getMin());
        minStack.push(4);
        System.out.print(minStack.getMin());
        minStack.pop();
        System.out.print(minStack.getMin());
    }


    static class MinStack {

        Stack<Integer> stack;
        int _min = Integer.MAX_VALUE;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if(x <= _min){
                stack.push(_min);
                _min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (_min == stack.pop()) _min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return _min;
        }
    }
}
