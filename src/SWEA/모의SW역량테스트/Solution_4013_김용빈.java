package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_4013_김용빈 {
	static int 결과 = 0; // 각 톱니마다 S극일 때 : 1, 2, 4, 8점
	static ArrayList<LinkedList<Integer>> 자석; // 톱니바퀴 4개, 8개의 날
	static int[][] 회전; // K개의 입력 : 바퀴 번호, 회전 방향

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());

			자석 = new ArrayList<LinkedList<Integer>>();
			회전 = new int[K][2];

			// 입력
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				LinkedList<Integer> input = new LinkedList();
				for (int j = 0; j < 8; j++) {
					input.add(Integer.parseInt(st.nextToken()));
				}
				자석.add(input);
			}
//			System.out.println(자석);

			// 회전방향 톱니 입력
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				회전[i][0] = Integer.parseInt(st.nextToken())-1;
				회전[i][1] = Integer.parseInt(st.nextToken()); // 1 : 시계, -1 : 반시계
			}

//			여기까지 입력
			for (int i = 0; i < K; i++) {
				process(회전[i][0], 회전[i][1]);
			}

			결과 = score();
			System.out.println("#" + tc + " " + 결과);
		}
	}

	static void process(int turnIdx, int turnDir) {
		int[] direction = new int[4];
		direction[turnIdx] = turnDir;
//		System.out.println("여기가 문제냐");
		
		// 왼쪽 체크
		int idxL = turnIdx-1;
		while(idxL>=0) {
			if(자석.get(idxL).get(2) != 자석.get(idxL+1).get(6)) {
				direction[idxL] = -direction[idxL+1];
			} else break;
			
			idxL--;
		}
		
		// 오른쪽 체크
		int idxR = turnIdx+1;
		while(idxR<=3) {
			if(자석.get(idxR-1).get(2) != 자석.get(idxR).get(6)) {
				direction[idxR] = -direction[idxR-1];
			} else break;
			
			idxR++;
		}
		
		for(int i=0; i<4; i++) {
			if(direction[i] != 0)
				turn(i, direction[i]);
		}
	}

	static void turn(int turnIdx, int turnDir) {
		if (turnDir == 1) {
			int temp = 자석.get(turnIdx).removeLast();
			자석.get(turnIdx).addFirst(temp);
		} else if (turnDir == -1) {
			int temp = 자석.get(turnIdx).removeFirst();
			자석.get(turnIdx).addLast(temp);
		}
	}

	static int score() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if(자석.get(i).get(0) == 1)
				sum += 1<<i;
		}
		return sum;
	}
}
