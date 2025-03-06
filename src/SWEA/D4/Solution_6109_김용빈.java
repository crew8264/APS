package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_6109_김용빈 {
	static int T, N;
	static int[][] egsp;
	static int[][] rtArray;
	static String direction;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			direction = st.nextToken();
			
			egsp = new int[N][N];
			rtArray = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					egsp[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
//			입출력 -----------------------------
			
			// 내가 구현한 건 left 뿐이라, 배열을 회전해야 함
			switch(direction) { // 입력받은 방향에 따라,
			case "up":
				egsp = turnLeftArray(N, egsp);
				for(int i=0; i<N; i++) {
					rtArray[i] = tgsp(egsp[i]); // 배열 [i]마다 돌려
				}
				rtArray = turnRightArray(N, rtArray);
				break;
				
			case "down":
				egsp = turnRightArray(N, egsp); // 똑같음
				for(int i=0; i<N; i++) {
					rtArray[i] = tgsp(egsp[i]);
				}
				rtArray = turnLeftArray(N, rtArray); // 똑같음
				break;
				
			case "left":
				for(int i=0; i<N; i++) { // 이친구가 원본
					rtArray[i] = tgsp(egsp[i]);
				}
				
				break;
			case "right":
				for(int i=0; i<N; i++) { // 이친구는 돌리지 않고 배열을 뒤집어서 넣어줬음
					reverse(egsp[i]);
					rtArray[i] = tgsp(egsp[i]);
					for(int k=0, j=rtArray.length-1; k < j; k++, j--) {
						int temp=0;
						temp = rtArray[i][j];
						rtArray[i][j] = rtArray[i][k];
						rtArray[i][k] = temp;
					}
				}
				break;
			}
			
			// 테케 출력
			System.out.println("#"+tc); 
			for(int[] ar : rtArray) {
				for(int i=0; i<N;i++) {
					System.out.print(ar[i]+" ");
				}
				System.out.println();
			}
		}
	}
	
	// 배열 좌회전 <
	static int[][] turnLeftArray(int len, int[][] array) {
		int[][] tempArray = new int[len][len];
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				tempArray[len -j -1][i] = array[i][j];
			}
		}
		return tempArray;
	}
	// 배열 우회전 >
	static int[][] turnRightArray(int len, int[][] array) {
		int[][] tempArray = new int[len][len];
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				tempArray[j][len-i-1] = array[i][j];
			}
		}
		return tempArray;
	}
	
	// 실제 돌리는 코드
	static int[] tgsp(int[] line) {
		int L = line.length;
		ArrayList<Integer> temp = new ArrayList<>();
		ArrayList<Integer> rt = new ArrayList<>();
		
		for(int a : line) {
			if(a != 0)
				temp.add(a);
		}
		
		for(int i=0; i<temp.size(); i++) {
			if(i >= temp.size()-1) { rt.add(temp.get(i)); break; }
//			System.out.printf("i:%d i+1:%d\n",temp.get(i), temp.get(i+1));
			if(temp.get(i).equals(temp.get(i+1))) {
				rt.add(temp.get(i)*2);
				i++;
			} else {
				rt.add(temp.get(i));
			}
		}
		
		for(int i=rt.size(); i<L; i++) {
			rt.add(0);
		}
		
	    int[] arr2 = rt.stream()
                .mapToInt(i -> i)
                .toArray();
	    
	    
		return arr2;
	}
	
	// 배열을 뒤집는 코드
	static void reverse(int[] arr) {
		for(int k=0, j=arr.length-1; k < j; k++, j--) {
			int temp=0;
			temp = arr[j];
			arr[j] = arr[k];
			arr[k] = temp;
		}
	}
}

/*
1
5 up
4 8 2 4 0
4 4 2 0 8
8 0 2 4 4
2 2 2 2 8
0 2 2 0 0

1
5 down
4 8 2 4 0
4 4 2 0 8
8 0 2 4 4
2 2 2 2 8
0 2 2 0 0

1
5 left
4 8 2 4 0
4 4 2 0 8
8 0 2 4 4
2 2 2 2 8
0 2 2 0 0

1
5 right
4 8 2 4 0
4 4 2 0 8
8 0 2 4 4
2 2 2 2 8
0 2 2 0 0

1
2 up
16 2
0 2
*/
