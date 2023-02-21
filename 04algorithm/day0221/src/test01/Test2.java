package test01;

public class Test2 {
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
	
	public static int factorial(int n) {
		
		if(n == 0) {
			return 1;
		}
		// 기저 파트
		// - 언제 끝날지 ? 
		if(n == 1) {
			return 1;
		}
		
		// 유도 파트
		return n * factorial(n - 1);
	}
}
