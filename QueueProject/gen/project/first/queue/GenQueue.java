package project.first.queue;

public interface GenQueue<T extends Comparable<T>> {
/* Atributi podrazumevano satic final, metode podrazumevano apstraktne, sve je podrazumevano public */
	
	void insert(T x);
	T delete();
	
	T front();
	void empty();
	
	default void repack() {
		System.out.println("Repack is useless!");
	}
	void writeQue();
}
