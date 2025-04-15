package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2117 {
	static int N, M;
	static int[][] maps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int T = Integer.parseInt(br.readLine());
		int T = 1; N = -1; M = -1;
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			maps = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
		}
	}
	
	static int distance(int ax, int ay, int bx, int by) {
		return (int) Math.sqrt((Math.pow((bx-ax)+(by-ay),2)));
	}
}
