package test02_연결큐;

public class Node {
	public int data; // 데이터
	public Node next; // 다음 노드의 주소값
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	
}
