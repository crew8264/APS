package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_김용빈_NP {
	static int N, L, SCORE = -1;
	static int[][] ham;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 배열 크기
			L = Integer.parseInt(st.nextToken()); // 필터 크기

			SCORE = -1;
			ham = new int[N][2];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					ham[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			여기까지 입출력 -------------

//			ham_diet(0, 0, 0);
			ham_diet_sub(0, 0, 0);

			System.out.printf("#%d %d\n", t, SCORE);
		}
	}
	static void ham_diet_sub(int cnt, int calSum, int sum) {
		if(calSum > L) return;
		if(cnt == N) {
			if(SCORE < sum)
				SCORE = sum;
			return;
		}
		
		visited[cnt] = true;
		ham_diet_sub(cnt+1, calSum+ham[cnt][1], sum+ham[cnt][0]);
		visited[cnt] = false;
		ham_diet_sub(cnt+1, calSum, sum);
	}
	
//	static boolean np() { // 현 상태의 순열에서 사전식의 다음 순열 생성 후, 다음 순열 존재하면 true 아니면 false 반환
//
//		// step1 : 꼭대기(i) 찾기 = 교환위치(i-1) 찾기 위해
//		int i = N-1;
//		while(i>0 && input[i-1] >= input[i]) --i;
//		if(i==0) return false; // 절벽 : 더 이상 들여다 볼 요소가 없다(가장 큰 순열 형태다)
//		
//		// step2 : i-1 교환 자리의 값과 교환할 한 단계 큰 수를 뒤쪽부터 찾기
//		int j = N-1;
//		while(input[i-1] >= input[j]) --j;
//		
//		// step3 : i-1 자리와  j자리의 값 교환
//		swap(i-1, j);
//		
//		// step4 : i-1 자리의 한 단계 큰수로 변화했으니, i 꼭대기부터 맨 뒤까지 가장 작은 수를 만듦(오름차순 정렬)
//		int k = N-1;
//		while(i<k) swap(i++, k--);
//		
//		return true;
//	}
//	
//	static void swap(int i, int j) {
//		int temp = input[i];
//		input[i] = input[j];
//		input[j] = temp;
//	}
	
}
