package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3307_김용빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			int[] 배열 = new int[K];
			int[] 결과 = new int[K];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) {
				배열[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i=0; i<K; i++) {
				결과[i] = 1;
				for(int j=0; j<i; j++) {
					if(배열[j] <= 배열[i] && 결과[i] < 결과[j]+1) {
						결과[i] = 결과[j]+1;
					}
				}
				max = Math.max(max, 결과[i]);
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
