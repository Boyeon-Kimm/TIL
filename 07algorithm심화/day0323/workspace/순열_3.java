package day0323_백트래킹;

import java.util.Arrays;

// 반복문
public class 순열_3 {
	static int[] nums;
	static int N;
	// 해당 원소 사용 유무
	static boolean[] visited;
	// 순열 결과 저장
	static int[] result;
	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		result = new int[N];
		visited = new boolean[N];
		
		perm(0);
	}
	
	public static void perm(int idx) {
		if(idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		// 모든 요소를 반복문을 통해 돌면서
		// 사용하지 않은 원소가 있다면 결과에 넣고 사용했다고 표시도 하고
		// 다음 차례로 내려가 본다
		for(int i = 0; i < N; i++) {
			// 1. 원소를 사용했는지 체크
			if(visited[i]) continue;
			// 여기서 실행된다는 것은 안쓴 원소라는 것
			result[idx] = nums[i];
			visited[i] = true; // 해당 원소 썼어요~ 표시
			perm(idx + 1); // 내려가
			visited[i] = false; // 다시 원상복구
			
		}
	}
	
}
