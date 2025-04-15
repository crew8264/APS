package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2383_김용빈 {	
	public static class info {
		int x;
		int y;
		int weight;
		
		public info(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
	
	static int[][] maps;
	static ArrayList<info> man;
	static ArrayList<info> floor;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		int T = Integer.parseInt(br.readLine());
		int T = 1;
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			maps = new int[N][N];
			man = new ArrayList<>();
			floor = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
					
					if (maps[i][j] == 0) {
						continue;
					} else if(maps[i][j] == 1) {
						man.add(new info(i, j, 0));
					} else {
						floor.add(new info(i, j, maps[i][j]));
					}
				}
			}
			
//			여기까지 입출력 -----------------------
			
			selList = new ArrayList<>();
			Comb(0);
			change();
			
			minTime = Integer.MAX_VALUE;
			for(ArrayList<Integer> temp : selList) {
				minus(temp);
			}
			
			
			
		}
		
	}
	
	static int moveTime(int sx, int sy, int fx, int fy) { // 사람 x, y floor x, y
		return Math.abs(fx-sx) + Math.abs(fy-sy);
	}
	
	static ArrayList<ArrayList<Integer>> selList;
	static ArrayList<Integer> selected = new ArrayList<>();
	static void Comb(int cnt) {
		if(cnt == man.size()) {
			selList.add(new ArrayList<>(selected));
			System.out.println(selected);
			return;
		}
		for(int i=0; i<floor.size(); i++) {
			selected.add(i);
			Comb(cnt+1);
			selected.remove(cnt);
		}
	}
	
	static void change() {
		for(ArrayList<Integer> ar1 : selList) {
				for(int i=0; i<man.size(); i++) {
					info tempM = man.get(i);
					info tempF = floor.get(ar1.get(i));
					ar1.set(i, moveTime(tempM.x, tempM.y, tempF.x, tempF.y));
				}
//			System.out.println(ar1);
		}
	}
	
	static int minTime = Integer.MAX_VALUE;
	static void minus(ArrayList<Integer> temp) {
			for(int a : temp) {
				if(minTime < a)
					return;
			}
			while(!checkZero(temp)) {
				for(int i=0; i<man.size(); i++) {
					temp.set(i, temp.get(i)-1);
				}
			}
			
	}
	
	static boolean checkZero(ArrayList<Integer> temp) {
		for(int i=0; i<temp.size(); i++) {
			if(temp.get(i) == 0) {
				return true;
			}
		}
		return false;
	}
}
