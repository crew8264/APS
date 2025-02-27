package Acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_김용빈_dfs {
	static int N;
	static String str = "";
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 N = Integer.parseInt(br.readLine());
		 
		 dfs(Integer.toString(2));
		 dfs(Integer.toString(3));
		 dfs(Integer.toString(5));
		 dfs(Integer.toString(7));
		 
	}
	
	static void dfs(String making) {
		if(N == 1) {
			if(checker(making)) System.out.println(making);
			return;
		}
		if(making.length() == N) {
			System.out.println(making);
			return;
		}
		
		for(int i=1; i<10; i++) {
			String mk = making + i;
			if(!checker(mk)) continue;
			else dfs(mk);
		}
		
	}
	
	static boolean checker(String st) { // 솟수면 true, 소수가 아니면 false
		int num = Integer.parseInt(st);
		
		if(num == 1) return false;
		if(num == 2) return true;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	} 
}
