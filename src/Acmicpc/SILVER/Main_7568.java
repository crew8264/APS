package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568 {
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N= Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		for(int i=0;i<N;i++) { // 입출력
			st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			int cnt=0;
			for(int j=0;j<N;j++) {
				if(j == i) continue; // 본인과는 비교 안함
				if(	arr[i][0]<arr[j][0] && 
					arr[i][1]<arr[j][1]) {
					cnt++;
				}
			}
			sb.append(cnt+1).append(" ");
		}
		System.out.println(sb);
	}
}
