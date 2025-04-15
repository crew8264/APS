package Acmicpc.GOLD;

import java.io.*;
import java.util.*;

public class Main_16234 {
    static int[] dx = { -1, 0, 1, 0}; // ��, ��, ��, ��
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
            boolean moved = false; // �α� �̵� ����

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (BFS(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break; // �α� �̵��� ������ ����
            days++;
        }

        System.out.println(days);
    }

    static boolean BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>(); // ���� ���� ����Ʈ
        queue.add(new int[] {x, y});
        union.add(new int[] {x, y});
        visited[x][y] = true;

        int sum = maps[x][y]; // ���� �α� �ջ�
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

        if (union.size() == 1) return false; // ������ �������� ����

        int avg = sum / union.size();
        for (int[] pos : union) {
            maps[pos[0]][pos[1]] = avg; // �α� �̵�
        }

        return true;
    }
}