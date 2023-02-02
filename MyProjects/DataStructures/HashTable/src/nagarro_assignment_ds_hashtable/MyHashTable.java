package nagarro_assignment_ds_hashtable;
import java.util.Scanner;

public class MyHashTable {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hash Table Implementation ");
		System.out.println("Enter Size");
		int size = sc.nextInt();
		HashTable ht = new HashTable(size);
		char ch;
		do {
			System.out.println("\nHashTable Operations :");
			System.out.println("1. Insert");
			System.out.println("2. Remove");
			System.out.println("3. Contains");
			System.out.println("4. Clear");
			System.out.println("5. Size");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter element to insert:");
				ht.insert(sc.nextInt());
				break;
			}
			case 2:{
				System.out.println("Enter Integer element to delete:");
				ht.delete(sc.nextInt());
				break;
			}
			case 3:{
				System.out.println("Enter element to check if present :");
				System.out.println("Contains: "+ht.contains(sc.nextInt()));
				break;
			}
			case 4:{
				ht.clear();
				System.out.println("Hashtable clear!!");
				break;
			}
			case 5:{
				System.out.println("The size of hash table is: "+size);
				break;
			}
			default:
				System.out.println("Invalid Entry!!!");
				break;
			}
			ht.printTable();
			
			System.out.println("\nDo you want to continue(y/n): ");
			ch = sc.next().charAt(0);
		}
		while(ch=='y'|| ch == 'Y');
	}

}
