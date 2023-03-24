package day0324;

import java.util.Scanner;

public class swea1486_장훈이의높은선반_재귀 {
	static int N, B, ans;
	static int[] H;
	static boolean[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 점원의 수 (1 ~ 20)
			B = sc.nextInt(); // 선반의 높이
			H = new int[N];
			sel = new boolean[N];
			
			// 점원들 키 저장
			for(int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}
			ans = Integer.MAX_VALUE;
			powerset(0);
			System.out.printf("#%d %d\n", tc, (ans - B));
		}
	}

	public static void powerset(int idx) {
		// 모든 점원 판단 끝났어!
		if(idx == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(sel[i]) sum += H[i];
			}
			if(sum >= B) ans = Math.min(ans, sum);
			return;
		}
		sel[idx] = true; // 쌓고
		powerset(idx + 1);
		sel[idx] = false; // 안쌓고
		powerset(idx + 1);
	}
}
