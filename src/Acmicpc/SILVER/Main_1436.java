package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while(true) {
			cnt++;
			if(Integer.toString(cnt).contains("666"))
				N--;
			if(N==0)
				break;
		}
		
		System.out.println(cnt);
	}

}
