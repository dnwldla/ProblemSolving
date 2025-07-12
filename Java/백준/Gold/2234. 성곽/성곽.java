import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] ar, mask;
    static int[] cnt = new int[2600];
    static boolean[][] visited;
    static int delMax = 0;

    public static int dfs(int x, int y, int roomMask) {
        visited[x][y] = true;
        mask[x][y] = roomMask;
        int ret = 1;

        for (int i = 1; i <= 8; i *= 2) {
            if ((ar[x][y] & i) == 0) {
                int nx = x, ny = y;

                if (i == 1) ny = y - 1;
                else if (i == 2) nx = x - 1;
                else if (i == 4) ny = y + 1;
                else if (i == 8) nx = x + 1;

                if (nx < 1 || nx > M || ny < 1 || ny > N) continue;
                if (visited[nx][ny]) continue;

                ret += dfs(nx, ny, roomMask);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ar = new int[M + 2][N + 2];
        mask = new int[M + 2][N + 2];
        visited = new boolean[M + 2][N + 2];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                ar[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomCnt = 0;
        int maxRoom = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    int curCnt = dfs(i, j, roomCnt);
                    maxRoom = Math.max(curCnt, maxRoom);
                    cnt[roomCnt] = curCnt;
                    roomCnt++;
                }
            }
        }

        for (int x = 1; x <= M; x++) {
            for (int y = 1; y <= N; y++) {
                for (int j = 1; j <= 8; j *= 2) {
                    if ((ar[x][y] & j) != 0) {
                        int nx = x, ny = y;

                        if (j == 1) ny = y - 1;
                        else if (j == 2) nx = x - 1;
                        else if (j == 4) ny = y + 1;
                        else if (j == 8) nx = x + 1;

                        if (nx < 1 || nx > M || ny < 1 || ny > N) continue;
                        if (mask[nx][ny] == mask[x][y]) continue;

                        delMax = Math.max(cnt[mask[x][y]] + cnt[mask[nx][ny]], delMax);
                    }
                }
            }
        }

        System.out.println(roomCnt);
        System.out.println(maxRoom);
        System.out.println(delMax);
    }
}
