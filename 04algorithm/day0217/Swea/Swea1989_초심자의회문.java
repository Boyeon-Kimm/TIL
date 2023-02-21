package homework;
import java.util.Scanner;
public class Swea1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수 숫자로 변환
		String num = sc.next();
		int T = Integer.parseInt(num);
		// T번의 테스트
		for(int tc = 1; tc <= T; tc++) {
			// 단어 입력받기
			char[] word = sc.next().toCharArray();
			// 일치여부 확인할 변수
			boolean flag = true;
			// 단어의 길이의 절반만 탐색
			for(int i = 0; i < word.length / 2; i++) {
				// 현재 위치에 있는 문자와 대칭된 곳에 있는 문자가 다르다면
				// flag를 false로 바꾸고 break
				if(word[i] != word[word.length - i - 1])
					flag = false;
					break;
			}
			// 단어의 길이만큼 탐색 후 false라면 0, true라면 1
			if(flag == false) System.out.println("#"+tc+" "+0);
			else System.out.println("#"+tc+" "+1);
		}
	}
}
