package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_±è¿ëºó {
	static int N, M;
	static int[] tall;
	static ArrayList<Node> adjList;
	
	static class Node {
		int to;
		ArrayList<Integer> toWhere = new ArrayList<>();
		
		public Node(int to) {
			super();
			this.to = to;
		}
		
		@Override
		public String toString() {
			return "Node [to=" + to + ", toWhere=" + toWhere + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tall = new int[N+1];
		adjList = new ArrayList<Node>();
		
		for(int i=0; i<=N; i++) {
			adjList.add(new Node(N));
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList.get(from).toWhere.add(to);
			tall[to]++;
			
		}
		
		Queue<Integer> que = new ArrayDeque<Integer>();
		for(int i=1; i<=N; i++) {
			if(tall[i] == 0) {
				que.add(i);
			}
		}
		BFS(que);
		System.out.println();

	}
	
	static void BFS(Queue<Integer> q) {
		
		while(!q.isEmpty()) {
			int next = q.poll();
			System.out.println(next);
			Node lst = adjList.get(next);
			for(int a: lst.toWhere) {
				tall[a]--;
				if(tall[a] == 0)
					q.add(a);
				
			}
		}
	}
	
}


