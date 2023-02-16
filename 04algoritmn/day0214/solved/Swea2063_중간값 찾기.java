package homework;

import java.util.Scanner;

public class Swea2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력받을 점수의 개수
		int N = sc.nextInt();
		// N개의 점수들을 넣을 배열
		int[] scores = new int[N];
		
		// 반복문을 이용하여 N개의 점수 배열에 입력
		for(int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
		}
		
		// 최소값 순으로 정렬
		for(int i = 0; i < scores.length-1; i++) {
			// 가장 첫번째 숫자가 최소값이라고 가정하기
			int minIdx = i;
			// 하나씩 비교하면서 더 작은 값은 minIdx에 저장
			for(int j = i+1; j < scores.length; j++) {
				if(scores[j] < scores[minIdx])
					minIdx = j;
			}
			// 큰 값과 작은 값 서로 위치 변경
			int temp = scores[minIdx];
			scores[minIdx] = scores[i];
			scores[i] = temp;
		}
		// 중간값 찾기 위해 전체 개수의 / 2
		System.out.println(scores[N / 2]);
	}
}

