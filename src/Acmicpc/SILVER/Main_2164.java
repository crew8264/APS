package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> que = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			que.add(i);
		}
		
		while(que.size() > 1) {
			que.poll();
			int temp = que.poll();
			que.add(temp);
		}
		
		System.out.println(que.peek());
	}
}
