package test01;

public class Test3 {
	public static void main(String[] args) {
		int n = 30;
		long start = System.nanoTime();
		System.out.println(fibo(n));
		long end = System.nanoTime();
		System.out.println(end - start);
		
		start = System.nanoTime();
		System.out.println(mFibo(n));
		end = System.nanoTime();
		System.out.println(end - start);
	}
	
	// fibo(n) : 피보나치 수열에서 n번째 수
	public static int fibo(int n) {
		// 기저조건
		if(n <= 1) {
			return n;
		} else {
			// 유도조건
			return fibo(n-1) + fibo(n-2);
		}
	}
	
	static int[] memo = new int[100];
	// 스태틱 블록
	// - 클래스가 로딩될 때 클래스를 변수가 준비되고 난 후 자동으로 실행되는 블록
	// - 한 클래스 안에 여러 개의 스태틱 블록을 넣을 수 있음
	// - 주로 클래스 변수(static 변수)를 초기화할 때 사용
	static {
		memo[0] = 0;
		memo[1] = 1;
	}
	
	// memoization을 이용한 fibo : n번째의 피보나치 수를 구하는 메서드
	public static int mFibo(int n) {
		if(n >= 2 && memo[n] == 0) {
			// 아직 계산한 적이 없는 경우
			// -> 한 번만 계산해서 배열에 넣는다
			memo[n] = mFibo(n - 1) + mFibo(n - 2);
		}
		// 계산한 적이 있는 경우
		return memo[n];
	}
}
