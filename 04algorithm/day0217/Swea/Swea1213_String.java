package homework;

import java.util.Scanner;

public class Swea1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 10번의 테스트 케이스
		for(int tc = 1; tc <= 10; tc++) {
			// 테스트 케이스의 번호 입력
			String num = sc.next();
			// 검색할 문자열 입력
			char[] p = sc.next().toCharArray();
			// 문장 입력
			char[] sen = sc.next().toCharArray();
			// 일치하는 문자열의 갯수
			int count = 0;
			// 문장의 길이 - 문자열의 길이 + 1 만큼만 탐색
			for(int i = 0; i < sen.length - p.length + 1; i++) {
				// 문자열과 문장의 일치여부 확인
				boolean flag = true;
				// 문자열의 길이만큼 문자열 일치여부 확인
				for(int j = 0; j < p.length; j++) {
					// 문장의 현위치와 문자열의 현위치에 있는 값이
					// 일치하지 않는다면 false, break;
					if(p[j] != sen[i+j]) {
						flag = false;
						break;
					}
				}
				// 문자열 모두 일치한다면 횟수 증가
				if(flag == true) count++;
			}
			System.out.println("#"+tc+" "+count);
		}
	}
}
