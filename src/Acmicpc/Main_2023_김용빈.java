package Acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_김용빈 {
	static int N;
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 N = Integer.parseInt(br.readLine());
		 
		 for(int i = (int) Math.pow(10, N-1); i<Math.pow(10, N); i++) {
			 if(!checker(i)) continue;
			 else System.out.println(i);
		 }
		 
	}

	static boolean checker(int num) {
		if(num == 0) {
			return true;
		} else if(num == 1) {
			return false;
		}
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		if(checker(num/10))
				return true;
		else
			return false;
	}
}
