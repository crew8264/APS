package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15665 {
	static int N, M;
	static int[] arr, ans;
	static boolean[] selected = new boolean[10001];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) { 
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		comb(0, 0);
		System.out.println(sb);
		
	}
	
	
	static void comb(int cnt, int st) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(ans[i]).append(" ");
			}sb.append("\n");
		return;
		}
		
		int prev = -1;
		for(int i=st; i<N; i++) {
			if(prev == arr[i]) continue;
			ans[cnt] = arr[i];
			prev = arr[i];
			comb(cnt+1, i);
		}
	}
}
