package day0330_프림_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek4963_섬의개수 {
	static int W, H;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean flag = true;
		while(flag) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0) {
				flag = false;
				break;
			}
			
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
//						bfs(i, j);
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d = 0; d < 8; d++) {
			int nr = dr[d] + x;
			int nc = dc[d] + y;
			
			if(nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc]) continue;
			
			if(map[nr][nc] == 1) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
		
		
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int curX = arr[0];
			int curY = arr[1];
			for(int d = 0; d < 8; d++) {
				int nr = dr[d] + curX;
				int nc = dc[d] + curY;
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc]) continue;
				
				if(map[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}
}
