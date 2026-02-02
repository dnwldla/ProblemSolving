import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ret;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int changeToInt(char c) {
        return c - '0';
    }

    static void go(int x, int y, int cnt) {
        if (x < 0 || x >= N || y < 0 || y >= M || graph[x][y] == 'H') return;

        if (visited[x][y]) {
            System.out.println(-1);
            System.exit(0);
        }

        if (dist[x][y] >= cnt) return;
        dist[x][y] = cnt;

        visited[x][y] = true;

        int k = changeToInt(graph[x][y]);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * k;
            int ny = y + dy[i] * k;
            go(nx, ny, cnt + 1);
        }

        visited[x][y] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        go(0, 0, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ret = Math.max(ret, dist[i][j]);
            }
        }

        System.out.println(ret);
    }
}
