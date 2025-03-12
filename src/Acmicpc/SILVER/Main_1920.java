package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {
	static int N, M;
	static int[] base;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		base = new int[N];
		for(int i=0; i<N; i++) {
			base[i] = Integer.parseInt(st.nextToken()); 
		} Arrays.sort(base);
		
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			if(binarySC(Integer.parseInt(st.nextToken())) >= 0)
				sb.append(1).append('\n');
			else
				sb.append(0).append('\n');
		}
		
		
		System.out.println(sb);
	}
	
	
	static int binarySC(int key) {
		int lo = 0;
		int hi = base.length-1;
		
		while(lo <= hi) {
			int mid = (hi+lo) / 2;
			
			if(key < base[mid]) {
				hi = mid-1;
			} else if(key > base[mid]) {
				lo = mid+1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
