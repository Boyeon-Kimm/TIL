package Homework;
import java.util.Scanner;
public class Swea1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 10번의 테스트
		for(int i = 1; i <= 10; i++) {
			int tc = sc.nextInt();
			// 배열의 가장 왼쪽과 오른쪽 패딩값 줌
			int[][] map = new int[100][102];
			// 2가 들어있는 배열의 인덱스를 저장할 변수
			int x = 0;
			int y = 0;
			
			// 배열에 사다리 입력하면서 2가 입력된 배열의 인덱스 저장
			for(int j = 0; j < 100; j++) {
				for(int k = 1; k < 101; k++) {
					map[j][k] = sc.nextInt();
					if(map[j][k] == 2) {
						x = j;
						y = k;
					}
				}
			}
			// x가 0이 될때까지 반복
			while(x != 0){
				// 현재 위치에서 왼쪽, 오른쪽, 윗쪽에 1이 있다면
				// 현재 위치 0 입력 & 1이 있는 위치로 이동
				if(map[x][y-1] == 1) {
					map[x][y-1] = 0;
					y = y - 1;
				} else if(map[x][y+1] == 1) {
					map[x][y+1] = 0;
					y = y + 1;
				} else if(map[x-1][y] == 1){
					map[x-1][y] = 0;
					x = x - 1;
				}
			}
			// 배열에 주었던 패딩값 -1
			int answer = y - 1;
			System.out.println("#"+i+" "+answer);
		}
	}
}
