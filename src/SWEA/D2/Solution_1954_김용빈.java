package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1954_김용빈 {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			int idxX = 0, idxY = 0, num = 1;
			boolean dirR = true;
			boolean dirD = true;
			
			for(int i=0; i<N; i++) {
				arr[idxX][idxY] = num;
				dirR = false;
				idxY++; num++;
			} idxY--; num--;
			
			for(int i=N; i>0; i--) {
				if(dirD) {
					for(int j=0; j<i; j++) {
//						System.out.printf("X: %d / Y: %d\n",idxX, idxY);
//						System.out.println("down");
						arr[idxX][idxY] = num;
						dirD = false;
						idxX++; num++;
					} idxX--;
				} else {
					for(int j=0; j<i; j++) {
						arr[idxX][idxY] = num;
						dirD = true;
						idxX--; num++;
					}idxX++;
				} num--;
				
				if(dirR) {
					for(int j=0; j<i; j++) {
						arr[idxX][idxY] = num;
						dirR = false;
						idxY++; num++;
					} idxY--;
				} else {
					for(int j=0; j<i; j++) {
						arr[idxX][idxY] = num;
						dirR = true;
						idxY--; num++;
					} idxY++;
				} num--;
				
			}
			System.out.printf("#%d\n", t);
			for(int u=0; u<N; u++) {
				for(int p=0; p<N; p++) {
					System.out.print(arr[u][p]+" ");
				}System.out.println();
			}
		}
	}
}
