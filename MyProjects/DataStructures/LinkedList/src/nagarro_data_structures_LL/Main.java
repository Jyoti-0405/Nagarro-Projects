package nagarro_data_structures_LL;

import java.util.Scanner;

import nagarro_data_structures_LL.LinkedList.Node;

public class Main{
	static void display_menu() {
		System.out.println("Enter 1 to insert element:");
		System.out.println("Enter 2 to insert element at a position:");
		System.out.println("Enter 3 to delete element:");
		System.out.println("Enter 4 to delete element at a position:");
		System.out.println("Enter 5 to find the centre element of a linked list:");
		System.out.println("Enter 6 to sort the linked list:");
		System.out.println("Enter 7 to reverse the linked list:");
		System.out.println("Enter 8 to know the size of linked list:");
		System.out.println("Enter 9 to traverse or print the linked list:");
	}	
	public static void main(String[] args) {
		int choice;
		char repeat_menu = 'y';
		display_menu();
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		do {
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter the number you want to add: ");
				int num1 = sc.nextInt();
				ll.addFirst(num1);
				ll.print();
				break;
				
			}
			case 2:{
				System.out.println("Enter the position:");
				int pos = sc.nextInt();
				System.out.println("Enter the number you want to add: ");
				int num2 = sc.nextInt();
				ll.addPos(pos, num2);
				ll.print();
				break;
				
			}
			case 3:{
				ll.deleteFirst();
				System.out.println("The linked list after deletion is: ");
				ll.print();
				break;
				
			}
	        case 4:{
	        	System.out.println("Enter the position:");
				int pos2 = sc.nextInt();
				System.out.println("The linked list after deletion is: ");
				ll.deletePos(pos2);
				ll.print();
	        	break;
				
			}
	        case 5:{
	        	ll.centre();
				ll.print();
	        	break;
				
			}
	        case 6:{
	        	ll.Sort();
				System.out.println("The linked list after sorting is:");
				ll.print();
	        	break;
				
			}
	        case 7:{
	        	Node head = ll.head;
	        	ll.reverse();
	        	System.out.println("Linked list after reversal is :");
	        	ll.print();
	        	break;
	        	
	        }
	        case 8:{
	        	System.out.print(ll.size());
	        	break;
	        	
	        }
	        case 9:{
	        	ll.print();
	        	break;
	        	
	        }
	        default:{
	        	System.out.println("Wrong Choice!!!");
	        	display_menu();
	        	break;
	        }
			
			}
			System.out.println("\nEnter More(y/n):");
			repeat_menu = sc.next().charAt(0);
			
		}
		while(repeat_menu == 'y'|| repeat_menu == 'Y');
		return ;
	}
		
}	
		
	
	