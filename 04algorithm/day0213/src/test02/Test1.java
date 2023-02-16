package test02;

public class Test1 {
	public static void main(String[] args) {
		// 1차원 배열 연습
		
		int[] nums = {1, 2, 3, 4, 5, 6};
		
		// 1. 정방향 순회
		// 1-1. 전통적인 for문
//		for(int i=0; i<nums.length; i++) {
//			System.out.println(nums[i]);
//		}
		// 1-2. for-each문
//		for(int num : nums) {
//			System.out.println(num);
//		}
		
		// 2. 역방향 순회
		// 2-1. 일반 for문
//		for(int i=nums.length -1; i>=0; i--) {
//			System.out.println(nums[i]);
//		}
		
		// 2-2. 인덱스 컨트롤
		int N = nums.length;
		for(int i=0; i<N; i++) {
			System.out.println(nums[N-1-i]);
		}
	}
}




