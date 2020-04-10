package mains;

import linkedlist.Node;
import linkedlist.NodeList;
import linkedlist.exception.IndexNotFoundException;
import linkedlist.exception.NodeNotFoundException;

public class LinkedListMain {

	public static void main(String[] args) {
		NodeList<String> nodeList = new NodeList<String>();
		
		nodeList.addNode("Deneme 1");
		nodeList.addNode("Deneme 2");
		nodeList.addNode("Deneme 3");
		nodeList.addNode("Deneme 4");
		nodeList.addNode("Deneme 5");
		nodeList.addNode("Deneme 6");
		nodeList.addNode("Deneme 7");
		nodeList.addNode("Deneme 8");
		nodeList.addNode("Deneme 9");
		nodeList.addNode("Deneme 10");
		Node<String> node = null;
		try {
			nodeList.addNode("Erkan",0);
			nodeList.removeNode(nodeList.getLength());
		} catch (IndexNotFoundException e) {
			e.printStackTrace();
		} catch (NodeNotFoundException e) {
			e.printStackTrace();
		}
		
		while(nodeList.hasNext()) {
			node = nodeList.next();
			System.out.println("Node :"+node);
			System.out.println("Previous Node :"+node.getPreviousNode());
			System.out.println("Value :"+node.getValue());
			System.out.println("Next Node :"+node.getNextNode());
			System.out.println();
		}
		
	}
}
