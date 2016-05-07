package project.first.queue;

public class RoundBufferQueue implements Queue {
	
	private int n;
	private int front, rear;
	private int[] que;
	
	public RoundBufferQueue(int n) {
		this.n=n;
		que = new int[n];
		front=rear=n-1;
	}

	public void insert(int x) {
		/* Da bi front=rear ostao jedinstveni kriterijum praznog reda, ne dozvoljava se da red sa n 
		 * elemenata ima vise od n-1 elemenata, pa je kriterijum punog reda front=(rear+1)%n         */
		
		rear=(rear+1)%n;
		if(front==rear) {
			if(front==0) rear=n-1;
			else rear=rear-1;
			System.out.println("Overflow!");
		}
		else {
			System.out.println("Insert: "+x);
			que[rear]=x;
		}

	}

	public int delete() {
		if(front==rear) {
			System.out.println("Underflow!");
			return 0;
		}
		else {
			front=(front+1)%n;
			System.out.println("Delete: "+que[front]);
			return que[front];
		}
	}

	public int front() {
		if(front==rear) { System.out.println("Empty!"); return 0;}
		else return que[front];
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
			System.out.println(" ]");
		}
		else System.out.println("Queue is empty!");

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
