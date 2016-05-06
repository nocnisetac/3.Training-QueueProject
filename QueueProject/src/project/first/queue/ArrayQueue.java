package project.first.queue;

public class ArrayQueue implements Queue{
	private int front, rear, n;
	private int[] que;
	public ArrayQueue (int n){
		this.n = n;
		que = new int[n];
		front = rear = -1;
	}
	public void insert(int x){
		if (this.isFull()) {
			if(front>=0) {
				this.repack();
				System.out.println("Insert: "+x);
				que[++rear]=x;
			}
			else System.out.println("Overflow!");
		}
		else { 
			System.out.println("Insert: "+x);
			que[++rear]=x;
		}
	}
	public int delete () {
		if(this.isEmpty()) { System.out.println("Underflow!"); return 0;}
		else {
			System.out.println("Delete: "+que[front+1]);
			return que[++front];
		}
	}
	public int front() {
		if(this.isEmpty()) { System.out.println("Empty!"); return 0;}
		else return que[rear];
	}
	public void empty(){
		front=rear=-1;
	}
	public boolean isEmpty() {
		if(front==rear & front==-1) return true;
		else return false;
	}
	public boolean isFull() {
		if(rear==n-1) return true;
		else return false;
	}
	public void repack(){
		for(int i=0; i<rear-front; i++) que[i]=que[i+front+1];
		rear=rear-front-1;
		front=-1; 
		System.out.println("Queue repacked!");
	}
	public void extend(int e){
		int[] temp = new int[n+e];
		for(int i=0; i<=n-1; i++) temp[i]=que[i]; 
		que = temp;
		n=n+e;
		System.out.println("Queue extended:"+" ("+e+")");
	}
	public void writeQue() {
		if(this.isEmpty()) System.out.println("Queue is empty!");
		else {
			System.out.print("Print Queue [");
			for(int i = front+1; i<=rear; i++) System.out.print(" "+que[i]);
			System.out.println(" ]");
		}
	}
}
