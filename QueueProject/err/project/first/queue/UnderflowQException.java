package project.first.queue;

public class UnderflowQException extends QueueException {
	public String toString() {
		return "Queue underflow !";
	}
}
