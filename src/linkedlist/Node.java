package linkedlist;

public class Node<T> {
	
	private Node<T> previousNode;
	private T value;
	private Node<T> nextNode;
	
	public Node(Node<T> previusNode,T value, Node<T> nextNode) {
		this.previousNode = previusNode;
		this.value = value;
		this.nextNode = nextNode;
	}
	
	public Node(T value, Node<T> nextNode) {
		this.previousNode = this;
		this.value = value;
		this.nextNode = nextNode;
	}

	public Node<T> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node<T> backNode) {
		this.previousNode = backNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}	
}
