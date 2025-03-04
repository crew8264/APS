package Acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2529_김용빈 {
	static int K;
	static int[] numbers;
	static boolean[] isVisited;
	static String[] str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());

		str = new String[K];
		numbers = new int[K + 1];
		isVisited = new boolean[10];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			str[i] = st.nextToken();
		}

//		입출력 --------------
		
		perm(0);
		
		for(int n : last) { // 첫 결과 배열 출력
			System.out.print(n);
		}System.out.println();
		for(int n : first) { // 마지막 결과 배열 출력
			System.out.print(n);
		}System.out.println();
	}

	static boolean flag = false; // 첫 결과일 때만 true
	static int[] first = new int[K+1]; // 첫 결과일 때만 저장
	static int[] last = new int[K+1]; // 마지막 결과일 때만 저장
	static void perm(int cnt) {
		if (cnt == K + 1) { // 배열이 다 찼는데,
			for (int i = 0; i < K; i++) { // 모든 조건이 일치한다면
				if (str[i].equals("<")) {
					if (!(numbers[i] < numbers[i + 1]))
						return;
				} else {
					if (!(numbers[i] > numbers[i + 1]))
						return;
				}
			}
			if(!flag) {
				first = Arrays.copyOf(numbers, K+1); // 첫 배열일 때만 copy
				flag = true;
			}

			last = Arrays.copyOf(numbers, K+1); // 모든 케이스을 copy하면, 결과는 마지막 배열. 
			return;
		}

		for (int i = 0; i < 10; i++) { // 동작하는 부분
			if (!isVisited[i]) {
				isVisited[i] = true;
				numbers[cnt] = i;
				perm(cnt + 1);
				isVisited[i] = false;
			}
		}
	}
}
