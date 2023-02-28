package test02;

public class Test1 {
	public static void main(String[] args) {
		char[] arr = { '\u0000', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
	
		int parent = 1;
		int left = parent * 2;
		int right = 2 * parent + 1;
		
		System.out.printf("idx : %d. node: %c\n", left, arr[left]);
		System.out.printf("idx : %d. node: %c\n", right, arr[right]);
		
		int leftChild = 8;
		int parent2 = leftChild / 2; // 부모를 알 수 있다
	}
}
