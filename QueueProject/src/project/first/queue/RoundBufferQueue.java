package project.first.queue;

public class RoundBufferQueue implements Queue {
	
	private int n, count;
	private int front, rear;
	private int[] que;
	
	public RoundBufferQueue(int n) {
		this.n=n;
		count=0;
		que = new int[n];
		front=rear=n-1;
	}

	public void insert(int x) {
		/*
		 * Da bi front=rear ostao jedinstveni kriterijum praznog reda, ne
		 * dozvoljava se da red sa n elemenata ima vise od n-1 elemenata, pa je
		 * kriterijum punog reda front=(rear+1)%n
		 */

		rear = (rear + 1) % n;
		if (front == rear) {
			if (front == 0)
				rear = n - 1;
			else
				rear = rear - 1;
			// System.out.println("Overflow!");
			try {
				throw new OverflowQException();
			} catch (OverflowQException e) {
				System.out.println("Warning: " + e);
			}
		} else {
			System.out.println("Insert: " + x);
			que[rear] = x;
			count++;
		}

	}

	@SuppressWarnings("finally")
	public int delete() {
		if (front == rear) {
			// System.out.println("Underflow!");
			try {
				throw new UnderflowQException();
			} catch (UnderflowQException e) {
				System.out.println("Warning: " + e);
			} finally {
				return 0;
			}
		} else {
			front = (front + 1) % n;
			System.out.println("Delete: "+que[front]);
			count--;
			return que[front];
		}
	}

	public int front() {
		if (front == rear) {
			//System.out.println("Empty!");
			try {
				throw new EmptyQException();
			} catch ( EmptyQException e) {
				System.out.println("Warning: " + e);
				return 0;
			} 
		} else
			return que[front];
	}

	public void empty() {
		front=rear=n-1;
	}

	public void writeQue() {
		if(front<rear) {
			System.out.print("Print Queue: [ ");
			for(int i=front+1; i<=rear; i++) System.out.print(" "+que[i]);
			System.out.println(" ]");
		}
		else if(front>rear) {
			System.out.print("Print Queue: [ ");
			for(int i=front+1; i<=n-1; i++) System.out.print(" "+que[i]);
			for(int i=0; i<=rear; i++) System.out.print(" "+que[i]);
			System.out.print(" ]");
			System.out.println(" " + count + " elements");
		}
		else {//System.out.println("Queue is empty!");
			try {
				throw new EmptyQException();
			} catch ( EmptyQException e) {
				System.out.println("Warning: " + e);
			} 
		}
	}

	protected boolean isEmpty() {
		if(front==rear) return true;
		else return false;
	}
	
	protected boolean isFull() {
		if((rear+1)%n==front) return true;
		else return false;
	}
}
