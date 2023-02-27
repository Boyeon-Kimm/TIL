package homework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스코드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사람의 수
		int N = sc.nextInt();
		// K번째 사람 제거
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		// 큐에 N명의 사람 입력
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		// 삭제하려는 순서의 전 사람까지 해당 큐의 맨 뒤로 보낸다
		// K번째 사람은 꺼내서 다른 큐에 옮기기
		while(!q.isEmpty()) {
			for(int i = 0; i < K - 1; i++) {
				q.offer(q.poll());
			}
			q2.offer(q.poll());
		}
		System.out.print("제거되는 순서 : ");
		while(!q2.isEmpty()) {
			System.out.print(q2.poll() + " ");
		}
	}
}
