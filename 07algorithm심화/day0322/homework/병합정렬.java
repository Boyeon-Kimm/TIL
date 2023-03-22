package homework;

import java.util.Arrays;

public class 병합정렬 {
	static int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
	// 정렬시키면서 넣을 임시배열 생성
	static int[] temp = new int[arr.length];
	
	public static void main(String[] args) {
		mergeSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	// start는 mergeSort를 진행할 배열의 시작 인덱스, end는 배열의 마지막 인덱스
	public static void mergeSort(int start, int end) {
		// start가 end보다 작을 때만 실행
		if(start < end) {
			int mid = (start + end) / 2;
			// 왼쪽 구간 실행
			mergeSort(start, mid);
			// 오른쪽 구간 실행
			mergeSort(mid + 1, end);
			
			// 왼쪽 구간의 시작 인덱스
			int L = start;
			// 오른쪽 구간의 시작 인덱스
			int R = mid + 1;
			// 임시 배열에 사용할 인덱스(저장위치)
			int idx = start;
			
			// 왼쪽 구간의 인덱스가 중간 이하일때, 오른쪽 구간의 인덱스가 배열의 마지막 인덱스 이하일 때만 작동해야함
			while(L <= mid || R <= end) {
				// 오른쪽 구간의 원소를 다 사용했거나
				// 왼쪽 구간의 원소가 남아있으면서 오른쪽 구간에 있는 원소보다 더 작은 원소가 있다면
				// 왼쪽 구간의 원소를 임시배열에 저장
				if(R > end || (L <= mid && arr[L] < arr[R])) {
					temp[idx++] = arr[L++];
				// 아니라면 오른쪽 구간의 원소 사용
				} else temp[idx++] = arr[R++];
			}
			// 왼쪽 구간과 오른쪽 구간의 모든 원소를 가지고 오면 정렬된 값을 기존 배열에 저장
			for(int i = start; i <= end; i++) {
				arr[i] = temp[i];
			}
		}
	}

}
