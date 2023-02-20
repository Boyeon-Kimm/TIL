package test02;
import java.util.Scanner;
import java.util.Stack;

public class Test3_실행취소 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<String> ctrlZ = new Stack<String>();
		Stack<String> ctrlY = new Stack<String>();

		String work = "시작작업";

		while (true) {
			System.out.println("1. 새로운 작업");
			System.out.println("2. Ctrl+Z");
			System.out.println("3. Ctrl+Y");
			System.out.println("0. 종료(그외 입력)");

			int N = sc.nextInt();
			if (N == 1) {
				ctrlZ.add(work); // 이전 작업 스택에 현재 작업 넣기
				work = sc.next(); // 새로운 작업 입력받고
				ctrlY.clear(); // 이후 작업 스택 비우기
				System.out.println(work); // 현재 작업 출력
			} else if (N == 2) {
				if (ctrlZ.isEmpty()) {
					System.out.println("가장 첫 작업이다.");
				} else {
					ctrlY.add(work); // 현재작업을 Y에 추가
					work = ctrlZ.pop(); // 현재작업을 이전 작업스택에서 꺼내서 넣기
					System.out.println(work); // 바뀐작업 추가
				}

			} else if (N == 3) {
				if (ctrlY.isEmpty()) {
					System.out.println("가장 마지막 작업이다.");
				} else {
					ctrlZ.add(work); // 현재작업 이전 스택에 넣기
					work = ctrlY.pop(); // 이후 작업스택에서 꺼내서 넣기
					System.out.println(work); // 작업출력
				}

			} else {
				System.out.println("종료합니다.");
				break;
			}
		}
	}
}
