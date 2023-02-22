package homework;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Swea3499_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// t번의 테스트 케이스
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			String arr[] = new String[n];
			
			// 입력받은 단어 배열에 넣기
  			for(int i = 0; i < n; i++) {
				arr[i] = sc.next();
			}
  			// 배열 인덱스의 앞쪽에 있는 단어들 넣을 큐 = q1
  			// 배열 인덱스의 뒷쪽에 있는 단어들 넣을 큐 = q2
  			// q1과 q2를 번갈아가며 넣을 큐 = result
  			Queue<String> q1 = new LinkedList<>();
  			Queue<String> q2 = new LinkedList<>();
  			Queue<String> result = new LinkedList<>();
  			
  			// 총 길이가 짝수던 홀수던 (n + 1) / 2 갯수만큼 앞쪽 큐에 담기
  			// 나머지는 뒷쪽 큐에 담기
  			for(int i = 0; i < n; i++) {
  				if(i < (n + 1) / 2) q1.offer(arr[i]);
  				else if(i >= n / 2) q2.offer(arr[i]);
  			}
  			// 홀수일 경우 q1에 단어가 더 많이 들어가기 때문에
  			// q2에 단어가 들어가있을 경우에만 출력
  			while(result.size() < n) {
  				result.offer(q1.poll());
  				if(!q2.isEmpty()) {
  					result.offer(q2.poll());
  				}
  			}
  			// 최종 큐가 빌때까지 poll하여 출력
			System.out.print("#" + tc + " ");
			while(!result.isEmpty()) {
				System.out.print(result.poll() + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
