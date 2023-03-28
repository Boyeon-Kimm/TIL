package day0328_그래프탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_연습문제 {
	static int N, M;
	static int[][] adj;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 수
		M = sc.nextInt(); // 간선의 수
		adj = new int[N + 1][N + 1]; // 인접 행렬 입력받을 배열
		visited = new boolean[N + 1]; // 방문체크할 배열
		
		// 연결되어있다면 1로 표시하기
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1;
		}
		BFS(1);
	}

	static void BFS(int v) {
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.println(curr);
			
			for(int i = 0; i < adj.length; i++) {
				if(!visited[i] && adj[curr][i] == 1) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}

