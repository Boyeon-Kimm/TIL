package test02;

public class Test1_Babygin {
	// 문제에 접근할 때는..
	// divide and conquer
	// 분할정복
			
	public static void main(String[] args) {
		// 3개 짜리
		int[] arr = {5, 5, 5};
		
		// 서로 다른 n개 중에서 3개 뽑는 순열.
		// => 서로 다른 n개 중에서 r개 뽑는 순열은?
		
		for(int i = 0; i < arr.length; i++) {
			// i는? 마음대로 쓸 수 있음..
			for(int j = 0; j < arr.length; j++) {
				// j는? i 빼고
				if(j != i) {
					// k는? i, j 빼고
					for(int k = 0; k < arr.length; k++) {
						if(k != i && k != j) {
							// 여기에서 모든 경우의 수가 만들어짐.
							// 첫번째 숫자: arr[i] / 두번째 숫자: arr[j] / 세번째 숫자: arr[k]
//							if(runCheck(arr[i], arr[j], arr[k]))
//								System.out.println("run");
//							System.out.printf("%d, %d, %d => %s\n", arr[i], arr[j], arr[k], runCheck(arr[i], arr[j], arr[k]));
							System.out.printf("%d, %d, %d => %s\n", arr[i], arr[j], arr[k], tripletCheck(arr[i], arr[j], arr[k]));
						}
					}
				}
			}
		}
	}
	// run을 체크하는 메서드
	// - 임의의 숫자 3개가 주어질 때, 연속 여부를 판단.
	static boolean runCheck(int a, int b, int c) {
		// b == a + 1, c == a + 2
		// b == a + 1, c == b + 1
		return b == a + 1 && c == a + 2;
	}
	
	// triplet을 체크하는 메서드
	// - 임의의 숫자 3개가 주어질 때, 일치 여부 판단.
	static boolean tripletCheck(int a, int b, int c) {
		return a == b && a == c;
	}
	
	
}
