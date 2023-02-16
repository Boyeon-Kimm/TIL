package test04;

public class Test3_이진검색 {
	public static void main(String[] args) {
		int[] A = {2, 4, 7, 9, 11, 19, 23};
		
	}
	
	public static boolean binarySearch(int[] A, int key) {
		int n = A.length;
		
		// 가장 처음에는 전체 구간을 대상으로 시작
		int start = 0;
		int end = n-1;
		
		while(start <= end) {
			// 일단 가운데가 우리가 찾는 값이라고 가정
			int middle = (start + end) / 2;
			
			if(A[middle] == key) return true; // return middle;
			else if(A[middle] > key) end = middle - 1; // 우리가 찾는 값은 왼쪽 구간
			else start = middle + 1; // 우리가 찾는 값이 오른쪽 구간에 있다면
		}
		// while문을 빠져나오면 start > end
		return false;
	}
}
