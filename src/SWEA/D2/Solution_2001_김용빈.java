package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2001_김용빈 {
	static int M, N; // 배열, 필터
	static int[][] pari; // 지도

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 배열 크기
			M = Integer.parseInt(st.nextToken()); // 필터 크기

			pari = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					pari[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			여기까지 입출력 ---------------
			
			
			// 배열은 아래에서 직접 돌려줌
			int max = -1;
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					int temp = checker(i, j);
					if(temp > max)
						max = temp;
				}
			}
			//결괏값 출력
			System.out.printf("#%d %d\n",t ,max);
		}
	}

	// 필터로 check하는 함수
	static int checker(int idxX, int idxY) {
		if (((idxX < 0) || (idxX+M > N)) || (idxY < 0) || (idxY+M > N)) {
			return -1;
		}
		int sum = 0;
		for (int i = idxX; i < idxX + (M); i++) {
			for (int j = idxY; j < idxY + (M); j++) {
				sum += pari[i][j];
			}
		}
		return sum;
	}

}
