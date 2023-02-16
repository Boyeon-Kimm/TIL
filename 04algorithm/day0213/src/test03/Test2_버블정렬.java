package test03;

import java.util.Arrays;

public class Test2_버블정렬 {
	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1};
		int n = arr.length;
		
		System.out.println("시작 전: "+Arrays.toString(arr));
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.printf("%d번째 패스 결과: %s\n", i+1, Arrays.toString(arr) );
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
