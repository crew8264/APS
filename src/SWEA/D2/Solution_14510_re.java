package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_14510_re {
	static int N, gap;
	static int[] treeList, div;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // TC의 수
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine()); // 나무의 개수
			
			treeList = new int[N];
			div = new int[3];
			
			st = new StringTokenizer(br.readLine()); // 나무 한줄로 받기
			
			int max = -1;
			for(int i=0; i<N; i++) {
				treeList[i] = Integer.parseInt(st.nextToken());
				max = Math.max(treeList[i], max);
			}
			
			for(int i=0; i<N; i++) {
				treeList[i] = max - treeList[i];
				process(treeList[i]);
			}

//			System.out.println(Arrays.toString(treeList));
			
			int result = 0;
			if(div[2] > div[1]) {
				while(div[2] > div[1]) {
					div[1] += 2;
					div[2]--;
				}
				result = div[2]+div[1];
				
			} else if(div[2] < div[1]) {
				result = div[1]*2-1;
			} else {
				result = div[2]*2;
			}
			
//			System.out.println("div2: "+div[2] + " div1: "+div[1]);
			
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static void process(int input) {
		div[2] += input / 2;
		div[1] += input % 2;
	}
}
