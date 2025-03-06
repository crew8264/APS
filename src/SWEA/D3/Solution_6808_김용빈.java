package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_김용빈 {
	static int T, N, win, lose;
	static int[] input, numbers;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		N = 9;

		for(int tc=1; tc<=T; tc++) {

			win = 0; lose = 0;
			input = new int[N];
			numbers = new int[N];
			isSelected = new boolean[19];

			st = new StringTokenizer(br.readLine());
			for(int i=0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				isSelected[input[i]] = true;
			}
			
			permu(0);
			
			System.out.printf("#%d %d %d\n", tc, win, lose);
		}
		
	}
	
	static void permu(int cnt) {
		if(cnt == N) {
			int scoreA = 0;
			int scoreB = 0;
			
			for(int i=0; i<N; i++) {
				if(numbers[i] > input[i])
					scoreA += numbers[i] + input[i];
				else 
					scoreB += numbers[i] + input[i];					
			}
			if(scoreA < scoreB) {
				win++;
			} else lose++;
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=1; i<=18; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				numbers[cnt] = i;
				permu(cnt+1);
				isSelected[i] = false;
			}
		}
	}
}
