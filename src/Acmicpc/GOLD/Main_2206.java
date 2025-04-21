package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2206 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N, M, result;
	static int[][] maps, visited;
	
	static class WallMove {
		int x;
		int y;
		int behavior;
		int breakCount;
		
		public WallMove(int x, int y, int behavior, int breakCount) {
			super();
			this.x = x;
			this.y = y;
			this.behavior = behavior;
			this.breakCount = breakCount;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		maps = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split("");
			for(int j=0; j<M; j++) {
				maps[i][j] = Integer.parseInt(input[j]);
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		result = Integer.MAX_VALUE;
		
		BFS(0, 0);
		
		if(result == Integer.MAX_VALUE)
			result = -1;
			
			
		System.out.println(result);
		
	}
	
	static void BFS(int x, int y) {

		ArrayDeque<WallMove> que = new ArrayDeque<>();
		que.add(new WallMove(x, y, 1, 0));
		visited[x][y] = 0;
		
		while(!que.isEmpty()) {
			WallMove mv = que.poll();
			
			if(mv.x==N-1 && mv.y==M-1) { // 종료 조건
				result = mv.behavior;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int tx = mv.x + dx[i];
				int ty = mv.y + dy[i];
				
				if(tx<0 || tx>=N || ty<0 || ty>=M) continue;
				if(visited[tx][ty] <= mv.breakCount) continue;
				
				if(maps[tx][ty]==0) {
					visited[tx][ty] = mv.breakCount;
					que.add(new WallMove(tx, ty, mv.behavior+1, mv.breakCount));
				} else {
					if(mv.breakCount==0) {
						visited[tx][ty] = mv.breakCount + 1;
						que.add(new WallMove(tx, ty, mv.behavior+1, mv.breakCount+1));
					}
				}
			}
		}
	}
}




