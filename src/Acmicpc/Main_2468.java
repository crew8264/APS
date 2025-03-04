package qwe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2468 {
	static int[] dx = {0, -1, 0, 0, 1};
	static int[] dy = {0, 0, -1, 1, 0};
	
	static int N, ans;
	static int[][] flood;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		flood = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				flood[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int maxAns = -1;
		for(int a=0; a<100; a++) {
			ans = 0;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(flood[i][j] > a && !visited[i][j]) {
						dfs(i, j, a);
						ans++;
					}
				}
			}
			
			if(maxAns < ans)
				maxAns = ans;
		}
		
		System.out.println(maxAns);
	}
	
//	static void BFS(int a) {
//		boolean visited[] = new boolean[N];
//		LinkedList<Integer> queue = new LinkedList<Integer>();
//		
//		visited[a] = true;
//		queue.add(a);
//		
//		
//	}
	

	// dfs 구현
	static void dfs(int x, int y, int a) {
		if(flood[x][y] <= a) { return; }
		
		
		for(int i=0; i<5; i++) {
			int mx = x+dx[i]; int my = y+dy[i];
			if(mx < 0 || mx >= N || my < 0 || my >= N // 범위 벗어났을 경우,
					|| (visited[mx][my])) // 방문했을 경우 
				continue;
			
			visited[mx][my] = true;
			
//			// 출력 용도
//			for(int q=0; q<N; q++) {
//				System.out.println(Arrays.toString(visited[q]));
//			}System.out.println(x+" "+ y);
//			// 출력 용도
			
			dfs(mx, my, a);
		}
	}
}
