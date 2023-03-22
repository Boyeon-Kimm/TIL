package homework;

import java.util.Arrays;

public class 퀵정렬 {
	static int[] arr = {10, 2, 5, 6, 3, 73, 1};
	public static void main(String[] args) {
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int A[], int start, int end) {
		// start가 end보다 크거나 같다면 정렬할 원소가 1개 이하이므로
		// 정렬하지 않고 리턴
		if(start >= end) return;
		
		// 가장 왼쪽 값을 pivot으로 설정
		int pivot = start;
		// 배열을 비교할 왼쪽 인덱스
		int left = start + 1;
		// 배열을 비교할 오른쪽 인덱스
		int right = end;
		// swap을 위해 임시 변수 선언
		int temp;
		
		// left가 right 이하일 때만 진행
		while(left <= right) {
			// 피벗보다 큰 값을 만날 때 까지 칸 이동
			while(arr[pivot] >= arr[left]) left++;
			//피벗보다 작은 값을 만날 때 까지 칸 이동
			// start보다 클 때 칸 이동
			while(arr[pivot] <= arr[right] && right > start) right--;
			
			// left와 right가 엇갈리면 피벗과 교체하기
			if(left > right) swap(arr, right, start);
			// 엇갈리지 않으면 left와 right 값 교체하기
			else swap(arr, left, right);
		}
		quickSort(arr, start, right - 1);
		quickSort(arr, right + 1, end);
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
