package linkedlist;

import linkedlist.exception.IndexNotFoundException;
import linkedlist.exception.NodeNotFoundException;

public class NodeList<T> {
	private Node<T> header;
	private int currentIndex;
	private Node<T> tempNode;
	
	public NodeList() {
		this.header = null;
		this.currentIndex = -1;
		this.tempNode = header;
	}
	
	public void addNode(T value) {
		if(this.currentIndex == -1) {
			addHeaderNode(value);
		}else if(this.currentIndex == 0) {
			addHeaderNextNode(value);
		}else {
			addLastNode(value);
		}
	}
	
	public void addNode(T value,int index) throws IndexNotFoundException {
		if(this.header == null) {
			addHeaderNode(value);
		}else if(index<0) {
			throw new IndexNotFoundException();
		}else if(this.currentIndex<index) {
			throw new IndexNotFoundException();
		}else if(index == 0) {
			addSpecificHeaderNode(value);
		} else {
			addSpecificNode(value,index);
		}
	}
	
	private void addSpecificHeaderNode(T value) {
		Node<T> resultNode = createNode(value,header);
		header.setPreviousNode(resultNode);
		this.header = resultNode;
		checkCurrentIndex();
		
	}

	private void addSpecificNode(T value,int index) {
		tempClear();
		int tempIndex = 0;
		do {
			if(tempIndex == index) {
				break;
			}else {
				tempIndex+=1;
			}
		} while(hasNext());
		Node<T> addedNode = createNode(tempNode.getPreviousNode(),value,tempNode);
		tempNode.getPreviousNode().setNextNode(addedNode);
		tempNode.setPreviousNode(addedNode);
		tempClear();
		checkCurrentIndex();
	}
	
	public void removeNode() throws IndexNotFoundException, NodeNotFoundException {
		Node<T> resultNode = getLastNode();
		resultNode.getPreviousNode().setNextNode(null);
		resultNode.setPreviousNode(null);
	}
	
	public void removeNode(int index) throws IndexNotFoundException, NodeNotFoundException {
		Node<T> resultNode;
		checkCurrentIndex();
		tempClear();
		if(index == 0) {
			resultNode = this.header.getNextNode();
			resultNode.setPreviousNode(resultNode);
			this.header.setNextNode(null);
			this.header = resultNode;
		}else if(this.currentIndex == index) {
			this.removeNode();
		}else if(index>this.currentIndex){
			throw new IndexNotFoundException();
		}else if(index<0){
			throw new IndexNotFoundException();
		}else {
			resultNode = findNode(index);
			resultNode.getPreviousNode().setNextNode(resultNode.getNextNode());
			resultNode.getNextNode().setPreviousNode(resultNode.getPreviousNode());
			resultNode.setNextNode(null);
			resultNode.setPreviousNode(null);
		}
		checkCurrentIndex();
		tempClear();
		
	}
	
	private void addHeaderNode(T value){
		this.header = createNode(value,null);
		checkCurrentIndex();
	}
	
	private void addHeaderNextNode(T value) {
		header.setNextNode(createNode(header,value,null));
		checkCurrentIndex();
		tempClear();
	}
	
	
	private void checkCurrentIndex() {
		tempClear();
		int tempIndex = 0;
		while(hasNext()) {
			tempIndex += 1;
		}
		this.currentIndex = tempIndex;
		tempClear();
	}

	private void addLastNode(T value) {
		while(hasNext());
		tempNode.setNextNode(createNode(tempNode,value,null));
		checkCurrentIndex();
		tempClear();
	}
	
	
	public Node<T> getLastNode() throws IndexNotFoundException, NodeNotFoundException {
		return findNode(this.currentIndex);
	}
	
	public Node<T> getFirstNode() {
		return header;
	}
	
	public Node<T> findNode(int index) throws IndexNotFoundException, NodeNotFoundException {
		tempClear();
		checkCurrentIndex();
		if(index<0) {
			throw new IndexNotFoundException();
		}
		int tempIndex = 0;
		do {
			if(index == tempIndex) {
				Node<T> resultNode = tempNode;
				tempClear();
				return resultNode;
			}else {
				tempIndex += 1;
			}
		}while(hasNext());
		throw new NodeNotFoundException();
	}
	
	
	private Node<T> createNode(Node<T> previusNode, T value, Node<T> nextNode) {
		return new Node<T>(previusNode,value,nextNode);
	}
	private Node<T> createNode(T value, Node<T> nextNode) {
		return new Node<T>(value,nextNode);
	}
	
	private boolean hasNext() {
		if(this.tempNode.getNextNode() == null) {
			return false;
		}else {
			this.tempNode = this.tempNode.getNextNode();
			return true;
		}
	}
	
	private void tempClear() {
		this.tempNode = header;
	}
	
	public int getLength() {
		checkCurrentIndex();
		return this.currentIndex;
	}
	
	public void clearCache() {
		tempClear();
		checkCurrentIndex();
	}
	
	public boolean isEmpty() {
		if(this.header == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void print() {
		do {
			System.out.println("Node :"+tempNode);
			System.out.println("Previous Node :"+tempNode.getPreviousNode());
			System.out.println("Value :"+tempNode.getValue());
			System.out.println("Next Node :"+tempNode.getNextNode());
			System.out.println();
		}while(hasNext());
	}
}
