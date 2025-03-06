package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_김용빈 {
	static int N, M;
	static int[][] numbers; // 입력받은 배열
	static int[][] preSums; // 부분합 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N][N];
		preSums = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
				if(j == 0) {
					preSums[i][j] = numbers[i][j];
				} else {
					preSums[i][j] = preSums[i][j-1]+numbers[i][j];
				}
			}
		}
		
		for(int s=0; s<M; s++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) -1;
			int sy = Integer.parseInt(st.nextToken()) -1;
			int ex = Integer.parseInt(st.nextToken()) -1;
			int ey = Integer.parseInt(st.nextToken()) -1;
			
			int sum = 0;
			for(int i=sx; i<=ex; i++) {
				sum += preSums[i][ey]; // step1. 배열의 마지막 값을 더해
				if(sy != 0) {
					sum -= preSums[i][sy-1]; // step2. 앞쪽 값 뺴주기
				}
			}
			
			if((sx == ex)&&(sy == ey)) {
				sum = numbers[sx][sy];
			}
			
			System.out.println(sum);
			
		}
		
		
	}

}
