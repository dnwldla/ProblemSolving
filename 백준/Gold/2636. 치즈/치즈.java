import java.util.*;

public class Main {
    static int[][] a = new int[104][104];
    static boolean[][] visited = new boolean[104][104];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m, cnt, cnt2;
    static List<int[]> v = new ArrayList<>();

    static void go(int y, int x) {
        visited[y][x] = true;
        if (a[y][x] == 1) {
            v.add(new int[]{y, x});
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) continue;
            go(ny, nx);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        while (true) {
            // Reset visited array
            for (int i = 0; i < 104; i++) {
                Arrays.fill(visited[i], false);
            }

            v.clear();
            go(0, 0);

            cnt2 = v.size();
            for (int[] b : v) {
                a[b[0]][b[1]] = 0;
            }

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != 0) flag = true;
                }
            }

            cnt++;
            if (!flag) break;
        }

        System.out.println(cnt);
        System.out.println(cnt2);

        sc.close();
    }
}