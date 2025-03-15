package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1654 {
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 실수로 N과 K가 바뀜
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		bSear(0, 0, lngh);
		System.out.println(lngh);
		
	}
	
	static long lngh = (long) Math.pow(2, 32);
	static void bSear(long cnt, long st, long ed) {
		long md = (st+ed) / 2;
//		System.out.println(md+" : "+cut(md)+" cut: "+cut(md));

		if(cnt == 32) {
			lngh = md;
			return;
		}
		
		
		if(cut(md) < K) {
			lngh = md;
			bSear(cnt+1, st, md);
		} else {
			lngh = md;
			bSear(cnt+1, md, ed);
		}
	}
	
	static long cut(long lngh) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			cnt += arr[i] / lngh;
		}
		return cnt;
	}
}
