package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1018_self {
	static int N, M, min = Integer.MAX_VALUE;
	static boolean[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String[] arr = br.readLine().split("");
			for(int j=0; j<M; j++) {
				if(arr[j].equals("B"))
				board[i][j] = true;
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
		int count = 0;
		boolean BorW = false;
		
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(board[i][j] != BorW)
					count++;
				BorW = !BorW;
			}
			BorW = !BorW;
		}
		count = Math.min(count, 64-count);
		min = Math.min(min, count);
	}
}
