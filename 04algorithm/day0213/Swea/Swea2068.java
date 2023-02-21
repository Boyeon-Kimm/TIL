package homework;
import java.util.Scanner;

public class Swea2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스의 갯수 T
		int T = sc.nextInt();
		
		// 테스트를 T번 진행
		for(int i = 1; i <= T; i++) {
			// 최대값 담을 변수
			int max = 0;
			for(int j = 0; j < 10; j++) {
				// 숫자 10번 입력받기
				int num = sc.nextInt();
				// 두 숫자를 비교해서 큰 값 max에 넣기
				max = Math.max(max, num);
			}
			System.out.println("#"+i+" "+max);
		}

	}
}
