package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String[] ps = br.readLine().split("");
			
			boolean isClosed = false;
			Stack<String> sk = new Stack<String>();
			
			for(int j=0; j<ps.length; j++) {
				 if(ps[j].equals("(")) {
					 sk.push(ps[j]);
					 
					 
				 } else if(ps[j].equals(")")) {
					 if(sk.isEmpty()) {
						 isClosed = true;
						 break;
					 }
					 if(sk.peek().equals("(")) {
						 sk.pop();
					 } else if(sk.peek().equals(")")) {
						 isClosed = true;
						 break;
					 }
				 }
			}
			if(!sk.isEmpty()) isClosed = true;
			
			if(isClosed) System.out.println("NO");
			else	System.out.println("YES");
		}
	}
}
