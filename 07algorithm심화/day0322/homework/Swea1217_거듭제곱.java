package homework;

import java.util.Scanner;

public class Swea1217_거듭제곱 {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			int result = pow(N, M);
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	public static int pow(int N, int M) {
		// 기저 조건
		if(M == 1) return N;
		
		// 재귀 조건
		// 1. 짝수일 때
		if(M % 2 == 0) {
			int x = pow(N, M/2);
			return x * x;
		// 2. 홀수일 때
		} else {
			int y = pow(N, (M - 1) / 2);
			return y * y * N;
		}
	}
}
