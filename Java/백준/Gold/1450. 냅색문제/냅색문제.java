import java.util.*;

public class Main {
    static int n;
    static long c;
    static long[] a = new long[31];
    static List<Long> v = new ArrayList<>();
    static List<Long> v2 = new ArrayList<>();
    static long ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextLong();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        go(0, n / 2 - 1, v, 0);
        go(n / 2, n - 1, v2, 0);

        Collections.sort(v);
        Collections.sort(v2);

        for (long b : v) {
            if (c - b >= 0) {
                int upperIdx = upperBound(v2, c - b);
                ret += upperIdx;
            }
        }

        System.out.println(ret);
    }

    static void go(int here, int end, List<Long> list, long sum) {
        if (sum > c) return;
        if (here > end) {
            list.add(sum);
            return;
        }

        go(here + 1, end, list, sum + a[here]);
        go(here + 1, end, list, sum);
    }
    
    static int upperBound(List<Long> list, long target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}