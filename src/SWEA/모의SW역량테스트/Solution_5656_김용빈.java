package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5656_김용빈 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, W, H, originBlock = 0;
	static int[][] blocks;
	static ArrayDeque<int[]> que = new ArrayDeque<>();
	static int resultBlock = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			blocks = new int[H][W];
			originBlock = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					blocks[i][j] = Integer.parseInt(st.nextToken());
					if (blocks[i][j] != 0)
						originBlock++;
				}
			}
			resultBlock = Integer.MAX_VALUE;
			process(0, blocks, originBlock);
//			System.out.println("origin: " + originBlock);
//			System.out.println("after: " + resultBlock);
			System.out.println("#" + tc + " " + resultBlock);
		}
	}

	static void process(int depth, int[][] currentBlocks, int remainBlock) {
		if (depth == N) {
//			if (remainBlock < resultBlock) {
//				for (int q = 0; q < H; q++) {
//					System.out.println(Arrays.toString(currentBlocks[q]));
//				}
//				System.out.println();
//				System.out.println("res:"+resultBlock+" rem:"+remainBlock);
//			}
			resultBlock = Math.min(remainBlock, resultBlock);
			return;
		}
		
		for (int col = 0; col < W; col++) { // 열(W)을 순회
			int rmb = remainBlock;
			
			int[][] nextBlocks = new int[H][W];
			for (int i = 0; i < H; i++) {
				nextBlocks[i] = Arrays.copyOf(currentBlocks[i], W);
			}
			for (int row = 0; row < H; row++) { // 행(H)을 탐색
				if (nextBlocks[row][col] != 0) {
					que.add(new int[] { row, col });
					nextBlocks[row][col] = 0;
					rmb--;
					break;
				}
			}

			while (!que.isEmpty()) {
				int[] cur = que.poll();
				int x = cur[0];
				int y = cur[1];
				int power = currentBlocks[x][y];

				for (int i = 0; i < 4; i++) {
					for (int j = 1; j < power; j++) {
						int tx = x + dx[i] * j;
						int ty = y + dy[i] * j;

						if (tx >= 0 && tx < H && ty >= 0 && ty < W && nextBlocks[tx][ty] != 0) {
							que.add(new int[] { tx, ty });
							nextBlocks[tx][ty] = 0;
							rmb--;
						}
					}
				}
			}
			
			gravity(nextBlocks);
			process(depth + 1, nextBlocks, rmb);
		}

	}

    static void gravity(int[][] arr) {
        for (int col = 0; col < W; col++) {
            int[] temp = new int[H];
            int idx = H - 1;
            for (int row = H - 1; row >= 0; row--) {
                if (arr[row][col] != 0) {
                    temp[idx--] = arr[row][col];
                }
            }
            for (int row = 0; row < H; row++) {
                arr[row][col] = temp[row];
            }
        }
    }
}
