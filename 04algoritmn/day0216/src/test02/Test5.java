package test02;

import java.util.Arrays;

public class Test5 {
	public static void main(String[] args) {
		int[] arr = {5, 2, 4, 1, 2, 3, 3};
		System.out.println(Arrays.toString(arr));
		
		// 0단계
		// 주어진 배열 arr에서 최댓값을 찾는다.
		// 그 수를 이용해서 카운팅 배열을 만든다.
		
		// 최댓값
		int k = -1;
		for(int i = 0; i < arr.length; i++) {
			if(k < arr[i])
				k = arr[i];
		}
		
		// 1단계
		// counting 배열
		// count[i] : i의 개수
		int[] count = new int[k+1];
		
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
		for(int i = 1; i <= 5; i++) {
			count[i] += count[i-1];
		}
		System.out.println(Arrays.toString(count));
		
		// 3단계
		// arr 배열을 다시 돌면서,
		// 새로운 배열의 새로운 좌표에 옮긴다.
		int[] arr2 = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			// 새로운 배열에 새로운 위치에 원래의 숫자를 넣어준다
			// for문으로 돌리면 시간이 오래걸림. 인덱스로 접근하여 정렬
			arr2[count[arr[i]] - 1] = arr[i];
			// 한번 쓸 때마다 하나씩 줄이기
			count[arr[i]]--;
		}
		System.out.println(Arrays.toString(arr2));
		
		System.out.println(Arrays.toString(count));
	}
}
