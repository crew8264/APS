package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14567 {
	
	// 노드 구성
	static class Node {
		int from;
		ArrayList<Integer> to = new ArrayList<Integer>();
		
		Node(int from) {
			this.from = from;
		}
		
		@Override
		public String toString() {
			return "[from: "+from+" to : "+to+"]";
		}
	}
	
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] inNode = new int[N+1];// 진입차수 관리
		int[] sems = new int[N+1];	// 결과 학기 관리
		ArrayList<Node> grph = new ArrayList<Node>();
		
		for(int i=1; i<=N; i++) { 	// 노드 초기값
			grph.add(new Node(i));
		}
		
		
		for(int i=0; i<M; i++) { 	// 인풋 받으면서,
			st = new StringTokenizer(br.readLine());
			int inpt1 = Integer.parseInt(st.nextToken());
			int inpt2 = Integer.parseInt(st.nextToken());
			
			grph.get(inpt1-1).to.add(inpt2);
			inNode[inpt2]++;		// 진입차수도 더함
		}
		
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		for(int i=1; i<=N; i++) {	// 진입차수 0인 것들을 큐에 추가
			if(inNode[i] == 0) {
				que.add(i);
				sems[i] = 1;
			}
		}
		
		
		while(!que.isEmpty()) {		// 큐가 빌때까지
			int now = que.poll();
			Node nw = grph.get(now-1);
			
			for(int next : nw.to) {	// 노드 안에 to(다음 노드 정보)로
				inNode[next]--;		// 다음 노드의 진입차수 감소
				
				if(inNode[next] == 0) {	// 진입차수가 0이라면
					que.add(next);
					sems[next] = sems[now]+1;
				}
			}
			
		}

		// sems(학기 정보) 출력
		for(int i=1; i<=N; i++) {
			System.out.print(sems[i]+" ");
		}System.out.println();
		
	}
}
