package Homework;

import java.util.Scanner;

public class Swea1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 10회 반복
		for(int i = 1; i < 11; i++) {
			// 덤프 수 입력받기
			int dump = sc.nextInt();
			// 가로의 길이는 100 고정
			int[] boxes = new int[100];
			// 박스 개수 입력받기
			for(int j = 0; j < 100; j++) {
				boxes[j] = sc.nextInt();
			}
			
			int minIdx = 0;
			int maxIdx = 0;
			// 덤프 가능 개수만큼 반복
			for(int j = 0; j < dump; j++) {
				// 최댓값, 최솟값이 들어있는 배열 인덱스 찾기
				for(int k = 0; k < 100; k++) {
					if(boxes[k] > boxes[maxIdx]) maxIdx = k;
					if(boxes[k] < boxes[minIdx]) minIdx = k;
				}
				boxes[maxIdx] -= 1;
				boxes[minIdx] += 1;
			}
			int max = 0;
			int min = 100;
			// 박스 옮기는(-1, +1)작업이 끝나고
			// 남아있는 박스의 최댓값 최솟값 구하여 빼기
			for(int j = 0; j < 100; j++) {
				if(boxes[j] > max) max = boxes[j];
				if(boxes[j] < min) min = boxes[j];
			}
			int result = max - min;
			System.out.println("#"+i+" "+result);
		}
		
	}
}
