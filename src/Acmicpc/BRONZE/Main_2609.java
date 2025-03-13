package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609 {
	static int MAX, MIN;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		MAX = Integer.parseInt(st.nextToken());
		MIN = Integer.parseInt(st.nextToken());
		
		System.out.println(max(MAX, MIN));
		System.out.println(min(MAX, MIN));

	}
	static int max(int a, int b) {
		if(b == 0) return a;
		return max(b, a % b);
	}
	
	static int min(int a, int b) {
		return (a * b) / max(a, b);
	}
}
