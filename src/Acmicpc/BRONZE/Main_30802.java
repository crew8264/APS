package Acmicpc.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_30802 {
	static int N, T, P, sum;
	static int[] Tshirt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		Tshirt = new int[6];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++) {
			Tshirt[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<6; i++) {
			if(Tshirt[i] == 0) continue;
			if(Tshirt[i] > T) {
				if((Tshirt[i] % T) == 0)
					sum += (Tshirt[i] / T);
				else {
					sum += (Tshirt[i] / T) + 1;
				}
			} else {
				sum++;
			}
		}
	
		
		
		System.out.println(sum);
		System.out.println(N / P +" "+N % P);
	}
}
