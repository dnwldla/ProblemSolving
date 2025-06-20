import java.util.*;

public class Main {
    static final int INF = 987654321;
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};
    static int n, m, k;
    static int[][] a = new int[104][104];
    static int[][] b = new int[104][104];
    static int ret = INF;
    static int r, c, s;
    static int sy, sx, ey, ex, dir;
    static boolean[][] visited = new boolean[104][104];
    static List<Pair> vv = new ArrayList<>();
    static List<Integer> vIdx = new ArrayList<>();

    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class A {
        int y, x, cnt;
        A(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static List<A> v = new ArrayList<>();

    static void go(int y, int x, boolean first) {
        if (!first && y == sy && x == sx) dir++;
        if (!first && y == sy && x == ex) dir++;
        if (!first && y == ey && x == ex) dir++;
        if (!first && y == ey && x == sx) dir++;

        int ny = y + dy[dir];
        int nx = x + dx[dir];
        if (visited[ny][nx]) return;

        visited[ny][nx] = true;
        vv.add(new Pair(ny, nx));
        go(ny, nx, false);
    }

    static void rotateAll(int y, int x, int cnt) {
        for (int i = 1; i <= cnt; i++) {
            sy = y - i;
            sx = x - i;
            ey = y + i;
            ex = x + i;
            vv.clear();
            dir = 0;
            for (int ii = 0; ii < 104; ii++) Arrays.fill(visited[ii], false);

            visited[sy][sx] = true;
            vv.add(new Pair(sy, sx));
            go(sy, sx, true);

            List<Integer> temp = new ArrayList<>();
            for (Pair p : vv) temp.add(b[p.y][p.x]);

            // 회전 (맨 뒤를 맨 앞으로)
            Collections.rotate(temp, 1);

            for (int j = 0; j < vv.size(); j++) {
                Pair p = vv.get(j);
                b[p.y][p.x] = temp.get(j);
            }
        }
    }

    static int solve() {
        for (int idx : vIdx) {
            A op = v.get(idx);
            rotateAll(op.y, op.x, op.cnt);
        }

        int mn = INF;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += b[i][j];
            }
            mn = Math.min(mn, sum);
        }
        return mn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

        for (int i = 0; i < k; i++) {
            r = sc.nextInt() - 1;
            c = sc.nextInt() - 1;
            s = sc.nextInt();
            v.add(new A(r, c, s));
            vIdx.add(i);
        }

        List<Integer> perm = new ArrayList<>(vIdx);
        do {
            for (int i = 0; i < n; i++)
                System.arraycopy(a[i], 0, b[i], 0, m);

            vIdx = new ArrayList<>(perm);
            ret = Math.min(ret, solve());
        } while (nextPermutation(perm));

        System.out.println(ret);
    }

    // next_permutation 구현
    static boolean nextPermutation(List<Integer> arr) {
        int i = arr.size() - 2;
        while (i >= 0 && arr.get(i) >= arr.get(i + 1)) i--;
        if (i < 0) return false;

        int j = arr.size() - 1;
        while (arr.get(i) >= arr.get(j)) j--;

        Collections.swap(arr, i, j);
        Collections.reverse(arr.subList(i + 1, arr.size()));
        return true;
    }
}
