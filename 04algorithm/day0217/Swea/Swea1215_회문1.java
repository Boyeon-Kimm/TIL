package Homework;

import java.util.Scanner;

public class Swea1215_회문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 10번의 테스트 케이스
		for(int tc = 1; tc <= 10; tc++) {
			// 회문의 길이 입력
			int len = sc.nextInt();
			
			// 8 x 8 배열에 문자열 입력
			char[][] arr = new char[8][8];
			for(int i = 0; i < 8; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			// 회문이 대칭되는지 판단할 boolean 타입 변수, 회문의 갯수를 카운트할 변수 생성
			boolean flag = true;
			int palin = 0;
			// 배열의 길이에서 회문의 길이가 넘지 않도록 조건 만들기(2번째 for문)
			// 회문의 길이 / 2 만큼 반복하며 회문 대칭 여부 확인(3번째 for문)
			// 대칭이 아니라면 false
			for(int k = 0; k < 8; k++) {
				for(int i = 0; i < 8 - len + 1; i++) {
					// 가로 방향 탐색
					flag = true;
					for(int j = 0; j < len / 2; j++) {
						if(arr[k][i + j] != arr[k][len+i-j-1]) flag = false;
					}
					if(flag) palin++;
					
					// 세로 방향 탐색
					flag = true;
					for(int j = 0; j < len / 2; j++) {
						if(arr[i+j][k] != arr[len+i-j-1][k]) flag = false;
					}
					if(flag) palin++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, palin);
		}
		sc.close();
	}
}
