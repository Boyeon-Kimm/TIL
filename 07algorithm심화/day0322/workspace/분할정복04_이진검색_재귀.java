package day0322_분할정복;

public class 분할정복04_이진검색_재귀 {
	static int arr[];
	static int key;
	public static void main(String[] args) {
		// 정렬된 상태라고 가정
		arr = new int[] {2, 4, 6, 8, 9, 17, 28};
		key = 6;
		
		System.out.println(binarySearch(0, arr.length - 1));
	}
	
	// 이진 검색을 하는 이유는
	// 이거 이 안에 들었나~ boolean / 들었다면 어디에 들었나~ int
	// 인자 값으로 무엇을 들고가야하나 (경계의 시작점, 끝점)
	public static boolean binarySearch(int start, int end) {
		// 기저조건(못찾았다)
		if(start > end) return false;
		
		int mid = (start + end) / 2; // 정수 값
		
		// 같다면
		if(arr[mid] == key) return true;
		// 크다면(왼쪽 구간으로 옮겨야 함)
		else if(arr[mid] > key) return binarySearch(start, mid - 1);
		// 작다면(오른쪽 구간으로 옮겨야 함)
		else return binarySearch(mid + 1, end);
		
	}
}
