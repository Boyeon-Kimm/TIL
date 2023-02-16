package test02;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		int[] arr = {5, 2, 4, 1, 2, 3, 3};
		
		// counting 배열
		// count[i] : i의 개수
		int[] count = new int[6]; // 인덱스 5까지 쓸 것이므로..
		
		for(int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		System.out.println(Arrays.toString(count));
	}
}
