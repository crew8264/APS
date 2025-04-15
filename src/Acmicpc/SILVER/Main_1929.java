package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		boolean[] isPrime = new boolean[N+1];
		
		for(int i=2; i<=N; i++) {
			isPrime[i] = true;
		}
		
		for(int i=2; i*i<=N; i++) {
			if(isPrime[i]) {
				for(int j=i*i; j<=N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
		
	}
}
