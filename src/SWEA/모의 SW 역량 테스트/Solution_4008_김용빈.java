package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008_김용빈 {
	static int T, N;
	static int[] za, input;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine()); // 숫자의 개수
			
			za = new int[N-1]; // [ + : - : * : /  ]
			input = new int[N];
			isSelected = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N-1; i++) {
				za[i] = Integer.parseInt(st.nextToken());				
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
//			여기까지 입출력 -----------------
			
			comb(0 ,0);
		}
	}
	
	static void comb(int cnt, int start) {
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				if(isSelected[i]) System.out.print(input[i]);
			}System.out.println();
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			comb(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
}

