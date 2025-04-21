package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3263_김용빈 {
	static int N, result;
	static int[] child, roll;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			roll = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				roll[temp] = i;
			}
			
			int maxCnt = 0, curCnt = 1;
			for(int i=2; i<=N; i++) {
				if(roll[i-1] < roll[i]) {
					curCnt++;
					maxCnt = Math.max(maxCnt, curCnt);
				}
				else {
					curCnt = 1;
				}
			}
			
			System.out.println("#"+tc+" "+maxCnt);
		}
	}
}
