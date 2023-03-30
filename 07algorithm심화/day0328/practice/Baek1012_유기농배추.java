package day0330_프림_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1012_유기농배추 {
	static int N, M;
	static boolean[][] visited;
	static int[][] farm;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
		
			farm = new int[N][M];
			visited = new boolean[N][M];
			
			while(K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
			
				farm[y][x] = 1;
			}
			int worm = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!visited[i][j] && farm[i][j] == 1) {
//						bfs(i, j);
						dfs(i, j);
						worm++;
					}
				}
			}
			System.out.println(worm);
		}
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = dr[d] + x;
			int nc = dc[d] + y;
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
			
			if(farm[nr][nc] == 1) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
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
				
				if(farm[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc}); 
				}
			}
		}
		
	}
}
