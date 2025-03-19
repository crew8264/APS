package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int[] many = new int[8001];
		
		int sum = 0, avg, mid, md = 0, gap; 
		
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			sum += input[i];
			many[input[i] + 4000]++;
		}
		
		boolean second = false;
		int max = -1;
		for(int i=0; i<8001; i++) {
			if(max < many[i]) {
				max = many[i];
				md = i-4000;
				second = true;
			} else if(max == many[i] && second) {
				md = i-4000;
				second = false;
			}
		}
		
		Arrays.sort(input);
		avg = (int) Math.round((double) sum / N);
		mid = input[N/2];
		gap = input[N-1] - input[0];
		
		System.out.println(avg);
		System.out.println(mid);
		System.out.println(md);
		System.out.println(gap);
	}
}
