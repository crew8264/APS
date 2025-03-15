package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_11866 {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = "";
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Stack<Integer> sk = new Stack<Integer>();
		int idx = 0;
		
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=1; i<=N; i++)
			array.add(i);
		
		int temp = N;
		for(int i=0; i<N; i++) {
			for(int j=0; j<K; j++) { // 인덱스 관리
				if(idx >= temp) idx = 0;
				idx++;
			}
			
			sk.push(array.get(idx-1));
			array.remove(idx-1);
			idx--; temp--;
			
		}
		
		for(int i=0; i<N; i++) {
			if(i==0) {
				str = sk.pop() + str;
			} else {
				str = sk.pop() +", " + str;
			}
		}
		str = "<" + str;
		str = str + ">";
		
		System.out.println(str);
	}
}
