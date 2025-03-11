package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_김용빈_retry {
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
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
		
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && flood[i][j] > 5) {
					visited[i][j] = true;
					getOff(1, i, j, 5);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	
	static void getOff(int cnt, int x, int y, int a) {
		if(flood[x][y] < a) return;
		
		for(int i=0; i<4; i++) {
			int mx = x+dx[i];
			int my = y+dy[i];
			
			if(mx >= 0 && mx < N && my >= 0 && my < N) {
				if(!visited[mx][my]) {
					visited[mx][my] = true;
					getOff(cnt+1, mx, my, a);
				}
			}
		}
	}
}
