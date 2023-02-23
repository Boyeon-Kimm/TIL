package homework;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;

public class Swea7102_준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			// n카드랑 m카드 하나씩 더한 값을 queue에 넣기
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					queue.offer(i + j);
				}
			}
			// 최빈수를 구하기 위해 배열 인덱스 사용
			int[] arr = new int[n + m + 1];
			int max = 0;
			// queue에서 꺼낸 값과 같은 인덱스를 가진 배열에 ++
			while(!queue.isEmpty()) {
				arr[queue.poll()] += 1;
			}
			// 최빈수 구하기
			for(int i = 0; i < arr.length; i++) {
				max = Math.max(max, arr[i]);
			}
			// 동일한 최빈수를 가진 숫자가 여러개 있을 수 있으니
			// 해당 숫자들은 큐에 넣기(오름차순 정렬하여 출력)
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i = 0; i < arr.length; i++) {
				if(max == arr[i]) {
					pq.offer(i);
				}
			}
			System.out.print("#" + tc + " ");
			while(!pq.isEmpty())
				System.out.print(pq.poll() + " ");
			System.out.println();
		}
		sc.close();
	}
}
