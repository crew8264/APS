package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1868_김용빈 {
	static int[] dx = {-1, -1, -1, 	 0, 0, 	 1, 1, 1}; // 팔방 탐색 돌릴 델타 좌표
	static int[] dy = {-1, 	0, 	1, 	-1, 1, 	-1, 0, 1};
	
	static int T, N, ans;
	static int[][] mine;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			ans = 0;
			mine = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				String[] str = br.readLine().split("");
				for(int j=0; j<N; j++) {
					if(str[j].equals("*")) {
						mine[i][j] = 9;
					} else if(str[j].equals(".")) {
						mine[i][j] = 0;
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				System.out.println(Arrays.toString(mine[i]));
			}
//			여기까지 입출력 ---------------------
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(mine[i][j] == 0 && checking(i, j) && !visited[i][j]) {
					working(i, j);
					ans++;
					}
				}
			}
		
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && mine[i][j] == 0) {
						visited[i][j] = true;
						ans++;
					}
				}
			}

			for(int i=0; i<N; i++) {
				System.out.println(Arrays.toString(visited[i]));
			}
			
			
			System.out.println("ans: "+ans);
		}
	}
	
	static void working(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx < 0 || tx >= N || ty < 0 || ty >= N
					|| visited[tx][ty] || mine[tx][ty] == 9) continue;
			visited[tx][ty] = true;
			if(checking(tx, ty)) {
				working(tx, ty);
			}
		}
	}
	
	static boolean checking(int x, int y) {
		for(int i=0; i<8; i++) {
			int tx = x+dx[i];
			int ty = y+dy[i];
			
			if(tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
			if(mine[tx][ty] == 9) 
				return false;
		}
		return true;
	}
}

/*
1
3
..*
..*
**.

1
5
..*..
..*..
.*..*
.*...
.*...

*/