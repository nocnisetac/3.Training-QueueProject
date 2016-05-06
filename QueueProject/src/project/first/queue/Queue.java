package project.first.queue;

public interface Queue {
	/* Atributi podrazumevano satic final, metode podrazumevano apstraktne, sve je podrazumevano public */
	
	void insert(int x);
	int delete();
	
	int front();
	void empty();
	boolean isEmpty();
	boolean isFull();
	
	void repack();
	void extend(int e);
	void writeQue();
}
