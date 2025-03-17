package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5567 {
	
	static class Node {
		int from;
		ArrayList<Integer> to = new ArrayList<>();
		
		Node(int from) {
			this.from = from;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[ from: "+from+" to: "+to+" ]";
		}
	}
	
	static int a, b;
	static int[] rank;
	public static void main(String[] args) throws IOException {
		//--------------솔루션 코드를 작성하세요.--------------------------------
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		
		rank = new int[a+1];
		isVisited = new boolean[a+1];
		ArrayList<Node> friends = new ArrayList<>();
		for(int i=1; i<=a; i++) {
			friends.add(new Node(i));
		}
			
		for(int i=0; i<b; i++) {
			String[] temp = br.readLine().split(" ");
			int from = Integer.parseInt(temp[0]);
			int to = Integer.parseInt(temp[1]);
			
			friends.get(from-1).to.add(to);
			friends.get(to-1).to.add(from);
		}
		
		rank[1] = 0; // 김싸피는 0번
		ArrayDeque<Node> que = new ArrayDeque<>();
		que.add(friends.get(1-1));
		
		getFr(friends, que);
		
//		for(int i=0; i<a; i++) {
//			System.out.println(friends.get(i));
//		}
//		System.out.println(Arrays.toString(rank));
		
		int cnt = 0;
		for(int i=1; i<=a; i++) { // 0인 본인 제외, 1 : 그냥 친구, 2 친구의 친구
			if(rank[i] == 1 || rank[i] == 2) cnt++;
		}
		
		System.out.println(cnt);
		
	}

	static boolean[] isVisited;
	static void getFr(ArrayList<Node> friends, ArrayDeque<Node> que) {
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			isVisited[now.from] = true;
			for(int next : now.to) {
				if(isVisited[next]) continue;
//				System.out.printf("from:%d now:%d\n", now.from, next);
				que.add(friends.get(next-1));
				rank[next] = rank[now.from]+1;
				isVisited[next] = true;
			}
			
			
		}
		
	}
}






