package swea;

import java.util.Scanner;

public class 등산로조성 {
	static int N, K, ans; // N : 한 변의 길이, K : 내가 공사를 할 수 있는 깊이, ans : 정답
	static int[][] mountain; // 지형에 대한 2차원 정보
	static boolean[][] visited; // 방문처리를 하기 위한 2차원 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();

			int maxH = 0; // 최대 봉우리의 높이를 저장할 변수
			ans = 0;
			mountain = new int[N][N];
			visited = new boolean[N][N];

			// 입력 받으면서 동시에 가장 높은 봉우리 갱신
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mountain[i][j] = sc.nextInt();
					// 1. max 메서드
					maxH = Math.max(maxH, mountain[i][j]);
					// 2. 삼항 연산자
//					maxH = maxH < mountain[i][j] ? mountain[i][j] : maxH;
					// 3. 조건문
//					if(maxH < mountain[i][j]) maxH = mountain[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mountain[i][j] == maxH) {
						// 출발
//						work(i, j, 1, true);
						work2(i, j, maxH, 1, true);
					}
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	// 행과 열의 좌표, 등산로 길이, 공사여부
	public static void work(int r, int c, int dist, boolean skill) {
		if (dist > ans)
			ans = dist; // 갱신

		visited[r][c] = true; // 해당 지점 방문처리

		// 4방향 탐색하며 다음 좌표로 내려갈 수 있는지 체크
		for (int d = 0; d < 4; d++) {
			int nr = dr[d] + r;
			int nc = dc[d] + c;

			if (isRange(nr, nc) || visited[nr][nc])
				continue;

			// 1. 공사 안하고 갈 수 있으면
			// 현재에 있는 좌표가 다음 좌표에 있는 값보다 크다면
			if (mountain[r][c] > mountain[nr][nc])
				work(nr, nc, dist + 1, skill);
			// 2. 공사 해야만 갈 수 있는데 공사 안했다면
			else if (skill && mountain[r][c] > mountain[nr][nc] - K) {
				// 이제 공사를 했으니 false 내려보냄
				int tmp = mountain[nr][nc]; // 기록
				mountain[nr][nc] = mountain[r][c] - 1;
				work(nr, nc, dist + 1, false);
				// 흙 덮어.. 원상복구
				mountain[nr][nc] = tmp;
			}
		}
		visited[r][c] = false; // 해당 지점 방문 안했다~~~
	}

	
	public static boolean isRange(int nr, int nc) {
		return nr < 0 || nr >= N || nc < 0 || nc >= N;
	}
	

	// 행과 열의 좌표, 등산로 길이, 현재 위치의 값, 공사여부
	public static void work2(int r, int c, int h, int dist, boolean skill) {
		if (dist > ans)
			ans = dist; // 갱신

		visited[r][c] = true; // 해당 지점 방문처리

		// 4방향 탐색하며 다음 좌표로 내려갈 수 있는지 체크
		for (int d = 0; d < 4; d++) {
			int nr = dr[d] + r;
			int nc = dc[d] + c;

			if (isRange(nr, nc) || visited[nr][nc])
				continue;

			// 1. 공사 안하고 갈 수 있으면
			// 현재에 있는 좌표가 다음 좌표에 있는 값보다 크다면
			if (h > mountain[nr][nc])
				work2(nr, nc, mountain[nr][nc], dist + 1, skill);
			// 2. 공사 해야만 갈 수 있는데 공사 안했다면
			else if (skill && h > mountain[nr][nc] - K) {
				// 이제 공사를 했으니 false 내려보냄
				work2(nr, nc, mountain[nr][nc], dist + 1, false);
			}
		}
		visited[r][c] = false; // 해당 지점 방문 안했다~~~
	}

}
