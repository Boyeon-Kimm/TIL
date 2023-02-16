package test01;

public class Select {
	public static void main(String[] args) {
		int[] nums = {5, 4, 1, 2, 3};
		
		int idx = select(nums, 3);
		System.out.println(idx);
	}

	private static int select(int[] nums, int k) {
		for(int i=0; i<k; i++) {
			int minIdx = i;
			for(int j=i+1; j<k; j++) {
				if(nums[minIdx] > nums[j]) {
					minIdx = j;
				}
			}
			
			int temp = nums[i];
			nums[i] = nums[minIdx];
			nums[minIdx] = temp;
		}
		return nums[k];
	}
}
