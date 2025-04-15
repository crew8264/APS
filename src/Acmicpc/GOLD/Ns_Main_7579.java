package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ns_Main_7579 {
	static int N, M;
	static int[] weights, profits;
	static int[][] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		weights = new int[N+1];
		profits = new int[N+1];
		D = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
//		?—¬ê¸°ê¹Œì§? ?ž…? ¥ ---------------------------
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				
			}
		}
		
		
	}
}
