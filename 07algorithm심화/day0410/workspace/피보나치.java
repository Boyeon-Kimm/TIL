package day0410_동적계획법;

import java.util.Scanner;

public class 피보나치 {
	static long callFibo1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fibo1(N));
		System.out.println(callFibo1);
	}
	// 재귀 함수를 이용한 피보나치
	public static long fibo1(int n) {
		callFibo1++;
		if(n < 2) return n;
		return fibo1(n - 1) + fibo1(n - 2);
	}
	
}
