package day0328_그래프탐색;

public class 그래프01_DFS {
	static int N = 7;
	// 인접 행렬
	static int[][] adj = {
		{ 0, 1, 1, 0, 0, 1, 0 }, 
		{ 1, 0, 0, 1, 0, 0, 1 }, 
		{ 1, 0, 0, 1, 0, 0, 0 },
		{ 0, 1, 1, 0, 0, 0, 1 },
		{ 0, 0, 0, 0, 0, 1, 1 },
		{ 1, 0, 0, 0, 1, 0, 0 }, 
		{ 0, 1, 0, 1, 1, 0, 0 } 
	};
	static boolean[] visited = new boolean[N]; // 방문처리할 배열 필요
	
	public static void main(String[] args) {
		DFS(0);
	}
	
	// 인자로는 현재 내가 방문한 정점이 들어간다
	static void DFS(int v) {
		// v에 대한 방문처리를 하겠다
		visited[v] = true;
		System.out.println(v + 1);
		// 나와 연결되어있으면서 (간선이 존재하면서) 아직 방문하지 않은 정점을 재귀호출
		for(int i = 0; i < N; i++) {
			// 방문하지 않았고, 간선이 존재한다면
			if(!visited[i] && adj[v][i] == 1) {
				DFS(i);
			}
		}
	}
}
