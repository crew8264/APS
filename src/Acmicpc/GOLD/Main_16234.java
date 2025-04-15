package Acmicpc.GOLD;

import java.io.*;
import java.util.*;

public class Main_16234 {
    static int[] dx = { -1, 0, 1, 0}; // 상, 좌, 하, 우
    static int[] dy = { 0, -1, 0, 1}; 
    static int N, L, R;
    static int[][] maps;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        maps = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean moved = false; // 인구 이동 여부

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (BFS(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break; // 인구 이동이 없으면 종료
            days++;
        }

        System.out.println(days);
    }

    static boolean BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>(); // 연합 국가 리스트
        queue.add(new int[] {x, y});
        union.add(new int[] {x, y});
        visited[x][y] = true;

        int sum = maps[x][y]; // 연합 인구 합산
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    int gap = Math.abs(maps[curX][curY] - maps[nx][ny]);

                    if (gap >= L && gap <= R) {
                        queue.add(new int[] {nx, ny});
                        union.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        sum += maps[nx][ny];
                    }
                }
            }
        }

        if (union.size() == 1) return false; // 연합이 형성되지 않음

        int avg = sum / union.size();
        for (int[] pos : union) {
            maps[pos[0]][pos[1]] = avg; // 인구 이동
        }

        return true;
    }
}