package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_김용빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int answer = -1;
			int len = Integer.parseInt(br.readLine());
			char[] temp = br.readLine().toCharArray();
			Stack<Character> sk = new Stack<>();
			for (char st : temp) {
				if ((st == ')') && (sk.peek() == '(')) {
					sk.pop();
				} else if ((st == ']') && (sk.peek() == '[')) {
					sk.pop();
				} else if ((st == '}') && (sk.peek() == '{')) {
					sk.pop();
				} else if ((st == '>') && (sk.peek() == '<')) {
					sk.pop();
				} else if ((((st == '(') || (st == '[')) || (st == '{')) || st == '<') {
					sk.push(st);
				} else {
					sk.push('c');
				}
			}
//			System.out.println(sk);
			if(!sk.isEmpty())
				answer = 0;
			else
				answer = 1;
			
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
