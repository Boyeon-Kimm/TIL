package homework;
import java.util.Scanner;

public class Swea1231_중위순회 {
	static int N;
	static String[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 10번의 테스트 케이스
		for(int tc = 1; tc <= 10; tc++) {
			// 트리가 갖는 정점의 총 수
			N = Integer.parseInt(sc.nextLine());
			// 정점의 번호가 1부터 시작하여 배열 1개 추가
			arr = new String[N + 1];
			// N줄에 걸쳐 각각의 정점 정보 입력
			for(int info = 1; info <= N; info++) {
				// 알파벳만 사용할 것이므로 배열의 1번째 인덱스만 사용
				String[] str = sc.nextLine().split(" ");
				arr[info] = str[1];
				
 			}
			System.out.print("#" + tc + " ");
			traverse(1);
			System.out.println();
		}
	}
	
	// 중위 순회
	private static void traverse(int i) {
		if(i <= N) {
			// 왼쪽 트리 탐색
			traverse(i * 2);
			// 자기 자신을 방문 처리
			if(arr[i] != " ") System.out.print(arr[i]);
			// 오른쪽 트리 탐색
			traverse(i * 2 + 1);
		}
	}
}
