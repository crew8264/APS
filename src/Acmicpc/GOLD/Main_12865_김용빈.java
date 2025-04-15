package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12865_김용빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		int[][] table = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			input = br.readLine().split(" ");
			weights[i] = Integer.parseInt(input[0]);
			profits[i] = Integer.parseInt(input[1]);
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(weights[i] > j) {
					table[i][j] = table[i-1][j];
				} else {
					table[i][j] = Math.max(table[i-1][j], table[i-1][j-weights[i]] + profits[i]);
				}
			}
		}
		
		System.out.println(table[N][K]); 
	}
}