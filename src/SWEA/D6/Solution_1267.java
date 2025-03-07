package SWEA.D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1267 {
	static int V, E;
	static int[] tail;
	static ArrayList<Node> adjList;
//	static 
	
	static class Node {
		int vertex;
		ArrayList<Integer> toGo = new ArrayList<Integer>();
		
		public Node(int vertex) {
			super();
			this.vertex = vertex;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점
			E = Integer.parseInt(st.nextToken()); // 간선 갯수
			
			adjList = new ArrayList<Node>();
			for(int i=0; i<=V; i++) {
				adjList.add(new Node(i));
			}
			
			tail = new int[V+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList.get(from).toGo.add(to);
				tail[to]++;
			}
			
			Queue<Integer> que = new ArrayDeque<Integer>();
			for(int i=1; i<=V; i++) {
				if(tail[i] == 0)
					que.add(i);
			}
			
			BFS(que);
			System.out.println();
		}
	}
	
	static void BFS(Queue<Integer> queue) {
		
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			System.out.print(next+" ");
			Node nd = adjList.get(next);
			for(int a : nd.toGo) {
				tail[a]--;
				if(tail[a] == 0) {
					queue.add(a);
				}
			}
		}
	}
	
}
