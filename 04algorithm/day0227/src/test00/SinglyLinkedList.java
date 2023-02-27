package test00;

public class SinglyLinkedList {
	// 연결리스트는 head만 저장하고 있으면 됨
	public Node head;
	
	public SinglyLinkedList() {
		
	}
	// 가장 마지막에 추가 : addToEnd
	
	// 가장 처음에 추가 : addToStart
	// 특정 값을 갖는 노드 다음에 추가: addAfter
	// 특정 값을 갖는 노드를 반환: getNode
	// 가장 마지막에 있는 노드 삭제: deleteLast
	// 가장 처음에 있는 노드 삭제: deleteStart
	// 특정 값을 갖는 노드 다음 노드 삭제: deleteAfter
	// 리스트를 순회해서 출력: printList
	
	public void addToEnd(int data) {
		// 새로운 노드를 생성
		Node n = new Node(data);
		
		// 리스트가 비어있는지 여부 먼저 체크
		if(head == null) { // 리스트가 비어있다면
			head = n;
		} else {
			// 가장 마지막 노드 찾기
			Node curr = head; // 임시 변수 curr에다가 가장 첫번째 노드의 주소값을 저장해 놓고 시작
			while(curr.next != null) { // 그 다음 노드가 있다면
				curr = curr.next; // 그 다음 노드로 이동
			}
			// while문이 끝났다면?
			// curr.next == null
			// curr => 가장 마지막 노드를 가리키고 있는 상태
			
			
			// 가장 마지막 노드의 다음에 새로운 노드를 추가
			curr.next = n;
		}
	}
	
	public void addToStart(int data) {
		// 새로운 노드 만들기
		Node n = new Node(data);
		// 현재 첫번째 노드는 head를 통해서만 접근 가능..
		// 현재 첫번째 노드는 두번째 노드가 되어야 함..
		// 새로운 노드.next <= 현재 첫번째 노드의 주소값(head)
		n.next = head;
		// head가 새로운 노드 가리키도록 하기
		// head <= 새로운 노드의 주소값
		head = n;
	}
	
	// target이라는 값을 갖는 노드의 주소값을 반환
	public Node getNode(int target) {
		Node curr = head;
		while(curr != null) {
			if(curr.data == target) {
				return curr;
			}
			curr = curr.next;
		}
		return null; // 노드를 찾지 못했다면 null을 반환
	}
	
	// target이라는 값을 갖는 노드를 찾아서
	// 그 다음에 data라는 값을 갖는 노드 삽입
	public void addAfter(int target, int data) {
		Node targetNode = getNode(target);
		if(targetNode != null) { // 노드를 찾았다면
			Node n = new Node(data);
			n.next = targetNode.next;
			targetNode.next = n;
		}
		
	}
	
	
	// 가장 마지막 노드 삭제
	public Node deleteLast() {
		Node curr = head;
		// 리스트가 비어있거나 1개만 있는 경우
		if(curr == null || curr.next == null) {
			head = null;
			return curr;
		}
		
		// 리스트가 2개 이상인 경우
		Node nextNode = curr.next;
		while(curr.next != null) {
			if(nextNode.next == null) { // nextNode가 마지막 노드이면
				curr.next = null;
				break;
			} // nextNode가 마지막 노드가 아니면
			curr = curr.next; // curr를 다음노드로
			nextNode = nextNode.next; // 그 다음노드로
		}
		return nextNode;
	}
	
	public Node deleteStart() {
		if(head != null) { // 리스트가 비어 있지 않다면
			Node toDelete = head; // 첫번째 노드 임시 저장
			head = head.next; // head가 그 다음 노드를 가리키도록 함
			return toDelete;
		}
		return null;
	}
	
	public Node deleteAfter(int target) {
		// targetNode 찾기
		Node targetNode = getNode(target);
		Node toDelete = null;
		
		if(targetNode != null) {
			toDelete = targetNode.next;
		}
		
		//targetNode의 다음 노드가 있다면
		if(toDelete != null) {
			targetNode.next = toDelete.next;
		}
		
		return toDelete;
	}
	
	public void printList() {
		Node curr = head;
		System.out.print("LinkedList[head:");
		
		while(curr != null) {
			System.out.print(curr.data+"->");
			curr = curr.next;
		}
		System.out.println("]");
	}
	
}











