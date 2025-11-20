import java.io.*;
import java.util.*;

public class Main {

    static int[][][] dp = new int[1004][2][34];
    static int n, m;
    static int[] b = new int[1004];

    static int go(int idx, int tree, int cnt) {
        if (cnt < 0) return -1_000_000_000; // -1e9
        if (idx == n) return 0;

        int ret = dp[idx][tree][cnt];
        if (ret != -1) return ret;

        int stay = go(idx + 1, tree, cnt);
        int move = go(idx + 1, tree ^ 1, cnt - 1);

        ret = Math.max(move, stay) + ((tree == (b[idx] - 1)) ? 1 : 0);
        dp[idx][tree][cnt] = ret;
        return ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 1004; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(br.readLine().trim());
        }

        int ans = Math.max(go(0, 1, m - 1), go(0, 0, m));
        System.out.println(ans);
    }
}
