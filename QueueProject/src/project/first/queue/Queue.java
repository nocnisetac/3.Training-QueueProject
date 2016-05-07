package project.first.queue;

public interface Queue {
	/* Atributi podrazumevano satic final, metode podrazumevano apstraktne, sve je podrazumevano public */
	
	void insert(int x);
	int delete();
	
	int front();
	void empty();
	
	default void repack() {
		System.out.println("Repack is useless!");
	}
	void writeQue();
}
