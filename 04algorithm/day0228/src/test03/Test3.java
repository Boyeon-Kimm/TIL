package test03;

public class Test3 {
	
	static char[] arr;
	static int n;
	
	public static void main(String[] args) {
		arr = new char[] {'\u0000', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '\u0000', '\u0000', 'H', 'I'};
		n = arr.length;
		traverse(1); // 1번 노드부터 순회 시작, 1번 노드부터 스택에 올리기
		
	}

	private static void traverse(int i) { // i번째 노드의 순회(인덱스)
		// 인덱스를 벗어나지 않는 조건
		if(i <= n - 1) {
			// 후위 순회
			
			// L : 왼쪽 트리로 탐색을 이어나감
			traverse(i * 2);
			
			// R : 오른쪽 트리로 탐색을 이어나감
			traverse(i * 2 + 1);
			
			// V : 자기 자신을 방문처리
			if(arr[i] != '\u0000') 
				System.out.print(arr[i] + " ");
		}
		
	}
}
