package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<N; tc++) {
			String[] st = br.readLine().split(" ");
			
			switch (st[0]) {
			case "push":
				que.offer(Integer.parseInt(st[1]));
				break;
			case "pop":
				if(que.isEmpty()) System.out.println(-1);
				else System.out.println(que.poll());
				break;
			case "size":
				System.out.println(que.size());
				break;
			case "empty":
				if(que.isEmpty()) System.out.println(1);
				else	System.out.println(0);
				break;
			case "front":
				if(que.isEmpty()) System.out.println(-1);
				else System.out.println(que.peek());
				break;
			case "back":
				if(que.isEmpty()) System.out.println(-1);
				else System.out.println(que.peekLast());
				break;
			}
			
		}
		
		
		
	}
}
