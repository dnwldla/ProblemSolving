import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long attack;
    static int[] t;
    static long[] a;
    static long[] h;

    static boolean check(long mid) {
        long maxHp = mid;
        long curAttack = attack;

        for (int i = 0; i < n; i++) {
            if (t[i] == 2) { // 포션 방
                // 체력 회복 (최대 maxHp 까지만)
                mid = Math.min(maxHp, mid + h[i]);
                // 공격력 증가
                curAttack += a[i];
            } else { // 몬스터 방
                // 몬스터를 쓰러뜨리기 위해 필요한 공격 횟수
                long cnt = h[i] / curAttack;
                if (h[i] % curAttack != 0) cnt++;

                // 용사도 (cnt - 1)번 맞음
                mid -= (cnt - 1) * a[i];
            }

            if (mid <= 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        // fastIO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        attack = Long.parseLong(st.nextToken());

        t = new int[130005];
        a = new long[130005];
        h = new long[130005];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            a[i] = Long.parseLong(st.nextToken());
            h[i] = Long.parseLong(st.nextToken());
        }

        long lo = 1L;
        long hi = 1_000_000_000_000_000_004L; 
        long ret = hi;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (check(mid)) {
                ret = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        sb.append(ret).append('\n');
        System.out.print(sb);
    }
}
