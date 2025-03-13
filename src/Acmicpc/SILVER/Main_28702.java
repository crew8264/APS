package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_28702 {
	static String[] arr = new String[3];
	static int[] change = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr[0] = br.readLine();
		arr[1] = br.readLine();
		arr[2] = br.readLine();
		
		int a = 0;
		for(int i=0; i<3; i++) {
			if(arr[i].matches("\\d+")) {
				change[i] = Integer.parseInt(arr[i]);
				a = i;
			}
		}
		
		int ans = change[a] + (3-a);
		
		if(ans%3 == 0 && ans % 5 == 0)
			System.out.println("FizzBuzz");
		else if(ans%3 == 0)
			System.out.println("Fizz");
		else if(ans%5 == 0)
			System.out.println("Buzz");
		else
			System.out.println(ans);
	}
}
