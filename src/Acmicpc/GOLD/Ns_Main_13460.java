package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ns_Main_13460 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N, M, result=1000000;
	static char[][] maps;
	static boolean[][] rVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		maps = new char[N][M];
		rVisited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split("");
			for(int j=0; j<M; j++) {
				maps[i][j] = input[j].toCharArray()[0];
			}
		}
		
		
	}
	
	static void DFS(int cnt, int bx, int by, int rx, int ry) {
		// 홀에 도착하면
		if(maps[rx][ry] == 'O')
			result = Math.min(result, cnt);
		
		// 10번 이하로 못끝내면
		if(cnt > 10) {
			if(result == 100000) result = -1;
		}
		
		for(int i=0; i<4; i++) {
			int mbx = bx+dx[i];
			int mby = by+dy[i];
			
			int mrx = rx+dx[i];
			int mry = ry+dy[i];
			
			if(maps[mrx][mry] == '.' || maps[mrx][mry] == 'O') {
				if(maps[mbx][mby] == 'O') {
					continue;
				}
				if(maps[mbx][mby] != '.') {
					mbx = bx;
					mby = by;
				}
				
				rVisited[mrx][mry] = true;
				DFS(cnt+1, mbx, mby, mrx, mry);
				rVisited[mrx][mry] = false;
			}
			
			
		}
	}
}
