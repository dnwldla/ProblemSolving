import java.util.*;

public class Main {
    static int n, k, a, b, ret;
    static String[] s = new String[1004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            a = sc.nextInt() - 1;
            b = sc.nextInt();
            b = (b == -1 ? 0 : 1);

            int l = findL(a);
            int r = findR(a);

            int cnt = 0;
            for (int pos = a; pos >= l; pos--) {
                s[pos] = rot(s[pos], cnt % 2 == 0 ? b : 1 - b);
                cnt++;
            }

            cnt = 1;
            for (int pos = a + 1; pos <= r; pos++) {
                s[pos] = rot(s[pos], cnt % 2 == 0 ? b : 1 - b);
                cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (s[i].charAt(0) == '1') ret++;
        }
        System.out.println(ret);
    }

    
    static String rot(String str, int dir) {
        if (dir == 0) { 
            return str.substring(1) + str.charAt(0);
        } else { 
            return str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
        }
    }

    static int findL(int pos) {
        for (int i = pos; i >= 1; i--) {
            if (s[i].charAt(6) == s[i - 1].charAt(2)) {
                return i;
            }
        }
        return 0;
    }

    static int findR(int pos) {
        for (int i = pos; i <= n - 2; i++) {
            if (s[i].charAt(2) == s[i + 1].charAt(6)) {
                return i;
            }
        }
        return n - 1;
    }
}