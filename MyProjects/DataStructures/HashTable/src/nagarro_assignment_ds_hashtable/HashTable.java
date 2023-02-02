package nagarro_assignment_ds_hashtable;

public class HashTable {
	int[] arr;
	int capacity;
	public HashTable(int capacity) {
		this.capacity=capacity;
		arr = new int[this.capacity];
	}
	
	public void insert(int ele) {
		arr[ele%capacity]=ele;
	}
	public void clear() {
		arr = new int[capacity];
	}
	
	public boolean contains(int ele) {
		return arr[ele%capacity]==ele;
	}
	public void delete(int ele) {
		if(arr[ele%capacity]==ele)
				arr[ele%capacity] =0;
		else
			System.out.println("\nError: Element not found ");
	}
	
	public void printTable() {
		System.out.println("\nHash Table is :");
		for(int i = 0;i<capacity;i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println();
	}
	
	

}
