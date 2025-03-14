package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_김용빈 {
	static int N, K, sum = 0;
	static int[] cable;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		cable = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cable[i] = Integer.parseInt(st.nextToken());
			sum += cable[i];
		}
		
		System.out.println(sum / K);
		
	}
	static void cableDiv(int cables, int target) {
		int left = 0, right = 1;
		int answer = 0;
		while (left <= right) {
			int mid = (int) (left + right) / 2;
			
		}
	}
}
