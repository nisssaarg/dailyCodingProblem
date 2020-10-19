/*
 * Implement a stack that has the following methods:
 * 
 * push(val), which pushes an element onto the stack
 * 
 * pop(), which pops off and returns the topmost element of the stack. 
 * If there are no elements in the stack, then it should throw an error or return null.
 * 
 * max(), which returns the maximum value in the stack currently.
 *  If there are no elements in the stack, then it should throw an error or return null.
 */

import java.util.Stack;

public class maxStack extends Stack<Integer> {
	Stack<Integer> max = new Stack<>();
	
	public void push(int val) {
		if(isEmpty()) {
			super.push(val);
			max.push(val);
		}
		else {
			super.push(val);
			int y=max.pop();
			if(val>y)
				max.push(val);
			else
				max.push(y);
		}
	}
	
	public Integer pop() {
		int x=super.pop();
		max.pop();
		return x;
	}
	
	public Integer max() {
		int x=max.pop();
		max.push(x);
		return x;
	}

	public static void main(String... args) {
		maxStack m=new maxStack();
		m.push(10);
		m.push(11);
		m.push(15);
		m.push(9);
		System.out.println(m.max());
	}
}
