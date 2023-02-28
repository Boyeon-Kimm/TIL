package homework;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Swea1228_암호문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			List<Integer> list = new LinkedList<>();
			// 암호문의 길이
			int N = sc.nextInt();
			// 원본 암호문 리스트에 담기
			for(int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			// 명령어의 개수
			int ca = sc.nextInt();
			for(int i = 0; i < ca; i++) {
				// I(삽입), x의 위치, y개의 숫자
				String str = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				// 리스트 x의 위치 바로 다음에 y개 숫자 입력받기
				for(int j = 0; j < y; j++) {
					list.add(x + j, sc.nextInt());
				}
			}
			// 수정된 결과의 처음 10개 숫자 출력하기
			System.out.printf("#%d ", tc);
			for(int i = 0; i < 10; i++) {
				System.out.printf("%d ", list.get(i));
			}
			System.out.println();
		}
	}
}
