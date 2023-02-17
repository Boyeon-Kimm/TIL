package test01;

import java.util.Arrays;

public class Test4 {
	public static void main(String[] args) {
		// 문자열 뒤집기
		
		// 1. Swap
		
		String str = "삼성청년SW아카데미";
		char[] arr = str.toCharArray();
		// 이 길이의 반만큼만 반복
		for(int i = 0; i < arr.length / 2; i++) {
			// swap
			char temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		System.out.println(Arrays.toString(arr));
		// 문자의 배열 => 문자열
		String str2 = String.valueOf(arr);
		System.out.println(str2);
		
		// 2. 새로운 배열을 만들어서 거꾸로
//		char[] arr3 = new char[arr.length]; 이렇게도 가능
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length-1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb.toString());
		
		// 3. StringBuilder
		sb.reverse();
	}
}
