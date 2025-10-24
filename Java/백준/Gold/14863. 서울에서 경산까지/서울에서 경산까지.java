import java.io.*;
import java.util.*;

public class Main {
    static final int NEG_INF = -1_000_000_000;

    static int n, k;
    static int[][] dp;
    static int[] aTime, aPay, bTime, bPay;

    static int go(int idx, int timeLeft) {
        if (idx == n) return 0;
        if (dp[idx][timeLeft] != NEG_INF) return dp[idx][timeLeft];

        int ret = NEG_INF;

        if (timeLeft >= aTime[idx]) {
            ret = Math.max(ret, go(idx + 1, timeLeft - aTime[idx]) + aPay[idx]);
        }
        if (timeLeft >= bTime[idx]) {
            ret = Math.max(ret, go(idx + 1, timeLeft - bTime[idx]) + bPay[idx]);
        }

        return dp[idx][timeLeft] = ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        aTime = new int[n];
        aPay  = new int[n];
        bTime = new int[n];
        bPay  = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            aTime[i] = Integer.parseInt(st.nextToken());
            aPay[i]  = Integer.parseInt(st.nextToken());
            bTime[i] = Integer.parseInt(st.nextToken());
            bPay[i]  = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], NEG_INF);
        }

        int ans = go(0, k);
        System.out.println(ans);
    }
}
