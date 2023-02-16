package test01;

public class Test1_순열 {
	public static void main(String[] args) {
		// a부터 b까지의 연속된 숫자 중에서
		// 3개를 뽑아서 나열하는 순열
		
		int a = 1;
		int b = 4;
		// 1, 2, 3, 4 네 개의 숫자 중에서 3개를 뽑아 나열하는 순열
		
		// 그럼 연속되지 않은 서로다른 n개의 숫자중에서 3개를 뽑는 방법은??
		
		for(int i = a; i <= b; i++) {
			for(int j = a; j <= b; j++) {
				// j는 어떤 수만 올 수 있나요?
				// j는 i가 아닌 수여야 함.
				if(j != i) { // if문 안에서 그 다음 for문이 돌아야겠죠?
					for(int k = a; k <= b; k++) {
						// k는 어떤 수가 올 수 있죠?
						// k는 i도 아니고 j도 아니어야 함
						if(k != i && k != j) {
							System.out.printf("%d %d %d\n", i, j, k);
						}
					}
				}
			}
		}
	}
}
