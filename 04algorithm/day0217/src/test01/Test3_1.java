package test01;

public class Test3_1 {
	public static void main(String[] args) {
		// itoa : 정수 => 문자열
		String str = itoa(4321);
		System.out.println(str);
	}

	private static String itoa(int value) {
		StringBuilder sb = new StringBuilder();
		int tmp = value;
		while(tmp > 0) {
			char c = (char)(tmp % 10 + 48); // 각 숫자에다가 48을 더해줘야 그 숫자의 문자코드가 됨 
			sb.append(c);
			tmp /= 10; // 그 다음자리로 넘어간다.
		}
		
		return sb.reverse().toString();
	}
	

}
