import java.io.*;
import java.util.*;

public class Main {
    static int n, m, T;
    static int[][] a;
    static boolean[][] visited;
    static int ret = 0;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static boolean noAdjEqual = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int row = x - 1; row < n; row += x) {
                rotateRow(row, d, k);
            }

            if (findAdj()) {
                setAverage();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret += a[i][j];
            }
        }
        System.out.println(ret);
    }

    static void rotateRow(int row, int dir, int k) {
        k %= m;
        if (k == 0) return;

        int[] v = Arrays.copyOf(a[row], m);

        if (dir == 1) {
            int[] tmp = new int[m];
            System.arraycopy(v, k, tmp, 0, m - k);
            System.arraycopy(v, 0, tmp, m - k, k);
            a[row] = tmp;
        } else {
            int left = (m - k) % m;
            int[] tmp = new int[m];
            System.arraycopy(v, left, tmp, 0, m - left);
            System.arraycopy(v, 0, tmp, m - left, left);
            a[row] = tmp;
        }
    }

    static boolean findAdj() {
        noAdjEqual = true;
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (a[y][x] == 0) continue;
                if (visited[y][x]) continue;
                dfs(y, x);
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (visited[y][x]) a[y][x] = 0;
            }
        }
        return noAdjEqual;
    }

    static void dfs(int y, int x) {
        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = (x + dx[dir] + m) % m;
            if (ny < 0 || ny >= n) continue;
            if (visited[ny][nx]) continue;
            if (a[y][x] != 0 && a[y][x] == a[ny][nx]) {
                visited[y][x] = true;
                visited[ny][nx] = true;
                noAdjEqual = false;
                dfs(ny, nx);
            }
        }
    }

    static void setAverage() {
        long sum = 0;
        int cnt = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (a[y][x] == 0) continue;
                sum += a[y][x];
                cnt++;
            }
        }
        if (cnt == 0) return;

        double avg = (double) sum / (double) cnt;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (a[y][x] == 0) continue;
                if ((double) a[y][x] > avg) a[y][x]--;
                else if ((double) a[y][x] < avg) a[y][x]++;
            }
        }
    }
}
