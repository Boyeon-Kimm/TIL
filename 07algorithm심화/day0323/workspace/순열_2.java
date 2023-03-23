package day0323_백트래킹;

import java.util.Arrays;

// 반복문
public class 순열_2 {
	static int[] nums;
	static int N;
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		
		perm(0);
	}
	
	// idx : 현재 판단하는 위치
	public static void perm(int idx) {
		// 기저 조건
		if(idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		// 재귀 조건
		for(int i = idx; i < N; i++) {
			swap(i, idx);
			// 원상복구 하는 과정이 필요함. why?
			perm(idx + 1);
		}
	}
	
	// swap 메서드
	// 바꿀 인덱스 2개가 인자로 넘어와야한다. (배열을 static하게 만들었으니까)
	// 위의 경우가 아니라면 배열까지 인자로 같이 넘겨줘야한다
	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
