package project.first.queue;

public class DListNode<T extends Comparable<T>> {
	public T i;
	public DListNode<T> prev, next;
	public DListNode(T e) {
		i=e; prev=null; next=null;
	}
}
