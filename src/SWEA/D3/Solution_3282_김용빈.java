package SWEA.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_3282_김용빈 {
	static int result;
	static int[][] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 물건 개수
			int W = sc.nextInt(); // 가방 목표 무게

			int[] weights = new int[N + 1];
			int[] profits = new int[N + 1];
			D = new int[N + 1][W + 1];

			for (int i = 1; i <= N; i++) {
				weights[i] = sc.nextInt();
				profits[i] = sc.nextInt();
			}

			// 크게 두 경우가 있음 : 물건을 넣는다 / 물건을 넣지 않는다
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= W; j++) {
					if(weights[i] <= j) { // 물건이 가방 용량보다 작거나 같을 때,
						D[i][j] = Math.max(D[i-1][j], D[i-1][j-weights[i]] + profits[i]);
						// 어쩔 수 없이 계산
					} else { // 물건이 가방 용량보다 클 때,
						D[i][j] = D[i-1][j]; 
						// 그냥 앞에꺼 재사용
					}
				}
			}

//			System.out.println(Arrays.toString(weights));
//			System.out.println(Arrays.toString(profits));

			result = D[N][W];
			System.out.println("#" + tc + " " + result);
		}
	}

}
