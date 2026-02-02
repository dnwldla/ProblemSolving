import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == 'H') graph[i][j] = -1;
                else graph[i][j] = c - '0';
            }
        }

        System.out.println(go(0, 0));
    }

    static int go(int x, int y) {
        if (outOfRange(x, y)) return 0;

        if (visited[x][y]) {
            System.out.println(-1);
            System.exit(0);
        }
        if (dp[x][y] != 0) return dp[x][y];

        visited[x][y] = true;

        int jump = graph[x][y];
        int best = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * jump;
            int ny = y + dy[i] * jump;
            best = Math.max(best, go(nx, ny) + 1);
        }

        visited[x][y] = false;
        dp[x][y] = best;
        return best;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M || graph[x][y] == -1;
    }
}
