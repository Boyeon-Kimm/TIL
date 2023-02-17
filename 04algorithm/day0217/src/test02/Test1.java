package test02;

public class Test1 {
	public static void main(String[] args) {
		char[] t = "This iss a book".toCharArray();
		char[] p = "iss".toCharArray();
		
		int idx = BruteForceFor(p, t);
		// 5를 출력 : 5번째 인덱스에 있다는 것을 찾음
		System.out.println(idx);
	}
	
	private static int BruteForceFor(char[] p, char[] t) {
		int n = t.length;
		int m = p.length;
		
		// pattern이 한 칸씩 shift가 최대 n-m+1번 수행
		for(int i = 0; i < n - m + 1; i++) {
			// 일치여부를 매번(각 shift에서) 판단해야하기 때문에 boolean필요
			// 일치한다고 가정하고 비교 시작
			boolean flag = true;
			// 각 shift에서 1:1 비교가 최대 m번 수행
			for(int j = 0; j < m; j++) {
				// 일치하지 않는게 발견되면
				if(p[j] != t[i+j]) {
					flag = false; // 일치하지 않는다고 바꾼다
					break;
				}
			}
			// 다 돌았을 때 flag가 true인 경우는 : 모두 일치
			// false인 경우는 : 모두 일치 X
			// 모두 일치하는 경우에만 i를 리턴
			if(flag) return i;
		}
		return -1;
	}
	
}
