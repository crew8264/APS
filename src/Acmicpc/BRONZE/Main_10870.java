package Acmicpc.BRONZE;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10870 {
	static long[] memo;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		memo = new long[N+1];
		Arrays.fill(memo, -1);
		
		System.out.println(Fibo(N));
	}
	
	static long Fibo(int n) {
		if(n<0) return 0;
		if(n==1) return 1;
		if(memo[n] == -1) {
			memo[n] = Fibo(n-1) + Fibo(n-2);
		}
		return memo[n];
	}
}

