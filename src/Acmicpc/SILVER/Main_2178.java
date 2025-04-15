package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2178 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static int N, M;
	static int[][] maps;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maps = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<M; j++) {
				int tempp = Integer.parseInt(temp[j]);
				if(tempp == 0)
					visited[i][j] = true;
				
			}
		}

		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.add(new int[] {0, 0});
		visited[0][0] = true;
		maps[0][0] = 1;
		
		BFS(que);
//		DFS(1, 0, 0);
		
		
		
		System.out.println(result);
	}
	
	static int result = Integer.MAX_VALUE;
	
	static void BFS(ArrayDeque<int[]> queue) {
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nx = now[0];
			int ny = now[1];
			
			if(nx == N-1 && ny == M-1) {
				result = Math.min(result, maps[nx][ny]);
			}
			
			for(int i=0; i<4; i++) {
				int mx = nx+dx[i];
				int my = ny+dy[i];
				
				if(mx >= 0 && mx < N && my >= 0 && my < M
						&& !visited[mx][my]) {
					visited[mx][my] = true;
					queue.add(new int[] {mx, my});
					maps[mx][my] = maps[nx][ny] + 1;
				}
			}
			
		}
		
	}
	
	
	static void DFS(int cnt, int x, int y) {
		if(x==(N-1) && y==(M-1)) {
			if(result > cnt) {
				result = cnt;
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			int mx = x+dx[i];
			int my = y+dy[i];
			
			if(mx >= 0 && mx < N && my >= 0 && my < M
					&& !visited[mx][my]) {
				visited[mx][my] = true;
				DFS(cnt+1, mx, my);
				visited[mx][my] = false;
				
			}
		}
	}
}
