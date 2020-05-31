

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {

    // fill in the definitions for push(), pop(), and getMax()


	public static class MaxStack {

	private class stackItem{
		private int value;
		private int max;

		private stackItem(int value, int max){
			this.value = value;
			this.max = max;
		}

		private stackItem(){
			this(0,0);
		}

		private int getMax(){
			return max;
		}

		private int getValue(){
			return value;
		}
	}

	//private ArrayDeque<Integer> stack;
	private Deque<stackItem> stack;
	private int max;

	public MaxStack(){
		stack = new ArrayDeque<>();
		max = Integer.MIN_VALUE;
	}

	public void push(int item){

		if(item > max)
			max = item;

		stack.offerLast(new stackItem(item, max));
	}

	public int pop(){
		if(!stack.isEmpty()){
			stackItem result = stack.pollLast();
			max = (stack.peekLast() != null) ? stack.peekLast().getMax() : Integer.MIN_VALUE;

			return result.getValue();
		}
		else
			return 0;
	}

	public int getMax() {
		return max;
	}
}
/******************************************************************************/
/********************************** tests ************************************/

    @Test
    public void maxStackTest() {
        final MaxStack s = new MaxStack();
        s.push(5);
        assertEquals("check max after 1st push", 5, s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        assertEquals("check before 1st pop", 8, s.getMax());
        assertEquals("check pop #1", 8, s.pop());
        assertEquals("check max after 1st pop", 7, s.getMax());
        assertEquals("check pop #2", 7, s.pop());
        assertEquals("check max after 2nd pop", 7, s.getMax());
        assertEquals("check pop #3", 7, s.pop());
        assertEquals("check max after 3rd pop", 5, s.getMax());
        assertEquals("check pop #4", 4, s.pop());
        assertEquals("check max after 4th pop", 5, s.getMax());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
