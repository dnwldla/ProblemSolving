import java.util.Scanner;

public class Main {
    static final int MAX_N = 200_004;
    static final long MOD = 1_000_000_007L;

    static long[] treeCnt = new long[MAX_N + 2];
    static long[] treeSum = new long[MAX_N + 2];

    static long prefixSum(long[] tree, int idx) {
        long res = 0;
        int i = idx;
        while (i > 0) {
            res += tree[i];
            i -= (i & -i);
        }
        return res;
    }

    static long rangeSum(long[] tree, int s, int e) {
        if (s > e) return 0;
        return prefixSum(tree, e) - prefixSum(tree, s - 1);
    }

    static void update(long[] tree, int idx, long val) {
        int i = idx;
        while (i <= MAX_N) {
            tree[i] += val;
            i += (i & -i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ret = 1;

        for (int i = 1; i <= n; i++) {
            int value = sc.nextInt();
            value++; // 1-based 인덱싱 보정

            if (i != 1) {
                long left  = (long) value * rangeSum(treeCnt, 1, value - 1) - rangeSum(treeSum, 1, value - 1);
                long right = rangeSum(treeSum, value + 1, MAX_N) - (long) value * rangeSum(treeCnt, value + 1, MAX_N);
                long add = (left + right) % MOD;
                if (add < 0) add += MOD;
                ret = (ret * add) % MOD;
            }

            update(treeCnt, value, 1);
            update(treeSum, value, value);
        }

        System.out.println(ret);
    }
}
