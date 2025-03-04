package Acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p5_3015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		//Stack<Integer> st = new Stack<>();
		
		for(int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				//System.out.println();
				for(int k=i; k<j; k++) {
					//System.out.printf("i: %d, j: %d\n", i, j);
					if((arr[k]>arr[i])|(arr[k]>arr[j])) {
						break;
					}
					if(arr[k] == arr[j-1]){
						//System.out.printf("%d��° i: %d, %d��° j: %d\n", i, arr[i], j, arr[j]);
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
