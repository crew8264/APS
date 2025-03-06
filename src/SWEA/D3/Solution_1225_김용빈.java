package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_김용빈 {
	static Queue<Integer> que;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=0; tc<10; tc++) {
			que = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
			
			int idx = 1;
			while(true) {
				if(idx == 6)
					idx = 1;
				if(que.peek()-idx<=0) {
					que.poll();
					que.add(0);
					break;
				}
				
				que.add(que.poll()-idx); idx++;
			}
			
			System.out.print("#" + (tc+1)+" ");
			for(int ik : que) {
				System.out.print(ik+" ");
			}System.out.println();
		}
	}
}