package homework;
import java.util.Scanner;

public class Swea1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// t번의 테스트 진행
		for(int i = 1; i <= t; i++) {
			// 2개의 숫자를 동시에 받기 위해
			// 첫번째 N 숫자는 next로 문자열 한개만 받은 후 숫자로 변환
			String n = sc.next();
			int N = Integer.parseInt(n);
			// 단어의 길이
			int numK = sc.nextInt();
			int[][] puzzle = new int[N][N];
			// 문자 입력 가능한 횟수
			int result = 0;
			
			// 행에서 단어 들어갈 수 있는 곳 찾기
			for(int j = 0; j < puzzle.length; j++) {
				int count = 0;
				for(int k = 0; k < puzzle.length; k++) {
					// 배열에 1또는 0 입력받기
					puzzle[j][k] = sc.nextInt();
					// 현재 위치가 1이라면 카운트
					if(puzzle[j][k] == 1) count++;
					// 현재 위치가 0이거나, 배열의 끝일 때
					// 문자의 길이와 카운트 숫자가 일치한다면 입력가능횟수 ++
					if(puzzle[j][k] == 0 || k == N - 1) {
						if(count == numK) result++;
						count = 0;
					}
				}
			}
		
			// 열에서 단어 들어갈 수 있는 곳 찾기
			for(int j = 0; j < puzzle.length; j++) {
				int count = 0;
				for(int k = 0; k < puzzle.length; k++) {
					if(puzzle[k][j] == 1) count++;
					if(puzzle[k][j] == 0 || k == N - 1){
						if(count == numK) result++;
						count = 0;
					}
					
				}
			}
			System.out.println("#"+i+" "+result);
		}
	}
}
