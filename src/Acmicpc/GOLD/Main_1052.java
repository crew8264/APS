package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1052 {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpt = br.readLine().split(" ");
		
		N = Integer.parseInt(inpt[0]);
		K = Integer.parseInt(inpt[1]);
		
		System.out.println(getMul(N, K));
		
	}
	
	static int getMul(int n, int k) {
		int sum = 0;
		while(Integer.bitCount(n) > k) {
			n++;
			sum++;
		}
		return sum;
	}

}
