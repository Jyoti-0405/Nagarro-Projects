package nagarro_data_structures_LL;

public class LinkedList {
	class Node{
		int val;
		Node next;
		
		Node(int val){
			this.val = val;
		}
	}
	static Node head;
	static Node tail;
	
	public void addFirst(int val) {
		if(isEmpty()) {
			head = new Node(val);
			tail = head;
			return;
		}
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;	
	}
	
	
	public void addPos(int pos,int val) {
		if(pos == 1) {
			addFirst(val);
			return;
		}
		Node current = head;
		int count = 1;
		while(count<pos-1) {
			count++;
			current = current.next;
		}
		Node newNode = new Node(val);
		newNode.next = current.next;
		current.next = newNode;	
	}
	
	public int deleteFirst() {
		if(isEmpty()) {
			throw new RuntimeException("List is Empty: ");
		}
		Node current = head;
		head = head.next;
		current.next = null;
		if(isEmpty()) {
			tail = null;
		}
		return current.val;
	}
	public int deletePos(int pos) {
		if(isEmpty()) {
			throw new RuntimeException("List is Empty");
		}
		if(pos == 1) {
			deleteFirst();
		}
		Node current = head;
		Node prev = null;
		int count = 1;
		while(count<pos) {
			count++;
			prev = current;
			current = current.next;
		}
		prev.next =  current.next;
		current.next = null;
		return current.val;
	}
	public int size() {
		Node current = head;
		int count = 0;
		if(current == null) {
			return count;
		}
		while(current!= null) {
			count++;
			current= current.next;
		}
		return count;
		
	}
	public void Sort() {
		Node current = head;
		Node index = null;
		int temp;
		if(head == null) {
			return;
		}
		else {
			while(current!=null) {
				index = current.next;
				while(index!=null) {
					if(current.val>index.val) {
						temp = current.val;
						current.val = index.val;
						index.val = temp;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
		
	}
	
	public void centre() {
		Node slow = head;
		Node fast = head;
		if(head!=null) {
			while(fast != null&& fast.next!=null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			System.out.println("The centre element is ["+slow.val+"]");
		}
	}
	
	public void reverse() {
		Node rev = null;
		Node current = head;
		//Node next = null;
		while(current!=null) {
			Node next = current.next;
			current.next = rev;
			rev = current;
			current = next;
		}
		head = rev;	
	}
	
	
	public boolean isEmpty() {
		return head == null;	
	}
	
	
	public void print() {
		Node current = head;
		
		while(current!= null) {
			System.out.print(current.val +"->");
			current = current.next;
		}
		System.out.println();
	}

}
