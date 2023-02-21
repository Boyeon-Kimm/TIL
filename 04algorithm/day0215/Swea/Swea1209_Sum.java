Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		
		// 10번의 테스트 케이스
		for(int t = 1; t <= 10; t++) {
			int rightDownSum = 0;
			int leftDownSum = 0;
			int rightMax = 0;
			int downMax = 0;
			int first = 0;
			int second = 0;
			int result = 0;
			
			// 테스트 케이스 번호
			int num = sc.nextInt();
			
			// 100 x 100 배열에 숫자 입력
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 행과 열을 탐색하면서 더하기
			for(int i = 0; i < arr.length; i++) {
				rightDownSum += arr[i][i];
				leftDownSum += arr[i][arr.length-i-1];
				
				// →, ↓ 값 초기화
				int rightSum = 0;
				int downSum = 0;
				
				// → rightSum : 각 행의 합, ↓ downSum : 각 열의 합
				for(int j = 0; j < arr.length; j++) {
					rightSum += arr[i][j];
					downSum += arr[j][i];
				}
				
				// 행의 최댓값, 열의 최댓값 구하기
				rightMax = Math.max(rightSum, rightMax);
				downMax = Math.max(downSum, downMax);
			}
			// 행의 최댓값과 열의 최댓값 중 큰 값 = first
			// 대각선 합 중 큰 값 = second
			// 각 부분의 최댓값을 비교하여 가장 큰 값 구하기
			first = Math.max(rightMax, downMax);
			second = Math.max(rightDownSum, leftDownSum);
			result = Math.max(first, second);
			
			System.out.println("#"+t+" "+result);
		}