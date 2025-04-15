package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Ns_Main_2206 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N, M;
	static int[][] maps;
	static int[][] cost;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		maps = new int[N][M];
		cost = new int[N][M];		
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split("");
			for(int j=0; j<M; j++) {
				maps[i][j] = Integer.parseInt(input[j]);
			}
			System.out.println(Arrays.toString(maps[i]));
		}
		
//		입출력 ------------------
		
		queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0});
		
		BFS(queue);
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(maps[i]));
		}
	}
	
	static ArrayDeque<int[]> queue;
	static void BFS(ArrayDeque<int[]> que) {
		int cnt = 0;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			maps[cur[0]][cur[1]] = cnt;
			cnt++; //  (0,0) 부터의 거리
			int N = que.size();
			System.out.println(cnt);
			for(int n=0; n<=N; n++) {
				for(int i=0; i<4; i++) {
					int mx = cur[0] + dx[i]; // delta를 사용한 x좌표
					int my = cur[1] + dy[i]; // delta를 사용한 y좌표
					
					if(mx >= 0 && mx < N && my >= 0 && my < M
							&& maps[mx][my] == 0) {
						que.add(new int[] {mx, my});
						maps[mx][my] = cnt;
					}
				}
			}
		}
		
		
	}
}
