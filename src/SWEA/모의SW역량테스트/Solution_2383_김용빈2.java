package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Solution_2383_김용빈2 {
	static int result;
	static int[] floordp;
	static int[][] maps;
	static ArrayList<int[]> people;
	static ArrayList<int[]> floor;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int idx = 0; result = Integer.MAX_VALUE;
			maps = new int[N][N];
			people = new ArrayList<>();
			floor = new ArrayList<>();
			floordp = new int[20];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
					if(maps[i][j] == 1) {
						people.add(new int[]{i,j});
					} else if(maps[i][j] > 1) {
						floor.add(new int[]{i,j});
						floordp[idx++] = maps[i][j];
					}			
				}
			}
			
//			여기까지 입출력 -----------------------------
			
			selected = new boolean[people.size()];
			subset(0);
			System.out.println("#"+tc+" "+result);
		}
	}
//	맨허튼 거리를 구해주는 함수 : 자주 쓸 줄 알았는데 안씀
	static int distance(int sx, int sy, int fx, int fy) { // 사람 x, y floor x, y
		return Math.abs(fx-sx) + Math.abs(fy-sy);
	}
	
//	부분집합 생성, 다음 작업으로 넘겨주는 함수
	static boolean[] selected;
	static void subset(int cnt) {
		if(cnt == people.size()) { // 다 뽑았으면,
			ArrayList<Integer> stair0 = new ArrayList<>(); // 1번계단 초기화
			ArrayList<Integer> stair1 = new ArrayList<>(); // 2번계단 초기화
			
			for (int a = 0; a < people.size(); a++) {
                int[] temp = people.get(a);
                int[] stair = floor.get(selected[a] ? 1 : 0); //도착 걸리는 시간 : 비용
                int time = distance(temp[0], temp[1], stair[0], stair[1]); // 거리 구해서
                if(selected[a]) stair1.add(time); // 각 배열에 추가
                else stair0.add(time);
            }
			
			int time = Math.max(processStair(stair0, floordp[0]), // 한번 돌려봐
                    processStair(stair1, floordp[1]));
			
			result = Math.min(result, time); // 지금까지 / 방금결과 중 작은거 리턴
			return;
			}
		
		selected[cnt] = false;
		subset(cnt+1);
		selected[cnt] = true;
		subset(cnt+1);
	}
	
//	계단 시뮬레이션
	static int processStair(ArrayList<Integer> a1, int s1) {
		Collections.sort(a1); // 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 이건 계단이야
		
		int time = 0; // 초기화 해
		for(int arrive : a1) { // stair0 에서 함 도착 순서대로 가져와봐
			while(pq.size() >= 3 && pq.peek() > arrive) {
				// 계단이 가득 찼거나, 앞사람이 아직 안나갔다면
				arrive = pq.poll();
			}
			
			// 다음꺼보다 지금꺼가 늦게 끝나면(누군가 대기하면)
			int start = arrive;
			pq.add(start + s1); // PQ에 넣음, 대기시간 더함
			time = Math.max(time, start + s1); // 지금 시간이랑 PQ 값이랑 긴거 리턴
		}
		return time;
	}
}
