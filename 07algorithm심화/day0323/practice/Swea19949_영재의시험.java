package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek19949 {
	static int res;
	static int[] test, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		test = new int[10];
		answer = new int[10];
		
		// 시험 정답 입력
		for(int i = 0; i < 10; i++) {
			test[i] = Integer.parseInt(st.nextToken());
		}

		res = 0;
		backtracking(0);
		System.out.println(res);
	}
	private static void backtracking(int depth) {
		// 10문제 다 찍으면 종료
		if(depth == 10) {
			int score = 0;
			// 정답과 찍은 문제가 같다면 점수 증가
			for(int i = 0; i < 10; i++) {
				if(answer[i] == test[i]) score++;
			}
			if(score >= 5) res++; // 점수가 5점 이상일 경우 정답 증가
			return;
		}
		// 5지선다형 찍기
		for(int i = 1; i <= 5; i++) {
			// 3개의 연속된 문제는 답을 같지 않게 하기 위함
			if(depth >= 2) {
				if(answer[depth - 1] == i && answer[depth - 2] == i) continue;
			}
			answer[depth] = i;
			backtracking(depth + 1);
		}
	}
}
