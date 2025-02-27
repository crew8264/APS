package Acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15650_김용빈 {
	static int N, M;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		isVisited = new boolean[N];
		perm(0, 0);

	}

	static void perm(int cnt, int sel) {
//		System.out.println(Arrays.toString(isVisited));
		if (cnt == N) {
			if (sel == M) {
				for (int i = 0; i < N; i++) {
					if (isVisited[i])
						System.out.print(i+1+" ");
				}System.out.println();
			}
			return;
		}

		isVisited[cnt] = true;
		perm(cnt + 1, sel + 1);
		isVisited[cnt] = false;
		perm(cnt + 1, sel);
	}
}
