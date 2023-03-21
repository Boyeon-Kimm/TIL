package day0321_부분집합_조합;

import java.util.Arrays;

public class 조합_1 {
	// 재귀를 이용해서 조합을 만들어보자
	static String[] 토핑 = {"상추", "패티", "토마토", "치즈"};
	// 4개 중에 2개를 뽑는다, 보통 문제에서 주어짐
	static int N = 4;
	static int R = 2;
	
	// 내가 선택한 토핑
	static String[] sel = new String[R];
	
	public static void main(String[] args) {
		combination(0, 0);
	}
	// idx  : 내가 이번 깊이에서 고려할 재료
	// sidx : 현재 뽑을 자리 
	public static void combination(int idx, int sidx) {
		// base case
		// 순서 중요!!!
		if(sidx == R) { // 다 뽑았어
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx == N) { // 고려 다 했어
			return;
		}
		
		// recursive case
		// sidx 자리에 현재 보고 있는 idx 토핑을 저장할래
		sel[sidx] = 토핑[idx]; 
		// 이번 재료 썼고, 다음 재료 판단하러 가보자
		combination(idx + 1, sidx + 1);
		// 이번 재료 안썼고, 다음 재료 판단하러 가보자
		combination(idx + 1, sidx);
	}
}
