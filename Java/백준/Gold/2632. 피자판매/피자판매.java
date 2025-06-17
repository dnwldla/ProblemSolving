import java.util.*;

public class Main {
    static int[] a = new int[1001], b = new int[1001];
    static int[] psumA = new int[2002], psumB = new int[2002];
    static Map<Integer, Integer> aCnt = new HashMap<>();
    static Map<Integer, Integer> bCnt = new HashMap<>();
    static int want, n, m, ret;

    public static void make(int len, int[] psum, Map<Integer, Integer> map) {
        for (int interval = 1; interval <= len; interval++) {
            for (int start = interval; start <= len + interval - 1; start++) {
                int sum = psum[start] - psum[start - interval];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                if (interval == len) break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        want = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            psumA[i] = psumA[i - 1] + a[i];
        }
        for (int i = n + 1; i <= 2 * n; i++) {
            psumA[i] = psumA[i - 1] + a[i - n];
        }

        for (int i = 1; i <= m; i++) {
            b[i] = sc.nextInt();
            psumB[i] = psumB[i - 1] + b[i];
        }
        for (int i = m + 1; i <= 2 * m; i++) {
            psumB[i] = psumB[i - 1] + b[i - m];
        }

        make(n, psumA, aCnt);
        make(m, psumB, bCnt);

        ret = aCnt.getOrDefault(want, 0) + bCnt.getOrDefault(want, 0);

        for (int i = 1; i < want; i++) {
            ret += aCnt.getOrDefault(i, 0) * bCnt.getOrDefault(want - i, 0);
        }

        System.out.println(ret);
    }
}
