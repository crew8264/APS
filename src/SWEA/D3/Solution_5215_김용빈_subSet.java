package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_김용빈_subSet {
	static int N, L, SCORE = -1;
	static int[][] ham;
	static boolean[] visited;

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
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					ham[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			여기까지 입출력 -------------

//			ham_diet(0, 0, 0);
			ham_diet_sub(0, 0, 0);

			System.out.printf("#%d %d\n", t, SCORE);
		}
	}
	static void ham_diet_sub(int cnt, int calSum, int sum) {
		if(calSum > L) return;
		if(cnt == N) {
			if(SCORE < sum)
				SCORE = sum;
			return;
		}
		
		visited[cnt] = true;
		ham_diet_sub(cnt+1, calSum+ham[cnt][1], sum+ham[cnt][0]);
		visited[cnt] = false;
		ham_diet_sub(cnt+1, calSum, sum);
	}
	
	
	
}
