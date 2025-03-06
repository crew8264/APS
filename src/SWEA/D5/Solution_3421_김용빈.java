package SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3421_김용빈 {
	static int T, N, M, howManyBurger;
	static boolean[] isSelected;
	static int[][] never;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			howManyBurger = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			isSelected = new boolean[N];
			never = new int[M][2];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				never[i][0] = Integer.parseInt(st.nextToken());
				never[i][1] = Integer.parseInt(st.nextToken());
			}
			
//			여기까지 입출력 ----------
			
			hamu(0);
			System.out.printf("#%d %d\n", tc, howManyBurger);
			
		}
	}
	
	// 조합을 구상하는 재귀함수
	static void hamu(int cnt) {
		for(int i=0; i<M; i++) { // 별로인 재료 조합 두 개가 모두 선택되었다면,
				if(isSelected[never[i][0]-1])
					if(isSelected[never[i][1]-1])
						return; // 보내버려
		}
		
		if(cnt == N) { // 결정을 다 했어?
			howManyBurger++; // 문제 없으면 ++
			return;
		}
		
		
		isSelected[cnt] = true; // 선택하는 경우
		hamu(cnt+1);
		isSelected[cnt] = false; // 선택 안하는 경우
		hamu(cnt+1);
	}
}
