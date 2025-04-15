package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_2458 {
	static class Node {
		int cur;
		ArrayList<Integer> to = new ArrayList<>();
		
		public Node(int cur) {
			this.cur = cur;
		}
	}
	
	static int N, M, result = 0;
	static int[] west;
	static ArrayList<Node> sNodeList = new ArrayList<>();	
	static ArrayList<Node> mNodeList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 처리
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		// 초기화
		for(int i=1; i<=N; i++) {
			sNodeList.add(new Node(i));
			mNodeList.add(new Node(i));
		}
		
		
		// 입력 처리
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0])-1;
			int to = Integer.parseInt(input[1])-1;
			
			sNodeList.get(from).to.add(to);
			mNodeList.get(to).to.add(from);
		}
		
		for(int i=0; i<N; i++) {
			int sc1 = find(i, sNodeList);
			int sc2 = find(i, mNodeList);
			if(sc1+sc2 == N-1) result++;
		}
		
		
		System.out.println(result);
	}
	
	static int find(int start, ArrayList<Node> list) {
		ArrayDeque<Node> que = new ArrayDeque<>();
		int depth = 0;
		boolean[] visited = new boolean[N+1];
		
		que.add(list.get(start));
		visited[start] = true;
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			for(int a : cur.to) {
				if(!visited[a]) {
					visited[a] = true;
					que.add(list.get(a));
					depth++;
				}
			}
		}
		return depth;
	}
	
}
