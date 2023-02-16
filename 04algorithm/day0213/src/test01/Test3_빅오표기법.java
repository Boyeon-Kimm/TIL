package test01;

public class Test3_빅오표기법 {
	public static void main(String[] args) {
		// 1. 입력의 개수 n개가 주어질 때 연산량의 개수를 센다.
		// 다음 코드의 연산의 개수는?
		int N = 10;
		for(int i=0; i<N; i++) {
			System.out.println(i);
		}
		// O(n)

		
		
		// 2. 최고차항(가장 증가속도가 빠른 항)만을 계수 없이 나타낸다.
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				sum += j + i;
			}
			System.out.println(sum);
		}
		// O(n^2)
		
		
		// 3. 빅오 표기법은 최악의 경우를 가정한다.
		//  - 최악의 경우란? 연산량이 가장 많은 경우, 시간이 가장 오래걸리는 경우
		//  - ex) 다음 배열에서 특정한 수를 찾는 알고리즘의 시간 복잡도는?
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int target_num = 1;
		for(int i=0; i<arr.length; i++) {
			if (arr[i] == target_num)
				break;
		}
		
		// 최선의 경우(가장 우호적인 경우) : 1, 2 => O(1) => 오메가(1) 
		// 평균적인 경우 : 5,6 => O(n/2) => O(n) => 세타(n)
		// 최악의 경우: 9, 10 => O(n)

		
	}
}
