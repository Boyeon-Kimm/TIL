package homework;

import java.util.Scanner;

public class Hw01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 방의 고정된 길이 100만큼 배열 생성
		int[] arr = new int[100];
		// 가장 큰 낙차를 구하기 위한 최댓값 변수
		int max = 0;
		
		// 배열에 상자 높이 입력하기
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 낙차 구하기
		// arr[0]부터 arr[98]까지 상자의 높이가
		// 현재 상자보다 뒤따르는 낮은 상자들만 count세기.
		for(int i = 0; i < arr.length-1; i++) {
			// 낙차 계산할 변수 선언
			int count = 0;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) count++;
			}
			// 각 배열에 count로 값 재할당
			arr[i] = count;
		}

		// 가장 큰 낙차를 구하기 위해 최댓값 구하기
		for(int i = 0; i < arr.length-1; i++) {
			max = Math.max(max, arr[i]);
		}
		System.out.println(max);
	}
}
