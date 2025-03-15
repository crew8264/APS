package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10816 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int[] sa = new int[20000001];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			sa[10000000 + Integer.parseInt(st.nextToken())]++;
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			sb.append(sa[10000000 + Integer.parseInt(st.nextToken())]+" ");
		}
		
		System.out.println(sb);
		
		
	}
}
