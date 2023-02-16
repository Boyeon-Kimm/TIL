package test01;

public class FindMin {
	public static void main(String[] args) {
		int[] A = {32, 2, 33, 56, 2, 1, 4};
		
		int min = A[0];
		int minIdx = 0;
		
		for(int i=1; i< A.length; i++) {
			if(min > A[i]) {
				min = A[i];
				minIdx = i;
			}
		}
		System.out.println(min);
		System.out.println(minIdx);
	}
}
