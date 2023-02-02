package naagrro_assignments_ds_priorityQueue;

public class PriorityQueue {
	static class node{
		int data;
		int priority;
		node next;
	}
	static node nod = new node();
	static node newNode(int d, int p) {
		node temp = new node();
		temp.data = d;
		temp.priority = p;
		temp.next = null;
		return temp;
	}
	static int peek(node head) {
		return head.data;
	}
	static node dequeue(node head) {
		node temp = head;
		head = head.next;
		return head;
	}
	static node enqueue(node head,int d, int p) {
		node start = head;
		node temp = newNode(d,p);
		if(head.priority<p) {
			temp.next = head;
			head = temp;
		}
		else {
			while(start.next!=null && start.next.priority>p) {
				start = start.next;
			}
			temp.next = start.next;
			start.next = temp;
		}
		return head;
	}
	
	static int isEmpty(node head) {
		return ((head)==null)?1:0;
	}
	
	public static void main(String[] args) {
		node pq = newNode(4,1);
		pq = enqueue(pq,10,2);
		pq = enqueue(pq,11,3);
		pq = enqueue(pq,12,0);
		while(isEmpty(pq)==0) {
			System.out.println(peek(pq));
			pq = dequeue(pq);
		}
	}

}
