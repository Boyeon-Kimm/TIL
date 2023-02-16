package test01;

public class Test2_Delta {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int N = 3;
		int r =  1;
		int c = 1;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				System.out.println(arr[nr][nc]);
			}
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			System.out.println(arr[nr][nc]);
		}
	}
}
