package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1238_김용빈 {
	static int N = 101;
	static boolean[] visited;
	static ArrayList<Node> nodeList;

	static class Node {
		int from;
		ArrayList<Integer> to = new ArrayList<>();

		public Node() {
		}

		public Node(int from) {
			this.from = from;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int tc = 1; tc<=10; tc++) {

			nodeList = new ArrayList<Node>();
			for (int i = 0; i < N; i++) {
				nodeList.add(new Node(i));
			}

			maxx = -1;
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			int inputNums = Integer.parseInt(st.nextToken());
			int startNum = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine()); // 입출력 받기
			for (int i = 0; i < inputNums / 2; i++) {
				int inputFrom = Integer.parseInt(st.nextToken());
				int inputTo = Integer.parseInt(st.nextToken());
	
				ArrayList<Integer> temp = nodeList.get(inputFrom).to;
				if (!temp.contains(inputTo)) { // 중복되지 않았을 때만
					temp.add(inputTo);
				}
			}
			
			ArrayDeque<Node> queue = new ArrayDeque<>();
			queue.add(nodeList.get(startNum));
			visited[startNum] = true;
			BFS(queue);
			
			
			System.out.println("#"+tc+" "+maxx);
		}
	}

	static int maxx = -2;
	static ArrayDeque<Integer> current;
	static void BFS(ArrayDeque<Node> que) {
		int depth = 0;
		while (!que.isEmpty()) {
			current = new ArrayDeque<Integer>();
			int size = que.size();
			
			for(int i=0; i < size; i++) {
				Node now = que.poll();
				
				
				for (int a : now.to) {
					if (!visited[a]) {
						visited[a] = true;
						que.add(nodeList.get(a));
						current.add(a);
					}
				}
			}
			if(!current.isEmpty()) {
//				System.out.println(current);
				maxx = -1; 
				while(!current.isEmpty()) {
					maxx = Math.max(maxx, current.poll());
				}
				depth++;
//				System.out.println(depth+" "+max);
			}
		}
		
//		for(int i=1; i<101; i++) {
//			System.out.print(visited[i]+" ");
//			if(i % 10 == 0)
//				System.out.println();
//		}
	}
}
