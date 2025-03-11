package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14889 {
	static int N, minGap = Integer.MAX_VALUE;
	static int[] temp1, temp2;
	static int[][] stat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		temp1 = new int[N/2];
		temp2 = new int[N/2];
		stat = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
			stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Comb(0, 0);
		System.out.println(minGap);
	}

	static void Comb(int cnt, int start) {
		if(cnt == N / 2) {
			getRev(temp1);
//			System.out.println(Arrays.toString(temp1));
//			System.out.println(Arrays.toString(temp2));
			
			int gap = calGap(temp1, temp2);
			if(gap < minGap) {
				minGap = gap;
			
			}
			return;
		}
		
		for(int i=start+1; i<=N; i++) {
			temp1[cnt] = i;
			Comb(cnt+1, i);
//			System.out.println();
		}
	}
	
	static void getRev(int[] arr) {
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			boolean hasArr = false;
			for(int a : temp1) {
				if(i == a) {
					hasArr = true;
					break;
				}
			}
			
			if(!hasArr)
				temp2[cnt++] = i;
				
		}
	}
	
	static int calGap(int[] arr1, int[] arr2) {
		int sum1 = 0, sum2 = 0, gap=0; // arr�� ������ sum1, ������ sum2
		for(int a : arr1) {
			for(int b : arr1) {
				if(a==b) continue;
//				System.out.println("a: " +(a-1) + " b: " +(b-1)+" stat: "+stat[a-1][b-1]);
				sum1 += stat[a-1][b-1];
			}
		}
		for(int a : arr2) {
			for(int b : arr2) {
				if(a==b) continue;
				sum2 += stat[a-1][b-1];
			}
		}
		gap = sum2 - sum1;
//		System.out.println("sum1: "+sum1+" sum2: "+sum2+" gap: "+gap);
		return Math.abs(gap);
	}
}
