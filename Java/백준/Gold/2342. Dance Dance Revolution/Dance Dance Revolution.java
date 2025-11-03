import java.util.*;

public class Main {
    static int[][][] dp;
    static int n;
    static List<Integer> v = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            if (num == 0) break;
            v.add(num);
        }
        sc.close();

        n = v.size();
        dp = new int[5][5][n + 1];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(go(0, 0, 0));
    }
    

    static int go(int y, int x, int target) {
        if (target == n) return 0;
        if (dp[y][x][target] != -1) return dp[y][x][target];

        int next = v.get(target);
        int left  = go(next, x, target + 1) + check(y, next);
        int right = go(y,   next, target + 1) + check(x, next);

        return dp[y][x][target] = Math.min(left, right);
    }

    static int check(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }
}
