package Acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_김용빈 {
	static String dna; // 입력받을 배열
	static int S, P, answer = 0;
	static int A, C, G, T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken()); // 문자열 크기
		P = Integer.parseInt(st.nextToken()); // 선택할 갯수
		
		dna = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		int cntA = 0, cntC = 0, cntG = 0, cntT = 0;
		
		for(int i=0; i<P; i++) { // 첫 문자열 동작
			switch (dna.charAt(i)) {
			case 'A': cntA++; break;
			case 'C': cntC++; break;
			case 'G': cntG++; break;
			case 'T': cntT++; break;
			}
		}
		if(cntA >= A && cntC >= C && cntG >= G && cntT >= T) { // 체크
			answer++;
		}
		
		for(int i=P; i<S; i++) { // 다음 문자열을 대상으로 :
			switch (dna.charAt(i-P)) { // 앞에거 빼고
			case 'A': cntA--; break;
			case 'C': cntC--; break;
			case 'G': cntG--; break;
			case 'T': cntT--; break;
			}
			
			switch (dna.charAt(i)) { // 뒤에거 더하고
			case 'A': cntA++; break;
			case 'C': cntC++; break;
			case 'G': cntG++; break;
			case 'T': cntT++; break;
			}
			
			if(cntA >= A && cntC >= C && cntG >= G && cntT >= T) { // 체크
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
