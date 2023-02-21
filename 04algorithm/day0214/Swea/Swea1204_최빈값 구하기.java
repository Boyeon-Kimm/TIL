package homework;

import java.util.Scanner;

public class Swea1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1000개의 점수를 입력할 배열
		int[] scores = new int[1000];
		// 테스트 케이스 수
		int T = sc.nextInt();
		
		// 테스트 케이스 T만큼 반복
		for(int i = 1; i <= T; i++) {
			// 테스트 케이스의 번호
			int caseNum = sc.nextInt();
			// 배열의 인덱스 번호
			int idx = 0;
			// 최댓값 구할 변수
			int max = 0;
			// 최빈값 구할 변수
			int answer = 0;
			// 최빈값을 구하기 위해 점수와 일치하는 인덱스를 가진 배열 생성
			// 0점부터 100점까지 있으니 101개의 배열 만들기
			int[] arrIdx = new int[101];
			
			// 1000개의 점수를 받으면서 점수와 일치하는 인덱스를 가진 배열에 1씩 증가
			for(int j = 0; j < scores.length; j++) {
				scores[j] = sc.nextInt();
				idx = scores[j];
				arrIdx[idx]++;
			}
			
			// 인덱스배열의 최댓값 구하기
			// 해당 인덱스를 answer에 재할당
			for(int k = 0; k < arrIdx.length; k++) {
				if(max <= arrIdx[k]) {
					answer = k;
					max = arrIdx[k];
				}
			}
			
			System.out.println("#"+i+" "+answer);
			
		}
	}
}
