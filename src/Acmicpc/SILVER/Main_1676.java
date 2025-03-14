package Acmicpc.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=5 ; i<=N ; i+=5){
            int temp = i;
            while(temp % 5 == 0){
                answer += 1;
                temp = temp/5;
            }
        }
        
		System.out.println(answer);

	}
	

}
