package day0410_동적계획법;

import java.util.Scanner;

public class 피보나치2_메모이제이션 {
	static long callFibo1, callFibo2, callFibo3;
	static long[] memo;
	static {
		memo = new long[10000];
		memo[0] = 0;
		memo[1] = 1;
		
		// 미리 계산을 해놓고
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		memo = new long[N + 1]; // 0으로 초기화가 되어있다
		memo[0] = 0; // 사실 필요는 없다. 
		memo[1] = 1;
		
		System.out.println(fibo1(N));
		System.out.println(callFibo1);
		System.out.println(fibo2(N));
		System.out.println(callFibo2);
		System.out.println(fibo3(N));
	}
	
	// 재귀 함수를 이용한 피보나치
	public static long fibo1(int n) {
		callFibo1++;
		if(n < 2) return n;
		return fibo1(n - 1) + fibo1(n - 2);
	}
	
	// memoization 기법을 적용한 피보나치
	public static long fibo2(int n) {
		callFibo2++;
		if(n >= 2 && memo[n] == 0) {
			memo[n] = fibo2(n - 1) + fibo2(n - 2);
		}
		return memo[n];
	}
	
	public static long fibo3(int n) {
		long[] dp = new long[n + 10];
		dp[1] =1;
		
		for(int i = 2; i <= n; i++) {
			dp[n] = dp[n - 2] + dp[n - 1];
		}
		return dp[n];
		
	}
}
