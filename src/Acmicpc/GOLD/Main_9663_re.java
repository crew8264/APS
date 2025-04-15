package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_9663_re {
	static int N, result = 0;
	static int[] queenPos;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		queenPos = new int[N];
		
		queen(0);
		System.out.println(result);
	}
	
	static void queen(int cnt) {
		if(cnt == N) {
			result++;
		}
		
		for(int i=0; i<N; i++) {
			if(isBlocked(cnt, i)) continue;
			queenPos[cnt] = i;
			queen(cnt+1);
		}
	}
	
	static boolean isBlocked(int x, int y) {
		for(int i=0; i<x; i++) {
			if(queenPos[i] == y || Math.abs(x-i) == Math.abs(y-queenPos[i])) return true;
		}
		return false;
	}
}
