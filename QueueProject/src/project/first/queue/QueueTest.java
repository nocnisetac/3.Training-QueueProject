package project.first.queue;

public class QueueTest {

	public static void main(String[] args) {
	/*	ArrayQueue Q = new ArrayQueue(5);
		Q.writeQue();
		Q.delete();
		Q.insert(6); Q.insert(7); Q.insert(8); Q.insert(9); Q.insert(10); Q.writeQue();
		Q.delete(); Q.insert(11); Q.delete(); Q.insert(12); Q.writeQue(); 
		Q.delete(); Q.delete();
		//Q.repack();
		Q.insert(13); Q.writeQue();
		Q.insert(14); Q.insert(15);
		Q.extend(3);
		Q.writeQue();
		Q.insert(16); Q.insert(17); Q.insert(18); Q.writeQue();   */
		
		RoundBufferQueue RQ =new RoundBufferQueue(5);
		RQ.writeQue();
		RQ.insert(21); RQ.insert(22); RQ.insert(23); RQ.insert(24); RQ.writeQue();
		RQ.insert(25);
		RQ.delete(); RQ.delete(); RQ.delete(); ;RQ.writeQue();
		RQ.insert(25); RQ.insert(26); RQ.insert(27); RQ.writeQue();
	}
}
