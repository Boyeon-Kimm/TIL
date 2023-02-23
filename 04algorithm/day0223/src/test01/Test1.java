package test01;

// 원형큐
public class Test1 {
	public static int n = 5;
	public static int[] arr = new int[n];
	public static int front = 0, rear = 0;
	
	public static void main(String[] args) {
		enQueue(1);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		enQueue(5);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		enQueue(6);
		enQueue(7);
		enQueue(8);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		
	}
	
	public static boolean isEmpty() {
		return front == rear;
	}
	
	public static boolean isFull() {
		return (rear + 1) % n == front;
	}
	
	public static void enQueue(int item) {
		if(isFull()) {
			System.out.println("큐가 가득차서 더이상 원소를 넣을 수 없어요.");
		} else {
			rear = (rear + 1) % n;
			arr[rear] = item;
		}
	}
	
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("큐에 원소가 하나도 없어요.");
			return -1;
		} else {
			front = (front + 1) % n;
			return arr[front];
		}
	}
}
