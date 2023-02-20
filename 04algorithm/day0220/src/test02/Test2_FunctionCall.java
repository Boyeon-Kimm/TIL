package test02;

public class Test2_FunctionCall {
	public static void main(String[] args) {
		System.out.println("메인 작업 수행");
		func1();
		System.out.println("메인 작업 끝");
	}
	public static void func1() {
		System.out.println("함수 1 작업 수행");
		func2();
		System.out.println("함수 1 작업 끝");
	}
	public static void func2() {
		System.out.println("함수 2 작업 수행");
		System.out.println("함수 2 작업 끝");
	}
}
