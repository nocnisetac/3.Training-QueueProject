package project.first.queue;

public class TestThread extends Thread {
	public int i;
	public PriorLinkedQueue<Integer> PLQ;
	public TestThread(int i, PriorLinkedQueue<Integer> plq) {
		super("Test");
		this.i=i;
		PLQ=plq;
		start();
	}
	public void run() {
		for(int j = 0; j<2; j++) {
			PLQ.insert(100*i+j); PLQ.delete();
			try {
				Thread.sleep(i*1000);
				System.out.println("Thread No"+i+" paused.");
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			PLQ.insert(100*i+j+1);
			PLQ.delete();
		} 
	}
}
