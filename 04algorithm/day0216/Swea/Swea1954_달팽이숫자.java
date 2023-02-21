package homework;

import java.util.Scanner;

public class Swea1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 이동 방향 고려하여 우 하 좌 상
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		// T번의 테스트
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			// 현재 위치 x,y 이동방향 d
			int x = 0;
			int y = 0;
			int d = 0;
			// 배열에 채울 숫자
			for(int i = 1; i <= N * N; i++) {
				snail[x][y] = i;
				x += dr[d];
				y += dc[d];
				// 배열의 범위를 벗어나거나 이미 입력된 숫자가 있을 때
				// 간 방향 다시 되돌아가고 방향전환 후 재이동
				if(x < 0 || x >= N || y < 0 || y >= N || snail[x][y] > 0) {
					x -= dr[d];
					y -= dc[d];
					d = ( d + 1 ) % 4;
					x += dr[d];
					y += dc[d];	
				}
			}
			// 달팽이 숫자 출력
			System.out.println("#" + tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
