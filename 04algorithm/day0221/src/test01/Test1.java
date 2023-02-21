package test01;

public class Test1 {
	public static void main(String[] args) {
		// 반복문 <=> 재귀
		
//		for(int i = 0; i < 5; i++) {
//			System.out.println(i);
//		}
		
		// 재귀함수로 만든다면?
		// 일반화 => n에 대한 문제 : 전체 문제 : f(n)
		// 부분문제 : f(n-1), f(n-2) ... f(1), f(0)
		
		// n : 숫자, 크기, 인덱스, 순서, ... 다양한 의미..
		
		// 재귀함수는 두 가지 부분으로 나뉜다.
		// - base case : 기저파트, 기저조건
		// - recursive case : 유도파트, 유도조건...
		
		rf(0, 5);
	}
	
	// recursive for
	// i번째 인덱스 출력하고, 그 다음으로 넘어가는 메서드
	// i 이후의 인덱스를 출력하는 메서드
	static void rf(int idx, int end) {
		// 기저파트
		if(idx == end) {
			return;
		}
		
		// 유도파트
		// - 자기 단계에서 처리할 일을 처리하고
		// - 나머지 일은 다음 부분 문제에게 위임한다.
		System.out.println(idx);
		rf(idx + 1, end);
	}
}
