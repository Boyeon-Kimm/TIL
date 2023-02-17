package test01;

public class Test3 {
	public static void main(String[] args) {
		// atoi : ASCII to Integer 문자열 => 정수
		int num = atoi("1234");
		System.out.println(num);
	}
	
	private static int atoi(String string) {
		char[] arr = string.toCharArray();
		int value = 0;
		// 음수인 경우에는 '-'이 있는지 여부를 먼저 체크한다.
		
		int digit; // 각각의 숫자를 가져올 임시 변수
		for(int i = 0; i < arr.length; i++) {
			// arr[i]이 0보다 크거나 같고 48보다 작거나 같아야함(0 ~ 9)
			if(arr[i] >= '0' && arr[i] <= '9')
				digit = arr[i] - '0';
			else
				break;
			value = (value * 10) + digit;
		}
		
		return value;
	}
}
