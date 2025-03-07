
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_31403 {
	static String A, B, C;
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine();
		B = br.readLine();
		C = br.readLine();
		
		System.out.println(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C));
		System.out.println(Integer.parseInt(A+B) - Integer.parseInt(C));
	}
}
