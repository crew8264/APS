package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15649_김용빈 {
	static int N, M;
	static int[] numbers;
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		isVisited = new boolean[N];
		
		permu(0);
//		comb(0, 0);
	}
	
	static void permu(int cnt) {
		if(cnt == M) {
			for(int i=0; i<numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				numbers[cnt] = i+1;
				permu(cnt+1);
				isVisited[i] = false;
			}
		}
	}
	
}
