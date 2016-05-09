package project.first.queue;

public class PriorLinkedQueue <T extends Comparable<T>> implements GenQueue <T> {
	// Prioritetni red: elementi se umecu proizvoljno, ali se pri brisanju uvek uklanja najveci.
	
	private DListNode<T> front, rear;
	private int count;
	
	public void insert(T x) {
		DListNode<T> novi = new DListNode<T>(x);
		DListNode<T> temp = front;
		while (true) {
			if (front == null) {   // Ubacivanje u praznu listu
				front = rear = novi;
				break;
			}
			if (temp.i.compareTo(x)<0 | temp.i.compareTo(x)==0) {             
				if (temp.next == null) {  // Novi ide na kraj liste
					rear.next = novi;
					novi.prev = rear;
					rear = novi;
					break;
				} else {                  // Trazi dalje
					temp = temp.next;
				}
			} else {
				if (temp == front) {      // Novi ide na pocetak liste
					novi.next = front;
					front.prev = novi;
					front = novi;
					break;
				} else {                   // novi ide negde u sredinu, ispred temp
					temp.prev.next = novi;
					novi.prev = temp.prev;
					novi.next = temp;
					temp.prev = novi;
					break;
				}
			}
		}
		count++;
		System.out.println("Inserted: " + x);
	}
	
	
	public T delete() {
		if(front==null) {
			try {
				throw new UnderflowQException();
			} catch (UnderflowQException e) {
				System.out.println("Warning: " + e);
				return null;
			} 
		} else {
			DListNode<T> temp=null;
			temp=rear;
			count--;
			if(rear.prev!=null) {
				rear=rear.prev; rear.next=null;
				temp.prev=null;
				return temp.i;
			} else {
				front=rear=null;
				return temp.i;
			}
		}
	}
	
	public T front() {
		if(front==null) {
			try {
				throw new UnderflowQException();
			} catch (UnderflowQException e) {
				System.out.println("Warning: " + e);
				return null;
			} 
		} else {
				return front.i;
		}
	}
	public void empty() {
		front=rear=null;
	}
	
	public void writeQue() {
		if (front != null) {
			DListNode<T> temp = front;
			System.out.print("Print Queue: [");
			while (temp != null) {
				System.out.print(" " + temp.i);
				temp = temp.next;
			}
			System.out.print(" ]");
			System.out.println(" " + count + " elements");
		} else {
			// System.out.println("Empty Queue!");
			try {
				throw new EmptyQException();
			} catch (EmptyQException e) {
				System.out.println("Warning: " + e);
			}
		}
	}          

}
