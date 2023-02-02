package nagarro_assignment_ds_stack;

import java.util.Scanner;

public class Main {
	static void display_menu() {
		System.out.println("Enter 1 to push:");
		System.out.println("Enter 2 to pop:");
		System.out.println("Enter 3 to peek:");
		System.out.println("Enter 4 to search an element:");
		System.out.println("Enter 5 to know the size:");
		System.out.println("Enter 6 to find the centre:");
		System.out.println("Enter 7 to sort:");
		System.out.println("Enter 8 to reverse:");
		System.out.println("Enter 9 for iterator:");
		System.out.println("Enter 10 to traverse or print:");
	}
	
	public static void main(String[] args) {
		Stack stackobj = new Stack();
		Scanner sc = new Scanner(System.in);
		char repeat_menu = 'y'; 
		int choice;
		display_menu();
		do {
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter the element you want to enter :");
			    int x = sc.nextInt();
			    stackobj.push(x);
			    stackobj.print();
			    break;
			}
			    
			case 2:{
				System.out.println("Stack after popping");
				stackobj.pop();
				stackobj.print();
				break;
				
			}
			case 3:{
				System.out.println("The peek element is :");
				System.out.println(stackobj.peek());
				break;
			}
			case 4:{
				System.out.print("Enter the element you want to search:");
				int num = sc.nextInt();
				stackobj.contains(num);
				stackobj.print();
				break;
				
			}
			case 5:{
				System.out.println("The size of the stack is :");
				System.out.println(stackobj.size());
				break;
			}
			case 6:{
				System.out.println("The centre element of the stack is :");
				stackobj.centre();
				stackobj.print();
				break;
			}
			case 7:{
				System.out.println("The sorted stack is:");
				stackobj.sort();
				break;	
			}
			case 8:{
				stackobj.reverse();
				break;
			}
			case 9:{
				System.out.println("The stack iterator has the following element:");
				stackobj.Iterator();
				break;
			}
			case 10:{
				System.out.println("The stack has the following elements :");
				stackobj.print();
				break;
			}
			default:{
				System.out.println("Invalid Input!!!");
			}
				
			}
			System.out.println("\nEnter More(y/n):");
			repeat_menu = sc.next().charAt(0);
		}
			
		while(repeat_menu == 'y'|| repeat_menu == 'Y');
		return;
	}

	
}
