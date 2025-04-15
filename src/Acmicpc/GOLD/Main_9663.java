package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_9663 {
	static int N, result;
	static int[] queen;
	static int[][] activated;
	static ArrayList<int[]> queenList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		queen = new int[N];
		activated = new int[N][N];
		
		queen(0);
		System.out.println(result);
	}
	
	static void queen(int cnt) { // cnt는 행
		if(cnt == N) {
			result++;
			return;
		}
		
		for(int i=0; i<N; i++) { // 열 관리
			if(blockQueen(cnt, i)) continue;
			queen[cnt] = i;
			queen(cnt+1);
			
		}
	}
	
	static boolean blockQueen(int x, int y) {
		for(int i=0; i<x; i++) {
			if(queen[i] == y || Math.abs(x-i) == Math.abs(y-queen[i])) return true;
		}
		
		return false;
	}
}
