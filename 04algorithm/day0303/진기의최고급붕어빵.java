package test01;

import java.util.Scanner;

public class 진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			// 첫번째 줄 입력을 받았고...
			int N = sc.nextInt(); // 손님의 수
			int M = sc.nextInt(); // 붕어빵 제작시간, 쿨타임
			int K = sc.nextInt(); // 붕어빵 개수
			
			// 일단은 가능하다고 가정해놓고 시작
			String ans = "Possible";
			
			// 각 초마다 몇명의 손님이 올지 배열에 저장
			// 0초 ~ 11111초 => 배열의 크기 11112
			int[] times = new int[11112]; // times[i] : i초에 오는 손님의 수
			
			// 두번째 줄 입력을 받아야 하는데...
			// N명의 도착시간이 주어짐
			for(int i = 0; i < N; i++) {
				int time = sc.nextInt(); // 손님의 도착시간
				times[time]++; // 해당 시간에 도착하는 손님의 수 세기
			}
			
			// 0초, 1초, 2초, ... , 11111초 반복하면서
			// 만약에 붕어빵 만들 시간이 됐다면, 붕어빵 만들고
			// 해당 초에 손님이 있다면, 그 손님 수만큼 붕어빵 나눠주고(붕어빵 차감)
			// 만약에 나눠줄 수 없는 상황이라면(붕어빵 수가 음수가 된다면)
			//  => Impossible로 바꾸고 반복문 종료
			
			// 0초, 1초, 2초, ..., i초, ...., 11111초
			// i : 몇 초인지
			int bread =0; // 붕어빵 개수 초기화
			for(int i = 0; i <= 11111; i++) {
				
				// 언제 붕어빵을 만들면 될까?
				// M초마다 만들면 되는데..
				// M의 배수이면 되는데..
				if(i != 0 && i % M == 0) {
					bread += K; // K개만큼 빵을 추가
				}
				
				// 만약에 i초에 도착하는 손님이 있다면
				// 붕어빵을 나눠줌
				bread -= times[i];
				
				// 붕어빵을 나눠주고 났더니
				// 붕어빵 개수가 음수가 된다면???
				if(bread < 0) {
					ans = "Impossible";
					break;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
