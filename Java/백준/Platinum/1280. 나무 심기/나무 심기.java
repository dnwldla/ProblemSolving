import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 200_010;
    static final long MOD = 1_000_000_007L;

    static int N;
    static int[] arr;
    static long[] cntFenwick;
    static long[] distFenwick;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            a++;
            arr[i] = a;
        }

        cntFenwick = new long[MAX + 1];
        distFenwick = new long[MAX + 1];

        updateCnt(arr[1], 1);
        updateDist(arr[1], arr[1]);

        long answer = 1L;

        for (int i = 2; i <= N; i++) {
            int x = arr[i];

            long leftCnt  = queryCnt(x - 1);
            long rightCnt = queryCnt(MAX) - queryCnt(x);

            long leftDist  = queryDist(x - 1);
            long rightDist = queryDist(MAX) - queryDist(x);

            long leftResult  = ((long)x * leftCnt - leftDist) % MOD;
            if (leftResult < 0) leftResult += MOD;

            long rightResult = (rightDist - (long)x * rightCnt) % MOD;
            if (rightResult < 0) rightResult += MOD;

            long result = (leftResult + rightResult) % MOD;
            if (result < 0) result += MOD;

            answer = (answer * result) % MOD;

            updateCnt(x, 1);
            updateDist(x, x);
        }

        System.out.println(answer % MOD);
    }

    static void updateCnt(int pos, long delta) {
        while (pos <= MAX) {
            cntFenwick[pos] += delta;
            pos += (pos & -pos);
        }
    }

    static void updateDist(int pos, long value) {
        while (pos <= MAX) {
            distFenwick[pos] += value;
            pos += (pos & -pos);
        }
    }

    static long queryCnt(int pos) {
        long res = 0L;
        while (pos > 0) {
            res += cntFenwick[pos];
            pos -= (pos & -pos);
        }
        return res;
    }

    static long queryDist(int pos) {
        long res = 0L;
        while (pos > 0) {
            res += distFenwick[pos];
            pos -= (pos & -pos);
        }
        return res;
    }
}
