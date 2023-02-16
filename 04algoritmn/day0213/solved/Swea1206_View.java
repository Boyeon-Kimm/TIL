package homework;

import java.util.Scanner;

public class Swea1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 10번의 테스트 케이스
		for(int j = 1; j <= 10; j++) {
			// 건물의 개수 N개만큼 배열 생성
			int[] arr = new int[sc.nextInt()];
			for(int i = 0; i < arr.length; i++) {
				// 건물의 높이를 배열에 입력
				arr[i] = sc.nextInt();
			}
			// 조망 카운트 변수
			int view = 0;
			// 배열 맨앞 2칸 띄고 시작, 2칸 전까지만 반복
			// 기준점이 되는 빌딩의 왼쪽 2칸, 오른쪽 2칸이 본인보다 작을때만
			// 왼쪽 건물 2개, 오른쪽 건물 2개 총 4개의 건물 중 가장 높은 건물 구하ㄱ기
			// 현재 건물의 높이 - 가장 높은 건물의 높이를 view에 더하기
			for(int i = 2; i < arr.length - 2; i++) {
				if(arr[i] > arr[i-2] && arr[i] > arr[i-1] && arr[i] > arr[i+1] && arr[i] > arr[i+2]) {
					int left = Math.max(arr[i-2], arr[i-1]);
					int right = Math.max(arr[i+1], arr[i+2]);
					int max = Math.max(left, right);
					view += arr[i] - max;
				}
			}
			System.out.println("#"+j+" "+view);
		}
	}
}