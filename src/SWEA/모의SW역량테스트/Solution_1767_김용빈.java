package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1767_김용빈 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N;
	static int[][] exynos;
	static ArrayList<Integer[]> core;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// testCase 수만큼
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 변수 초기화
			N = Integer.parseInt(br.readLine());
			exynos = new int[N][N];
			core = new ArrayList<>();
			maxCon=Integer.MIN_VALUE;
			minWire=Integer.MAX_VALUE;

			// 데이터를 입력 받고 코어만 배열로 저장
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					exynos[i][j] = Integer.parseInt(st.nextToken());
					if (exynos[i][j] == 1 && i > 0 && i < N - 1 && j > 0 && j < N - 1) { // 가장자리 제외
						core.add(new Integer[] { i, j });
					}
				}
			}

			// 탐색 시작
			DFS(0, 0, 0);
			System.out.println("#"+tc+" "+minWire);

		}
	}
	
	static int maxCon, minWire;
	static void DFS(int cnt, int connected, int wireLength) {
		// 모든 코어를 탐색했다면 종료
		if (cnt == core.size()) {
			if(connected > maxCon) {
				maxCon = connected;
				minWire = wireLength;
				
			} else if(connected == maxCon) {
				if(wireLength < minWire) {
					minWire = wireLength;
				}
			}
			return;
		}

		Integer[] arr = core.get(cnt);
		int tx = arr[0];
		int ty = arr[1];

		// 이 코어를 선택했을 때 탐색
		for (int i = 0; i < 4; i++) {
			int len = wireConn(tx ,ty, i);
			if(len==-1) continue;
			DFS(cnt+1, connected+1, wireLength+len);
			wireDisconn(tx, ty, i);
		}
		// 이 코어를 선택 안했을 때 탐색
		DFS(cnt+1, connected, wireLength);
	}
	
	// 전선을 연결해주는 함수
	static int wireConn(int x, int y, int idx) {
		int len = 0;
		
		// 전선 연결 되는지 봄
		int nx = x+ dx[idx];
		int ny = y+ dy[idx];
		
		while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			if(exynos[nx][ny] != 0) return -1;
            nx += dx[idx];
            ny += dy[idx];
        }
		
		// 전선 연결 안되는지 봄
		nx = x+ dx[idx];
		ny = y+ dy[idx];
		
		while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			exynos[nx][ny] = 2;
			len++;
			nx += dx[idx];
			ny += dy[idx];
		}
		
        return len;
	}
	
	// 연결했던거 원상복귀
	static void wireDisconn(int x, int y, int idx) {
		int nx = x + dx[idx];
		int ny = y + dy[idx];
				
		while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            exynos[nx][ny] = 0;
            nx += dx[idx];
            ny += dy[idx];
        }
	}
}
