package nagarro_assignments_ds_queue;
import java.util.Scanner;

public class Main {
	static void display_menu() {
		System.out.println("Enter 1 to enqueue:");
		System.out.println("Enter 2 to dequeue:");
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
		Queue Q = new Queue();
		Scanner sc = new Scanner(System.in);
		char repeat_menu = 'y'; 
		int choice;
		display_menu();
		do {
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.print("Enter the element to be enqued :");
				int num = sc.nextInt();
				Q.enqueue(num);
				break;
			}
			case 2:{
				System.out.print("The Queue after deque operation is:");
				Q.dequeue();
				Q.print();
				break;
			}
			case 3:{
				System.out.print("The peek element is :");
				Q.peek();
				break;
				}
			case 4:{
				System.out.println("Enter the element to be searched :");
				int num = sc.nextInt();
				Q.contains(num);
				break;
			}
			case 5:{
				System.out.print("The size of the queue is :" +Q.size());
				break;
			}
			case 6:{
				System.out.print("The element at the centre is :" );
				Q.centre();
				break;
			}
			case 7:{
				System.out.print("The queue after sorting is:");
				Q.sort();
				Q.print();
				break;
			}
			case 8:{
				System.out.println("Queue after reversal is :");
				Q.reverse();
				Q.print();
				break;
			}
			case 9:{
				System.out.println("Enter the iterator index :");
				int index = sc.nextInt();
				Q.iterator(index);
				break;
			}
			case 10:{
				Q.print();
				break;
			}
			default:{
				System.out.println("Invalid Input!!!!!");
			}
		   }
			System.out.println("\nEnter More(y/n):");
			repeat_menu = sc.next().charAt(0);
		
		}
	    while(repeat_menu == 'y'|| repeat_menu == 'Y');
	    return;
    }
}
	
