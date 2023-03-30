package day0330_프림_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1926_그림 {
	static int N, M, area;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static int[][] paper;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = Integer.MIN_VALUE;
		int art = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(paper[i][j] == 1 && !visited[i][j]) {
					area = 1;
					bfs(i, j);
					max = Math.max(max, area);
					art++;
				}
			}
		}

		System.out.println(art);
		if(art == 0) System.out.println(0);
		else System.out.println(max);
	}

	private static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int curX = arr[0];
			int curY = arr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + curX;
				int nc = dc[d] + curY;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				
				if(paper[nr][nc] == 1) {
					visited[nr][nc] = true;
					area++;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}
}
