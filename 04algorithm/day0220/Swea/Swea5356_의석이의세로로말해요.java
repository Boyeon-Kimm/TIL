package homework;

import java.util.Scanner;

public class Swea5356_의석이의세로로말해요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// t번의 테스트 케이스
		
		for(int tc = 1; tc <= t; tc++) {
			char[][] arr = new char[5][15];
			
			for(int i = 0 ; i < 5; i++) {
				String str = sc.next();
				for(int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
			}
		
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 5; j++) {
					if(arr[j][i] != 0) {
						System.out.print(arr[j][i]);
					}
				}
			}
			System.out.println();
		}
	}
}
