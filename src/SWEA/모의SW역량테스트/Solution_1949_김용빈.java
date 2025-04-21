package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1949_김용빈 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N, K, maxHeight = -1, result = -1;
	static int[][] maps;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테케 횟수
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N x N 맵 크기
			K = Integer.parseInt(st.nextToken()); // 깎을 수 있는 높이
			
			result = -1; maxHeight = -1;
			maps = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, maps[i][j]); // 최대 높이 구해두기
				}
			}
			
			// 꼭대기에서만 DFS 호출
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(maps[i][j] == maxHeight) {
						visited[i][j] = true;
						DFS(1, 0, i, j);
						visited[i][j] = false;
					}
				}
			}

			System.out.println("#" + tc + " " + result); // 최종 출력
		}
	}
	
	static void DFS(int cnt, int cut, int x, int y) {
		
		result = Math.max(result, cnt);
		
		for(int i=0; i<4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if(mx<0 || mx >= N || my<0 || my>= N
					|| visited[mx][my])
				continue;
			
			if(cut == 0) {
				for(int j=1; j<=K; j++) {
					if(maps[x][y] > maps[mx][my]-j) {
						maps[mx][my] -= j;
						visited[mx][my] = true;
						DFS(cnt+1, cut+1, mx, my);
						visited[mx][my] = false;
						maps[mx][my] += j;
					}
				}
			} 
			if(maps[x][y] > maps[mx][my]) {
				visited[mx][my] = true;
				DFS(cnt+1, cut, mx, my);
				visited[mx][my] = false;
			}
		}
	}
}
