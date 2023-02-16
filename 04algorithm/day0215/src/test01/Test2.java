package test01;

public class Test2 {
	public static void main(String[] args) {
		// 배열의 숫자 중에서
		// 3개를 뽑아 나열하는 순열
		
		int[] arr = {12, 5, 28, 9};
		
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
							System.out.printf("%d, %d, %d\n", arr[i], arr[j], arr[k]);
						}
					}
				}
			}
		}
	}
}
