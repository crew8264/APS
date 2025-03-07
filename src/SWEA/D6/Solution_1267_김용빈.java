package SWEA.D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1267_김용빈 {
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	static int[] tail;
	public static class Node {
		int to;
		ArrayList<Integer> element;
		
		public Node(int to) {
			this.to = to;
			element = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", element=" + element.toString() + "]";
		}

	}
	
	static int V, E;
	static List<Node> adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList<>();
			tail = new int[V+1];
			for(int i=0; i<=V; i++) {
				adjList.add(new Node(i));
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				tail[to]++;
				adjList.get(from).element.add(to);
			}
			
			Queue<Integer> que = new ArrayDeque<>();
			for(int i=1; i<=V; i++) {
				if(tail[i] == 0)
					que.offer(i);
			}
			
	
			System.out.printf("#%d ", tc);
			BFS(que);
			System.out.println();
		}
	}
	
	static void BFS(Queue<Integer> qu) {
		
		
		while(!qu.isEmpty()) {
			int next = qu.poll();
			System.out.print(next + " ");
//			System.out.print(next+" " + adjList.get(next));
			List<Integer> temp = adjList.get(next).element;
			for(int nd : temp) {
				tail[nd]--;
				
				if(tail[nd] == 0) {
					qu.offer(nd);
				}
			}	
		}
		
	}
}

/*
4 4
1 2 1 3 2 4 3 4
*/