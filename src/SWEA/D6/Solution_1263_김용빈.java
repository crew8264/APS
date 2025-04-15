package SWEA.D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1263_김용빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int[][] dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
					if (dist[i][j] == 0) {
						dist[i][j] = 123456789;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}

			int min = Integer.MAX_VALUE;
			int[] temp = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					temp[i] += dist[i][j];
				}
				min = Math.min(temp[i], min);
			}
			System.out.println("#" + tc + " " + min);
		}

	}
}
