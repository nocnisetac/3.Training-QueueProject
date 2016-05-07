package project.first.queue;

public class RoundLinkedQueue implements Queue {
	
	private ListNode front, rear;
	private int count;
	
	public void insert(int x) {
		ListNode temp = new ListNode(x,null);
		if(rear==null) front=temp;
		else rear.next=temp;
		rear=temp;
		count++;
		System.out.println("Inserted: "+x);
	}

	@SuppressWarnings("finally")
	public int delete() {
		if(front!=null) {
			ListNode temp = front;
			if(front.next == null) front=rear=null;
			else front=front.next;
			System.out.println("Deleted: "+temp.i);
			count--;
			return temp.i;
		}
		else {
			//System.out.println("Underflow!");
			try {
				throw new UnderflowQException();
			} catch (UnderflowQException e) {
				System.out.println("Warning: " + e);
			} finally {
				return 0;
			}
		}
	}

	public int front() {
		if(front!=null) return front.i;
		else return 0;
	}

	public void empty() {
		front=rear=null;
	}

	public void writeQue() {
		if (front != null) {
			ListNode temp = front;
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
