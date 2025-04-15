package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
	static int L, C;
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		str = new String[C];
		arr = new int[L];
		
		str = br.readLine().split(" ");
		Arrays.sort(str);
		
		Comb(0, 0);
		
	}
	
	static int arr[]; 
	static String sb;
	static void Comb(int cnt, int st) {
		if(cnt == L) {
			sb = "";
			for(int a : arr) {
				sb += str[a];
			}
			if(cckWord()) System.out.println(sb);
			return;
		}
		
		for(int i=st; i<C; i++) {
			arr[cnt] = i;
			Comb(cnt+1, i+1);
		}
	}
	
	static boolean cckWord() {
		char[] temp = sb.toCharArray();
		
		int ja = 0, mo = 0;
		for(char ch : temp) {
			if(ch == 'a' || ch == 'e' || ch == 'i' ||
					ch == 'o' || ch == 'u')
				ja++;
			else
				mo++;
		}
		
		if(ja>=1 && mo>=2)
			return true;
		return false;
		
			
	}
}




