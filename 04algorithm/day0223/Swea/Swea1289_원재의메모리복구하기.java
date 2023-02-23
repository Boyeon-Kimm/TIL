package homework;

import java.util.Scanner;
import java.util.Stack;

public class Swea1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// t번의 테스트 케이스
		for(int tc = 1; tc <= t; tc++) {
			char[] memory = sc.next().toCharArray();
			Stack<Character> stack = new Stack<>();
			int cnt = 0;
			for(int i = 0; i < memory.length; i++) {
				// 스택이 비어있지 않다면
				// 스택에 들어있는 직전 값을 확인 및 비교
				// 직전 값과 같다면 스택에 값 넣고, 다르다면 횟수 증가 후 스택에 값추가
				if(!stack.isEmpty()) { 
					if(memory[i] == stack.peek()) stack.push(memory[i]);
					else {
						cnt++;
						stack.push(memory[i]);
					}
				// 큐가 비어있을 경우 1이면 카운트 증가 후 값 추가
				// 0일 경우 값만 추가하기
				} else {
					if(memory[i] == '1') {
						cnt++;
						stack.push(memory[i]);
					} else stack.push(memory[i]);
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
		sc.close();
	}
}
