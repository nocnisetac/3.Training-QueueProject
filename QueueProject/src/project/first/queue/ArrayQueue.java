package project.first.queue;

public class ArrayQueue implements Queue{
	private int front, rear, n, count;
	private int[] que;
	
	public ArrayQueue (int n){
		this.n = n;
		count=0;
		que = new int[n];
		front = rear = -1;
	}
	
	public void insert(int x){
		if (this.isFull()) {
			if(front>=0) {
				this.repack();
				System.out.println("Insert: "+x);
				que[++rear]=x;
				count++;
			}
			else {//System.out.println("Overflow!");
				try {
				 throw new OverflowQException();
				} catch(OverflowQException e) {System.out.println("Warning: "+e);}
			}
		}
		else { 
			System.out.println("Insert: "+x);
			que[++rear]=x;
			count++;
		}
	}
	

	@SuppressWarnings("finally")
	public int delete() {
		if (this.isEmpty()) {
			// System.out.println("Underflow!");
			try {
				throw new UnderflowQException();
			} catch (UnderflowQException e) {
				System.out.println("Warning: " + e);
			} finally {
				return 0;
			}
		} else {
			System.out.println("Delete: " + que[front + 1]);
			count--;
			return que[++front];
		}
	}

	@SuppressWarnings("finally")
	public int front() {
		if (this.isEmpty()) {
			// System.out.println("Empty!"); return 0;
			try {
				throw new EmptyQException();
			} catch (EmptyQException e) {
				System.out.println("Warning: " + e);
			} finally {
				return 0;
			}
		} else
			return que[front];
	}
	
	public void empty(){
		front=rear=-1;
	}
	
	protected boolean isEmpty() {
		if(front==rear & front==-1) return true;
		else return false;
	}
	
	protected boolean isFull() {
		if(rear==n-1) return true;
		else return false;
	}
	
	public void repack(){
		for(int i=0; i<rear-front; i++) que[i]=que[i+front+1];
		rear=rear-front-1;
		front=-1; 
		System.out.println("Queue repacked!");
	}
	
	protected void extend(int e){
		int[] temp = new int[n+e];
		for(int i=0; i<=n-1; i++) temp[i]=que[i]; 
		que = temp;
		n=n+e;
		System.out.println("Queue extended:"+" ("+e+")");
	}
	
	public void writeQue() {
		if(this.isEmpty()) {
			//System.out.println("Queue is empty!");
			try {
				throw new EmptyQException();
			} catch ( EmptyQException e) {
				System.out.println("Warning: " + e);
			}
		}
		else {
			System.out.print("Print Queue [");
			for(int i = front+1; i<=rear; i++) System.out.print(" "+que[i]);
			System.out.print(" ]");
			System.out.println(" " + count + " elements");
		}
	}
}
