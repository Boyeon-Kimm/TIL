package homework;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Swea1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 10번의 테스트 케이스
		for(int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			
			// 입력받은 8개의 암호를 큐에 저장하기
			Queue<Integer> q = new LinkedList<>();
			for(int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			boolean flag = true;
			// 1 ~ 5 감소시키며 1보다 작아질때까지 반복
			// 맨 앞에 있는 원소를 감소시켰을 때 0보다 크다면 계속 진행,
			// 0보다 작아진다면 poll한 후 0을 offer해주고 break
			while(flag) {
				for(int i = 1; i <= 5; i++) {
					if(q.peek() - i > 0) {
						q.offer(q.poll() - i);
					}
					else {
						q.poll();
						q.offer(0);
						flag = false;
						break;
					}
				}
			}
			System.out.print("#" + tc + " ");
			while(!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
