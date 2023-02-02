package nagarro_assignments_ds_queue;

public class Queue {
	int size;
	static node front = null;
	static node rear = null;
	Queue(){
		this.size=0;
	}
	class node{
		int data;
		node next;
		node(int data){
			this.data = data;
			this.next = null;
			size++;
		}
	}
	
	public static boolean isEmpty() {
		return front == null && rear == null;
	}
	
	public void enqueue(int data) {
		node newNode = new node(data);
		if(rear == null) {
			rear = front =newNode;
		}
		rear.next =newNode;
		rear = newNode;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Empty Queue");
			return -1;
		}
		if(front==rear) {
			rear = null;
		}
		size--;
		int temp = front.data;
		front= front.next;
		return temp;	
	}
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
		}
		return front.data;
	}
	
	public void contains(int num) {
		while(front!=null) {
			if(front.data == num) {
				System.out.println("Queue contains element");
			}
			front= front.next;
		}
		
	}
	
	public int size() {
		return size;
	}
	
	public void centre() {
		node first = front;
		node second = front;
		while(second!=null && second.next != null) {
			first = first.next;
			second = second.next.next;
		}
		System.out.println("The element at centre is "+first.data);
	}
	
	public void iterator(int index) {
		node temp = front;
		int count = 0;
		while(temp!=null) {
			if(count == index) {
				System.out.println("Element at "+index+"position is: "+temp.data);
			}
			count++;
			temp = temp.next;
		}
		
	}
	
	public void reverse() {
		if(front==null|| front.next==null) {
			return;
		}
		node prev = front;
		node currNode = front.next;
		while(currNode!=null) {
			node nextNode = currNode.next;
			currNode.next = prev;
			
			prev = currNode;
			currNode = nextNode;
		}
		front.next = null;
		front = prev;
	}
	
	public void sort() {
		node curr = front;
		node index = null;
		int temp;
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return;
		}
		while(curr!=null) {
			index = curr.next;
			while(index!=null) {
				if(curr.data>index.data) {
					temp = curr.data;
					curr.data = index.data;
					index.data = temp;
				}
				index = index.next;
			}
			curr = curr.next;
		}
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		node currNode = front;
		while(currNode!=null) {
			System.out.print(currNode.data+"<-");
			currNode = currNode.next;
		}
	}

	
	
	

}
