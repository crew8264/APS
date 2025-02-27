package Acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_15649_김용빈 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		perm(0, 0);

	}

	static void perm(int cnt, int start) {
		if(cnt == M) {
			System.out.println(Arrays.toString(arr));
		}
		for(int i=start; i<M; i++) {
			arr[i] = i+1;
//			perm(cnt+1);
		}
	}
}
