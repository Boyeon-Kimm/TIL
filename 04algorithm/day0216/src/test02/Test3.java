package test02;

import java.util.Arrays;

public class Test3 {
	public static void main(String[] args) {
		int[] arr = {5, 2, 4, 1, 2, 3, 3};
		
		// counting 배열
		// count[i] : i의 개수
		int[] count = new int[6]; // 인덱스 5까지 쓸 것이므로..
		
		for(int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		System.out.println(Arrays.toString(count));
		
		// 누적합 배열
		// prefix sum
		// prefix[i] = count[0] + count[1] + count[2] + ... + count[i];
		// suffix[i] = count[i] + count[i-1] + ... + count[n-2] + count[n-1];  
		
		// 굳이 배열을 하나 더 만들 필요가 없음(메모리..)
//		int[] prefix = new int[6];
//		prefix[0] = count[0];
//		for(int i = 1; i <= 5; i++) {
//			prefix[i] = prefix[i-1] + count[i];
//		}
		
		// 2단계
		// count 배열을 => prefix 배열로 사용
		for(int i = 1; i < 5; i++) {
			count[i] += count[i-1];
		}
		
		
		System.out.println(Arrays.toString(count));
	}
}
