
public class KMP {
	public static void main(String[] args) {
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";
		
		kmp(text, pattern);
	}
	
	// 실패테이블 getPi()
	public static int[] getPi(String pt) {
		// 접두사와 접미사가 일치하는 최대 길이를 담을 배열
		int[] pi = new int[pt.length()]; // 0 ~ i까지의 부분문자열에서 접미사/접두사 일치하는 길이 담음
		
		int j = 0; // 현재 여기까지는 같아요~~
		// i, j가 가리키는 값이 같다면 둘다 포인트를 증가해
		// i는 무조건 증가
		for(int i = 1; i < pt.length(); i++) {
			// 지금 두 포인트가 가리키는 값이 다르다면
			while(j >0 && pt.charAt(i) != pt.charAt(j)) {
				j = pi[j - 1];
			}
			
			// 지금 두 포인트가 가리키는 값이 같다면
			if(pt.charAt(i) == pt.charAt(j)) {
				// i번쨰의 최대길이는 ++j한 값
				pi[i] = ++j;
			}
		}
		return pi;
	}
	
	public static void kmp(String text, String pt) {
		int[] pi = getPi(pt); // 실패함수를 가지고 왔다.
//		System.out.println(Arrays.toString(pi));
		
		int j = 0; // 패턴 내에서 움직이는 인덱스
		for(int i = 0; i < text.length(); i++) {
			// 실패했을 때 j를 점프시킨다.
			while(j > 0 && text.charAt(i) != pt.charAt(j)) {
				j = pi[j - 1];
			}
			// 내가 보고있는 패턴위치와 부모의 위치의 값이 동일하다면
			if(text.charAt(i) == pt.charAt(j)) {
				// j의 값이 패턴의 길이 -1이라는 것은 무슨 의미? 패턴 찾았다~
				if(j == pt.length() - 1) {
					System.out.println((i - pt.length() + 1) + "패턴을 찾았습니다.");
					j = pi[j];
				} else {
					// 다 찾은게 아니라면 계속 진행해야하니까 j증가
					j++;
				}
			}
		}
	}
}
