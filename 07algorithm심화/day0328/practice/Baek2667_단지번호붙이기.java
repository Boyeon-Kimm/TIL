package day0330_프림_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2667_단지번호붙이기 {
	static int N, house;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static List<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int cnt = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
//					bfs(i, j);
					house = 1;
					dfs(i, j);
					cnt++;
					list.add(house);
				}
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for(int i : list) {
			System.out.println(i);
		}
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = dr[d] + x;
			int nc = dc[d] + y;
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
			
			if(map[nr][nc] == 1) {
				visited[nr][nc] = true;
				house++;
				dfs(nr, nc);
			}
		}
	}
	
	
//	private static void bfs(int x, int y) {
//		Queue<int[]> q = new LinkedList<>();
//		int house = 1;
//		q.add(new int[] {x, y});
//		visited[x][y] = true;
//		
//		while(!q.isEmpty()) {
//			int[] cur = q.poll();
//			int curX = cur[0];
//			int curY = cur[1];
//			
//			for(int d = 0; d < 4; d++) {
//				int nr = dr[d] + curX;
//				int nc = dc[d] + curY;
//				
//				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
//				
//				if(map[nr][nc] == 1) {
//					visited[nr][nc] = true;
//					house++;
//					q.add(new int[] {nr, nc});
//				}
//			}
//		}
//		list.add(house);
//		
//	}
}
