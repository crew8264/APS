package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15651 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		comb(0, N);
		System.out.println(sb);
	}

	static void comb(int cnt, int ed) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(" ");
			}sb.append("\n");
			return;
		}
		for(int i=1; i<=ed; i++) {
			arr[cnt] = i;
			comb(cnt+1, ed);
		}
	}
}
