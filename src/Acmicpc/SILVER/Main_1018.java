package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1018 {
	static int N, M, min = Integer.MAX_VALUE;
	static String[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new String[N][M];
		for(int i=0; i<N; i++) {
			String[] arr = br.readLine().split("");
			for(int j=0; j<M; j++) {
				board[i][j] = arr[j];
			}
		}

		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				reColor(i, j);
			}
		}
		System.out.println(min);
		
	}
	static void reColor(int x, int y) {
		int cnt = 0;
		String BW = "B";
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(board[i][j].equals(BW)) {
					cnt++;
				}
				
				if(BW.equals("B")) BW = "W";
				else	BW = "B";
//				System.out.print(BW);
			}				
			if(BW.equals("B")) BW = "W";
			else	BW = "B";
		}
		
		cnt = Math.min(cnt,  64-cnt);
		min = Math.min(cnt, min);
	}
}