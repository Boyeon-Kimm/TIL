package day0329_크루스칼;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 크루스칼 {
	static int[] p; // 대표를 저장할 배열
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // V : 정점의 개수, 0부터 시작한다!
		int E = sc.nextInt(); // E : 간선의 수
		
		// 간선을 저장하기 위해서 클래스를 사용할 수도 있지만
		// 배열을 이용해서 저장을 하겠다.
		// 0 : 시작정점 / 1 : 끝정점 / 2 : 가중치
		int[][] edges = new int[E][3];
		
		for(int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		// 크루스칼 1단계 : 간선을 오름차순 정렬한다.
		// 2차원 배열, 인자로는 int형 배열을 가지고 정렬을 할거야
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		// 크루스칼 2단계 : V - 1개의 간선을 뽑는데
		// 사이클이 발생하지 않는 친구들만 뽑는다
		p = new int[V];
		// make-set하자. 나 자신을 대표로 초기화 하자
		for(int i = 0; i < V; i++) {
//			makeset(i);
			p[i] = i;
		} // makeset 다했어~
		
		int ans = 0; // 최소비용 저장할 변수
		int pick = 0; // 내가 뽑은 간선의 수
		
		// 모든 간선을 순회하면서 체크
		// while로도 해보기
		for(int i = 0; i < E; i++) {
			// i번째의 간선을 뽑아 두 정점의 대표를 확인하겠다
//			int x = edges[i][0];
//			int y = edges[i][1];
			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);
			
			// x의 대표와 y의 대표가 다르다면
			// 사이클이 아니므로, 고를 수 있다. union 해야한다
//			if(findset(x) != findset(y)) {
			if(findset(px) != findset(py)) {
//				union(x, y);
				union(px, py);
				ans += edges[i][2];
				pick++;
			}
			
			if(pick == (V - 1)) break;
		}
		System.out.println(ans);
	}
	
	// 대표를 반환해야 하므로
	static int findset(int x) {
		// 순수 기술
//		if(x == p[x]) return x;
//		return findset(p[x]);
		
		// path compression 적용
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		// rank 고려 안하고 y를 무조건 x밑으로 붙이기
//		p[findset(y)] = findset(x);
		p[y] = x; // 정석은 아니지만 이번 문제에서 가능한 부분
		// 왜 이렇게 써도 되는지는 알고 사용해야한다
	}
	
	private static void makeset(int x) {
		p[x] = x;
		// rank는 따로 하지 않을 것입니당
	}

	static String input = "7 11\r\n" + 
			"0 1 32\r\n" + 
			"0 2 31\r\n" + 
			"0 5 60\r\n" + 
			"0 6 51\r\n" + 
			"1 2 21\r\n" + 
			"2 4 46\r\n" + 
			"2 6 25\r\n" + 
			"3 4 34\r\n" + 
			"3 5 18\r\n" + 
			"4 5 40\r\n" + 
			"4 6 51\r\n" + 
			"\r\n";
}
