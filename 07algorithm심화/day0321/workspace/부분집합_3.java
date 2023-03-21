package day0321_부분집합_조합;

public class 부분집합_3 {
	static String[] 재료 = {"참치", "우엉", "삼겹살"};
	static int N = 3;
	// 해당 요소 선택 했다를 저장하기 위한 sel..visited..
	static boolean[] sel = new boolean[N];
	public static void main(String[] args) {
		// 테스트마다 달라지니까 main에서 초기화
		N = 3;
		sel = new boolean[N];
		
		powerset(0);

	}
	// 메소드를 작성할 때 최대한 파라미터를 심플하게
	// idx : 해당 원소를 포함할지 안할지를 결정해야 함.
	public static void powerset(int idx) {
		// base case : 재귀를 빠져나갈 수 있는 조건
		// 모든 재료를 넣을지 말지에 대한 판단 끝났어!
		if(idx == N) {
			String tmp = "";
			for(int i = 0; i < N; i++) {
				if(sel[i]) tmp += 재료[i];
			}
			System.out.println(tmp);
			return;
		}
		
		// recursive case : 나 자신을 다시 호출하는 조건
		sel[idx] = true; // idx번째의 재료를 사용했어!
		powerset(idx + 1); // 다음 재료를 고려해 ~
		
		sel[idx] = false; // idx번째의 재료를 사용하지 않았어!
		powerset(idx + 1); // 다음 재료를 고려해~
		
	}
}
