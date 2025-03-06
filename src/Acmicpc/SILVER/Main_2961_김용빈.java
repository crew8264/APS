package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_김용빈 {
	static int N, MIN = Integer.MAX_VALUE; // 재료의 개수 N, 쓴-신 최솟값 MIN
	static int[][] gredient; // 입력받을 재료 - 쓴 : 단
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 재료의 개수
		
		gredient = new int[N][2]; // 재료 배열 초기회
		for(int i=0; i<N; i++) { // 재료 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				gredient[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		여기까지 입출력 ----------------
		cook(0, 0, 1, 0);
		System.out.println(MIN);
		
	}
	
	/**
	 * 조합을 만드는 재귀 함수 cook. 
	 * @param cnt : 재귀를 몇번 돌았는지
	 * @param pick : 재료를 몇번 골랐는지
	 * @param sour : 신 맛의 합
	 * @param bitter : 쓴 맛의 합
	 */
	static void cook(int cnt, int pick, int sour, int bitter) {
		if(cnt == N) { // 기저조건 : 모두 다 골랐을 때,
			if(pick == 0) return; // 공집합은 나가리
			int nowTaste = Math.abs(sour-bitter); // 쓴맛과 신맛 중 어떤게 더 큰지 모르니까
//			System.out.println("nowTaste : "+nowTaste);
			if(nowTaste < MIN) // 더 작으면 너 저장해
				MIN = nowTaste;
			return;
		}
		
		// 선택하는 경우 | 선택하지 않는 경우
		cook(cnt+1, pick+1, sour*gredient[cnt][0], bitter+gredient[cnt][1]);
		cook(cnt+1, pick, sour, bitter);
	}
}
