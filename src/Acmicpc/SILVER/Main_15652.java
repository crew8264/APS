package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15652 {
	static int N, M;
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		array = new int[M];
		
		Comb(0, 0);
	}
	
	
	static void Comb(int cnt, int st) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(array[i]+" ");
			}System.out.println();
			return;
		}
		
		for(int i=st; i<N; i++) {
			array[cnt] = i+1;
			Comb(cnt+1, i);
		}
	}
}
