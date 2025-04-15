package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_2115 {
	static int N, M, C;
	static int[][] maps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			C = Integer.parseInt(br.readLine());
			
			maps = new int[N][N];
			
		}
	}
	
	static ArrayList<Integer> result = new ArrayList<>();
	static void process() {
		
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N-M; i++) {
				for(int j=i+M; j<N-M; j++) {
					for(int l=0; l<M; l++) {
						int sum = maps[k][i+l]*maps[k][i+l];
						if(sum > C) continue;
						
					}
				}
			}
		}
		
	}
	
	static ArrayList<Integer> selected = new ArrayList<>();
	static void subset(int cnt, int st) {
		if(cnt == M) {
			int sum = 0;
			for(Integer i: selected) {
				sum += i*i;
			}
			return;
		}
		for(int i=st; i<N; i++) {
			selected.add(i);
			subset(cnt+1, i);
			selected.remove(cnt);
			subset(cnt+1, i);
		}
	}
	
	static int getProfit() {
		return 0;
	}
}
