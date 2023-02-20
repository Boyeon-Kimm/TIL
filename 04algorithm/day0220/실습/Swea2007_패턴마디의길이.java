package homework;
import java.util.Scanner;

public class Swea2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// t번의 테스트 케이스
		for(int tc = 1; tc <= t; tc++) {
			String str = sc.next();
			String[] arr = str.split("");
			
			// 가장 첫번째 문자와 두번째 문자를 먼저 비교
			// 첫번째 문자와 같은 문자가 될때까지 첫번째 문자의 인덱스는 0, 두번째 문자의 인덱스는 ++
			// 같아진 순간부터 j++, 문자열이 끝날 때 까지 증가됨
			int j = 0;
			for(int i = 1; i < 30; i++) {
				if(arr[j].equals(arr[i])) j++;
				else j = 0;
			}
			// 30 - j 는 처음 단어 일치여부를 판단하며 j가 0이었던 구간 = 단어의 길이
			System.out.println("#" + tc + " " + (30 - j));
		}
	}
}
