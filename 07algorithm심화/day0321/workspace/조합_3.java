package day0321_부분집합_조합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 조합_3 {
	// 재귀를 이용해서 조합을 만들어보자
	static String[] 토핑 = {"상추", "패티", "토마토", "치즈"};
	// 4개 중에 2개를 뽑는다, 보통 문제에서 주어짐
	static int N = 4;
	static int R = 2;
	
	// 내가 선택한 토핑
	static String[] sel = new String[R];
	
	static List<String[]> list = new ArrayList<>();
	
	public static void main(String[] args) {
		combination(0, 0);
		
		for(String[] strs : list) {
			System.out.println(Arrays.toString(strs));
		}
	}
	// idx  : 내가 이번 깊이에서 고려할 재료
	// sidx : 현재 뽑을 자리 
	public static void combination(int idx, int sidx) {
		// base case
		if(sidx == R) { // 다 뽑았어
			list.add(sel);
			return;
		}
		
		// recursive case
		// 경계값 설정
		for(int i = 0; i <= N - R + sidx; i++) {
			sel[sidx] = 토핑[i];
			combination(i + 1, sidx + 1);
		}
	}
}
