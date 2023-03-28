package day0328_그래프탐색;

import java.util.Scanner;

public class DFS_연습문제1 {
	static int N, M;
	static int[][] adj;
	static boolean[] visited;
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
		DFS(1);
	}
	static void DFS(int v) {
		// 방문 체크
		visited[v] = true;
		System.out.println(v);
		// 방문하지 않았고, 간선이 연결되어있다면 재귀호출
		for(int i = 0; i < N + 1; i++) {
			if(!visited[i] && adj[v][i] == 1) {
				DFS(i);
			}
		}
	}
}

