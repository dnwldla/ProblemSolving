import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] data;
    static long[] tree;

    static void update(int idx, long diff) {
        while (idx <= N) {
            tree[idx] += diff;
            idx += (idx & -idx);
        }
    }

    static long sum(int idx) {
        long ret = 0;
        while (idx > 0) {
            ret += tree[idx];
            idx -= (idx & -idx);
        }
        return ret;
    }

    static long rangeQuery(int l, int r) {
        return sum(r) - sum(l - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new long[N + 1];
        tree = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            long v = Long.parseLong(br.readLine().trim());
            data[i] = v;
            update(i, v);
        }

        int Q = M + K;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long c = Long.parseLong(st.nextToken()); 
                long diff = c - data[b];
                data[b]=c;
                update(b, diff);      
            } else { 
                int c = Integer.parseInt(st.nextToken());
                out.append(rangeQuery(b, c)).append('\n');
            }
        }

        System.out.print(out.toString());
    }
}