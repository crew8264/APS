package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Solution_1210_김용빈 {
	static int y = -1; // 에러 검출
	static int arr[][] = new int[101][101]; // 입력받은 지도

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//		여기까지 입출력 ----------------
			
			for (int i = 0; i < 100; i++) { // 시작 y좌표 검출
				if (arr[99][i] == 2)
					y = i;
			}

			for (int i = 99; i > 0; i--) { // 코드 동작
				if ((y - 1) < 0) { // 좌표가 -1, 101 엣지 케이스 검출
					checkRight(i);
				} else if ((y + 1) > 100) {
					checkLeft(i);
				} else {
					if (checkLeft(i))
						continue;
					else
						checkRight(i);
				}
			}
			System.out.printf("#%d %d\n", T, y);
		}
	}

	// 왼쪽 체크
	static boolean checkLeft(int i) {

		if ((arr[i][y - 1] == 1)) { 
			int idx = 1;
			while (true) { // 한 틱씩 더하는게 아니라, idx에 한 번에 더하기
				if ((y - idx) < 0)
					break;
				if (arr[i][y - idx] == 0) {
					y -= idx - 1;
					return true;
				}
				idx++;
			}
		}
		return false;
	}

	// 오른쪽 체크
	static void checkRight(int i) {

		if (arr[i][y + 1] == 1) {
			int idx = 1;
			while (true) { 
				if ((y + idx) > 100)
					break;
				if (arr[i][y + idx] == 0) {
					y += idx - 1;
					break;
				}
				idx++;
			}
		}
	}
}
