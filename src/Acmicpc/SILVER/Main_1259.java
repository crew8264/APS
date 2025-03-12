package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = "";
		while(true) {
			temp = br.readLine();
			if(temp.equals("0")) break;
			
			boolean isFel = true;
			int p1 = 0, p2 = temp.length()-1;
			for(int i=0; i<temp.length()/2; i++) {
				if(temp.charAt(p1) != (temp.charAt(p2))) {
					isFel = false;
					break;
				}
				p1++; p2--;
			}
			if(isFel) System.out.println("yes");
			else System.out.println("no");
		}
		
	}
}
