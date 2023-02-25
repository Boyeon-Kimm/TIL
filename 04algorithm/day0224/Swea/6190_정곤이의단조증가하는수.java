package test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Swea6190_정곤이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// t번의 테스트 케이스
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			// 입력받은 정수 배열에 입력
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			// 내림차순 큐에 곱한 값 넣어주고
			// 큐에서 숫자 하나씩 꺼내서 각 자릿수 비교하여 앞자리가 더 크다면 break
			PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < n - 1; i++) {
				for(int j = i + 1; j < n; j++) {
					queue.offer(arr[i] * arr[j]);
					boolean flag = true;
					String str = Integer.toString(queue.poll());
					for(int k = 0; k < str.length() - 1; k++) {
						if(str.charAt(k) - '0' > str.charAt(k + 1) - '0') {
							flag = false;
							break;
						}
					}
					// flag가 true인 값 중 최댓값 구하기
					if(flag) {
						if(max < Integer.parseInt(str)) max = Integer.parseInt(str);
					}
				}
			}
			if(max == Integer.MIN_VALUE) System.out.printf("#%d %s\n", tc, -1);
			else System.out.printf("#%d %s\n", tc, max);
		}
	}
}
