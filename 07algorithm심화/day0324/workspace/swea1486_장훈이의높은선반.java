package day0324;

import java.util.Scanner;

public class swea1486_장훈이의높은선반 {
	static int N, B, ans;
	static int[] H;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 점원의 수 (1 ~ 20)
			B = sc.nextInt(); // 선반의 높이
			H = new int[N];
			
			// 점원들 키 저장
			for(int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}
			
			ans = Integer.MAX_VALUE;
			// 비트마스킹 방식(for문 2개)
			// 1. for문 : 모든 부분집합을 돌아보겠다.
			// 2. for문 : i라고 하는 것이 부분집합이건 알겠어! 그런데 어떤 점원들을 데리고 탑을 쌓았니?
			for(int i = 0; i < (1 << N); i++) {
				int sum = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) != 0) sum += H[j];
				} // 탑 다 쌓았다!
				if(sum >= B && sum < ans) ans = sum;
			}
			System.out.printf("#%d %d\n", tc, (ans - B));
		}
	}
}
