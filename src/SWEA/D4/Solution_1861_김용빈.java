package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_김용빈 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static int N = 0;
	static int[][] room;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			
			for(int i=0; i<N; i++) {
				 st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}	
//				������� ����� -----				
			
			max = Integer.MIN_VALUE;
			minNo = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					move(i, j, room[i][j], 1);
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, minNo, max);
		}
		
	}
	static int max, minNo;
	static void move(int x, int y, int roomNo, int cnt) {
//		System.out.println("nowRoom : "+room[x][y]+ " cnt : "+cnt);
		if(max <= cnt) {
			if(max == cnt)
				minNo = (minNo < roomNo) ? (minNo) : (roomNo);
			else
				minNo = roomNo;
			
			max = cnt;
		}
		
		for(int i=0; i<4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if(mx >= 0 && mx < N && my >= 0 && my < N
					&& (room[mx][my] - room[x][y] == 1))
				move(mx, my, roomNo, cnt+1);
			else
				continue;
		}
	}
}
