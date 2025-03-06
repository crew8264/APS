package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5215_김용빈 {
	static int N, L, SCORE = -1;
	static int[][] ham;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 배열 크기
			L = Integer.parseInt(st.nextToken()); // 필터 크기

			SCORE = -1;
			ham = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					ham[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ham_diet(0, 0, 0);

			System.out.printf("#%d %d\n", t, SCORE);
		}
	}

	static void ham_diet(int cnt, int score, int cal) {
//		System.out.println("cal : "+cal);
		if (cal > L) return;
		if (cnt == N) {
			SCORE = Math.max(SCORE, score);
			return;
		}
		ham_diet(cnt + 1, score + ham[cnt][0], cal + ham[cnt][1]);
		ham_diet(cnt + 1, score, cal);
	}
}


