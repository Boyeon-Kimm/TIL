package Homework;
import java.util.Arrays;
import java.util.Scanner;

public class Swea1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int T = sc.nextInt();
		// 10개의 숫자를 담을 배열
		int[] arr = new int[10];
		// 최소수와 최대수의 중복 숫자 개수
		int count = 0;
		
		// T번의 테스트
		for(int i = 1; i <= T; i++) {
			// 배열에 담긴 전체 숫자 더한 값을 넣을 변수
			int sum = 0;
			for(int j = 0; j < 10; j++) {
				// 배열에 10개 숫자 넣기
				arr[j] = sc.nextInt();
				// 전체 숫자 더해서 sum에 넣기
				sum += arr[j];
			}
			// 오름차순 정렬
			Arrays.sort(arr);
			
			// arr[0] 최소수와 같은 값이 있다면 제거
			for(int j = 1; j < arr.length; j++) {
				if(arr[0] == arr[j]) {
					sum -= arr[j];
					++count;
				} else break;
			}
			
			// arr[9] 최대수와 같은 값이 있다면 제거
			for(int j = 8; j >= 0; j--) {
				if(arr[9] == arr[j]) {
					sum -= arr[j];
					++count;
				} else break;
			}
			
			// 전체 더한 수에서 최대수와 최소수 빼기
			sum = sum - arr[0] - arr[9];
			
			// 소수점 첫째자리에서 반올림하여 출력
			// double로 형변환
			System.out.println("#"+i+" "+Math.round((double)sum/8-count));
		}
	}
}
