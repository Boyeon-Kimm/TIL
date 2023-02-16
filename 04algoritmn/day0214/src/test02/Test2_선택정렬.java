package test02;

import java.util.Arrays;

public class Test2_선택정렬 {
	public static void main(String[] args) {
		int[] A = {5, 4, 3, 2, 1};
		int n = A.length;
		
		// 패스는 n-1회 반복
		for(int i = 0; i < n-1; i++) {
			// 매 패스에서 첫번째 원소를
			// 최소값이라고 가정하고
			int minIdx = i;
			// 그 다음 원소부터 마지막 원소까지 비교해나감
			for(int j = i + 1; j < n; j++) {
				if(A[j] < A[minIdx]) {
					minIdx = j;
				}
			}
			
			// swap
			int temp = A[minIdx];
			A[minIdx] = A[i];
			A[i] = temp;
			System.out.printf("%d번째 패스: %s\n", i+1, Arrays.toString(A));
		}
		System.out.println(Arrays.toString(A));
	}
}
