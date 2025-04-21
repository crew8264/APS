package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10026 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N, resultOrigin = 0, resultBlind = 0; // 배열 크기, 일반인 눈 구역, 색약 눈 구역
	static String[][] maps; // 그림
	static boolean[][] selected; // 한 구역을 true 처리한 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		maps = new String[N][N];
		selected = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split("");
			for(int j=0; j<N; j++) {
				maps[i][j] = input[j];
			}
		}
		
//		초기화 및 배열 입력 ---------------
		
		// 색약일 때 처리
		for(int i=0; i<N; i++) { // 각 위치를 돌면서, 
			for(int j=0; j<N; j++) {
				if(selected[i][j]) continue; // 이미 방문했다면, continue
				if(maps[i][j].equals("R") || maps[i][j].equals("G")) { // 적 또는 녹일 때
					DFSRG(0, i, j);
					resultBlind++;
				} else { // 청일 때 - true 처리와 개수는 세줘야 해
					DFS(0, i, j, maps[i][j]);
					resultBlind++;
				}
			}
		}
		
		// 정상일 때 처리
		selected = new boolean[N][N]; // 방문배열 초기화 한 번 해줘야지
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(selected[i][j]) continue;
				DFS(0, i, j, maps[i][j]); // 모든 색깔에 대해 방문처리
				resultOrigin++;
			}
		}
		
		
		System.out.println(resultOrigin + " " + resultBlind); // 출력
	}
	
	// 정상일 때, 방문처리 해주는 메서드
	static void DFS(int cnt, int x, int y, String color) {
		if(!maps[x][y].equals(color)) {
			return;
		}
		
		for(int i=0; i<4; i++) {
			int mx = x+dx[i];
			int my = y+dy[i];
			
			if(mx >= 0 && mx < N && my >= 0 && my < N
					&& !selected[mx][my] && maps[mx][my].equals(color)) {
				selected[mx][my] = true;
				DFS(cnt+1, mx, my, color);
			}
		}
	}
	
	// 색약일 때, 방문처리 해주는 메서드
	static void DFSRG(int cnt, int x, int y) {
		if(!(maps[x][y].equals("R") || maps[x][y].equals("G"))) {
			return;
		}
		
		for(int i=0; i<4; i++) {
			int mx = x+dx[i];
			int my = y+dy[i];
			
			if(mx >= 0 && mx < N && my >= 0 && my < N
					&& !selected[mx][my] && (maps[mx][my].equals("R") || maps[mx][my].equals("G"))) {
				selected[mx][my] = true;
				DFSRG(cnt+1, mx, my);
			}
		}
	}
}
