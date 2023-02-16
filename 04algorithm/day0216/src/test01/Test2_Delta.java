package test01;

public class Test2_Delta {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int N = 3;
		int r = 1;
		int c = 1;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		// 상 하 좌 우
		// 0 - 상
		// 1 - 하
		// 2 - 좌
		// 3 - 우
		
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 경계 조건(배열을 벗어나지 않게 하기 위해)
			// 0보단 작고 N보다는 커야하기 때문에 &&조건
			// 경계 안으로 들어올 때만 하겠다
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				System.out.println(arr[nr][nc]);
			}
			
			// 범위를 벗어나면 아래 실행문에 도달하지 않고 바로 넘어가겠다
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			System.out.println(arr[nr][nc]);
		}
		
		// 대각선은?
		int[] dr2 = {-1, -1, 1, 1};
		int[] dc2 = {-1, 1, -1, 1};
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 경계 조건(배열을 벗어나지 않게 하기 위해)
			// 0보단 작고 N보다는 커야하기 때문에 &&조건
			// 경계 안으로 들어올 때만 하겠다
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				System.out.println(arr[nr][nc]);
			}
			
			// 범위를 벗어나면 아래 실행문에 도달하지 않고 바로 넘어가겠다
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			System.out.println(arr[nr][nc]);
		}
		
		// 8 방향?
		
		// 크기가 8인 델타 배열을 만들고
		// 반복을 8번 돌면 됨 ! 0, 1, 2, ..., 7
		
	}
}
