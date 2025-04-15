package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {
	static int[] dx = {-1, 1, -1, 1};
	static int[] dy = {-1, -1, 1, 1};
	
	static int N, L, R;
	static int[][] popu;
	static boolean visited[][];
	
	static ArrayDeque<Integer> que = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		popu = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				popu[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		
	}
	
	static void openDoor(int x, int y) {
//				if(Math.abs(popu[x][y] - popu[mx][my]) >= L &&
//						Math.abs(popu[x][y] - popu[mx][my]) <= R) {
					
//				}

		
	}
}
