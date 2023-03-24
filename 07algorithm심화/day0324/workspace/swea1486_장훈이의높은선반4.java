package day0324;

import java.util.Scanner;

public class swea1486_장훈이의높은선반4 {
	static int N, B, ans;
	static int[] H;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 점원의 수 (1 ~ 20)
			B = sc.nextInt(); // 선반의 높이
			H = new int[N];
			int rs = 0; // 모든 점원의 키의 합
			
			// 점원들 키 저장
			for(int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
				rs += H[i];
			}
			ans = Integer.MAX_VALUE;
			powerset(0, 0, rs);
			System.out.printf("#%d %d\n", tc, (ans - B));
		}
	}

	public static void powerset(int idx, int sum, int rsum) {
		// 이거 좀 쳐내고 싶은데?
		// 이미 내가 최고의 값을 가지고 있는데 중간 결과가 나를 넘어서? 그러면 안해도 됨
		if(sum > ans) return;
		
		// 모든 점원 판단 끝났어!
		if(idx == N) {
			if(sum >= B) ans = Math.min(ans, sum);
			return;
		}
		
		// sum : 지금까지의 합
		// rsum : 앞으로 나한테 더해질 수 있는 합
		if(sum + rsum < B) return;
		
		powerset(idx + 1, sum + H[idx], rsum - H[idx]); // 쌓고
		powerset(idx + 1, sum, rsum - H[idx]); // 안쌓고
	}
}
