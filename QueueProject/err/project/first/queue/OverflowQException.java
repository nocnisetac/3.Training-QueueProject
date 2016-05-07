package project.first.queue;

public class OverflowQException extends QueueException {
	public String toString() {
		return "Queue overflow !";
	}
}
