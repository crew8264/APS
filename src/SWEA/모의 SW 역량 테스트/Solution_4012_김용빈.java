package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_4012_김용빈 {
	
	static int T, N, minGap;
	static int food[][];
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			food = new int[N][N];
			isSelected = new boolean[N];
			minGap = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}		
			
			permu(0,0);
			System.out.println("#"+tc+" "+minGap);
		}
	}
	
	
	static void permu(int cnt, int start) {
		if(cnt == N/2) {
			ArrayList<Integer> groupA = new ArrayList<>();
			ArrayList<Integer> groupB = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					groupA.add(i);
				} else {
					groupB.add(i);
				}
				

			}
			int nowGap = Math.abs(getScore(groupA)-getScore(groupB));
			if(nowGap < minGap)
				minGap = nowGap;
			
			return;
		}
		

	}
	
	static int getScore(ArrayList<Integer> arr) {
		int sum = 0;
		
		for(int i=0; i<arr.size(); i++) {
			for(int j=0; j<arr.size(); j++) {
				if(i == j) continue;
				sum += food[arr.get(i)][arr.get(j)];
			}
		}
		return sum;
	}
}
