package project.first.queue;

public class QueueProjectTest {

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
		Q.insert(16); Q.insert(17); Q.insert(18); Q.writeQue();  */   
		
	/*	RoundBufferQueue RB =new RoundBufferQueue(5);
		RB.writeQue();
		RB.insert(21); RB.insert(22); RB.insert(23); RB.insert(24); RB.writeQue();
		RB.insert(25);
		RB.delete(); RB.delete(); RB.delete(); ;RB.writeQue();
		RB.insert(25); RB.insert(26); RB.insert(27); RB.writeQue();  */   
		
	/*	RoundLinkedQueue RL = new RoundLinkedQueue();
		RL.writeQue();
		RL.delete();
		RL.insert(30); RL.insert(31); RL.insert(32); RL.insert(33); RL.insert(34); RL.writeQue();
		RL.delete(); RL.delete(); RL.writeQue();   */
		
	//	PriorLinkedQueue PLQ = new PriorLinkedQueue();
	    PriorLinkedQueue<Integer> PLQ = new PriorLinkedQueue<Integer>();
		PLQ.insert(40);  PLQ.insert(41);  PLQ.insert(48);  PLQ.insert(47); PLQ.insert(45);
		PLQ.insert(39); PLQ.insert(38); PLQ.insert(50); PLQ.insert(41);
		PLQ.writeQue();
		PLQ.delete();
		PLQ.writeQue(); System.out.println(PLQ.front());   
		
	}
}
