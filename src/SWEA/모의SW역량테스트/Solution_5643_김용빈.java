package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_5643_김용빈 {
	static class Node { // 그래프 관리 할 Node 클래스 생성
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

		// T 횟수만큼 반복해요
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			result = 0;
			sNodeList = new ArrayList<>();
			mNodeList = new ArrayList<>();
			
			// NodeList 초기화
			for (int i = 1; i <= N; i++) {
				sNodeList.add(new Node(i));
				mNodeList.add(new Node(i));
			}

			// 그래프 입력
			for (int i = 0; i < M; i++) {
				String[] input = br.readLine().split(" ");
				int from = Integer.parseInt(input[0]) - 1;
				int to = Integer.parseInt(input[1]) - 1;

				sNodeList.get(from).to.add(to);
				mNodeList.get(to).to.add(from);
			}

			// BFS를 통해, 자기보다 크고 작은 노드 탐색
			for (int i = 0; i < N; i++) {
				int sc1 = find(i, sNodeList);
				int sc2 = find(i, mNodeList);
				if (sc1 + sc2 == N - 1) {
					result++;
				}
			}
			
			// 데이터 출력
			System.out.println("#"+tc+" "+result);
		}
	}

	// BFS로 몇개의 노드가 이어졌는지 판단하는 메서드
	static int find(int start, ArrayList<Node> list) {
		ArrayDeque<Node> que = new ArrayDeque<>();
		int depth = 0;
		boolean[] visited = new boolean[N + 1];

		que.add(list.get(start));
		visited[start] = true;

		while (!que.isEmpty()) {
			Node cur = que.poll();
			for (int a : cur.to) {
				if (!visited[a]) {
					visited[a] = true;
					que.add(list.get(a));
					depth++;
				}
			}
		}
		return depth; // 이어진 노드 개수 리턴
	}

}
