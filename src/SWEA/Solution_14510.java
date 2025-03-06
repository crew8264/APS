package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_14510 {
	static int T, N, div3, div2, div1, ans;
	static int[] tree, gap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			tree = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}
			
//			input-----
			
			// step1 : 최댓값 찾기
			ans = 0; div1=0; div2=0; div3=0;
			int max = -1;
			for(int i=0; i<N; i++) {
				if(max < tree[i]) {
					max = tree[i];
				}
			}
			
			gap = new int[N];
			// step2 : gap 배열 생성
			for(int i=0; i<N; i++) {
				gap[i] = max - tree[i];
			}
			
			System.out.println(Arrays.toString(gap));
			System.out.printf("div3: %d div2: %d div1: %d\n", div3, div2, div1);
			
			
			// step3 : /3 해본다
			for(int i=0; i<N; i++) {

				div3 += gap[i] / 3;
				gap[i] %= 3;
				
				div2 += gap[i] / 2;
				gap[i] %= 2;

				div1 += gap[i] / 1;
				gap[i] %= 1;
				
			}
			System.out.println(Arrays.toString(gap));
			
			// step4 : 1씩 남은건 따로
			while(div2!=0 && div1!=0) {
				div3++; div2--; div1--;
			}

			
//			if(div1 == 0 && div2 == 0)
//			if(div1 == 1 && div2 == 1)
			if(div1 != 0 && div2 == 0) {
				ans+=1; div1--;
			}
			else if(div1 == 0 && div2 != 0) {
				ans+=2; div2--;
			}

			
			ans += div3 * 2;
			
			System.out.printf("div3: %d div2: %d div1: %d\n", div3, div2, div1);
			System.out.println(Arrays.toString(gap));
			System.out.println("#"+tc+" "+ans);
		}
		
	}
}
