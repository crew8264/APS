package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7576 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int M, N;
	static int[][] box;
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		
		ArrayDeque<Node> que = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if(cur == 1) {
					que.add(new Node(i, j));
				}
				box[i][j] = cur;
				
			}
		}
		
//		System.out.println(que.peek().x +" : "+que.peek().y);
		
		int result = BFS(que);
		if(isEnd()) {
			System.out.println(result);			
		} else {
			System.out.println("-1");
		}
	}
	
	static boolean isEnd() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	
	static int BFS(ArrayDeque<Node> que) {
		int cnt = -1;
		while(!que.isEmpty()) {
			int qs = que.size();
			
			for(int q=0; q<qs; q++) {
				Node cur = que.poll();
				
				for(int i=0; i<4; i++) {
					int mx = cur.x + dx[i];
					int my = cur.y + dy[i];
					
					if(mx < N && mx >= 0 && my < M && my >= 0
							&& (box[mx][my] == 0)) {
						box[mx][my] = 1;
						que.add(new Node(mx, my));
					}
				}
			} 
			cnt++;
			/*
			System.out.println("cnt"+cnt+" : "+"que.size"+que.size());
			for(int i=0; i<N; i++) {
				System.out.println(Arrays.toString(box[i]));
			}*/
				
		}
		return cnt;
	}
}
