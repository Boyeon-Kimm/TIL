package test01;

// 선형큐 구현 - 해결방법 1,
// deQueue를 할 때 모든 원소를 앞으로 한칸씩 당긴다.

public class Test2 {
	public static int n = 5;
	public static int[] arr = new int[n]; // n = 5;
	public static int front = -1, rear = -1;
	
	public static void main(String[] args) {
		
		// Queue : FIFO 순서
		
		enQueue(1);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		enQueue(5);
		print();
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		print();
		System.out.println(deQueue());
		print();
		
		// 이게 될까요?
		enQueue(6);
		print();
		System.out.println(size());
		
	}
	
	// enQueue(item) : 삽입
	public static void enQueue(int item) {
		if(isFull()) { // 포화상태라면
			System.out.println("큐에 더이상 값을 넣을 수 없습니다.");
		} else { // rear != n - 1 : 포화상태가 아닌 경우
			rear++;
			arr[rear] = item;
		}
	}
	
	// deQueue : 삭제
	public static int deQueue() {
		if(isEmpty()) { // 큐가 비어있다면 삭제 불가
			System.out.println("큐가 비어있어서 deQueue 안됨.");
			return -1;
		} else {
			// front를 늘리는 것이 아니라..
			// rear를 앞으로 당긴다.
			int temp = arr[front + 1]; // 임시변수에다가 현재 가장 앞에 있는 원소 저장
			// 모든 원소를 한 칸 앞으로 당기면서 덮어쓰기 한다
			for(int i = 0; i < rear; i++) {
				arr[i] = arr[i + 1];
			}
			rear--; // 삭제 완료
			
			// 삭제 원소를 반환
			return temp;
		}
	}
	
	// peek : 가장 첫번째 원소 확인(삭제 x, 반환 o)
	public static int peek() {
		if(isEmpty()) {
			System.out.println("큐가 비어있어서 peek이 안됨.");
			return -2;
		} else {
			return arr[front + 1]; // 삭제하지 않고, 현재 첫번째 원소를 반환
			// front + 1 : 현재 첫번째 원소의 idx
		}
	}
	
	// print : 현재 큐의 원소들 출력
	public static void print() {
		if(isEmpty()) {
			System.out.println("큐가 비어있어서 출력이 안돼요...");
		} else {
			// 어디서부터 어디까지?
			// 첫번째 원소부터 마지막 원소까지..
			for(int i = front + 1; i <= rear; i++) {
				System.out.printf("[%d]: %d ", i, arr[i]);
			}
			System.out.println();
		}
		
	}
	
	// isEmpty : 큐가 비어있는지
	public static boolean isEmpty() {
		return front == rear;
	}
	
	// isFull : 큐가 꽉차있는지(포화상태인지, 원소를 추가할 수 있는지)
	public static boolean isFull() {
		return rear == n - 1;
	}
	
	// size : 현재 큐의 원소의 개수
	public static int size() {
		return rear - front;
	}
}
