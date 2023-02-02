package nagarro_assignment_ds_stack;
import java.util.Arrays;
import java.util.Scanner;

public class Stack {
	int top = -1;
	public int arrStack[]= new int[10];
	Scanner sc = new Scanner(System.in);
	public void push(int x) {
		if(top == size() ) {
			System.out.println("\nStack overflow" );
		}
		else {
			top = top+1;
			arrStack[top] = x;
		}
		
	}
	public void pop() {
		if(top == -1) {
			System.out.print("Stack is already empty");
		}
		else {
			top = top-1;
		}
		
	}
	public int peek() {
		if(top<0) {
			System.out.println("Stack is Empty");
		}
		return arrStack[top];
		
		
	}
	public void contains(int num) {
		if(top == -1 ) {
			System.out.print("Element not found");
		}
		for(int i=0;i<top;i++) {
			if(arrStack[i]==num) {
				System.out.println("Element is present in stack");
			}
		}
			
	}
	
	public int size() {
		return arrStack.length;
		
	}
	public void centre() {
		int start =0;
		int last = arrStack.length-1;
		int midIndex = start + (last-start)/2;
		System.out.println("The midIndex is " +midIndex+"and the element is " +arrStack[midIndex]);
	}
	
	public void sort() {
		Arrays.sort(arrStack);
		System.out.print(Arrays.toString(arrStack));
		
	}
	
	public void reverse() {
		int n = size();
		int[] rev = new int[n];
		int j = n;
		for(int i =0;i<n;i++) {
			rev[j-1]=arrStack[i];
			j=j-1;
			
		}
		System.out.println("Reversed stack is:");
		for(int k=0; k<n;k++) {
			System.out.println(rev[k+1]);
		}
		
	}
	public void Iterator() {
		for(Integer item: arrStack) {
			System.out.println(item+"\n");
		}
	}
	
	public boolean isEmpty() {
		return top ==-1;
	}
	
	public void print() {
		if(top==-1) {
			System.out.println("Stack is Empty");
		}
		for(int i = top;i>=0;i--) {
			System.out.println(arrStack[i]);
			System.out.println("---");
			
		}	
	}
}
