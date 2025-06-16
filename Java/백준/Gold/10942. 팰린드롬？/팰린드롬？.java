import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] ar = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            if (ar[i] == ar[i + 1]) dp[i][i + 1] = 1;
        }

        for (int len = 3; len <= N; len++) {
            for (int j = 1; j <= N; j++) {
                int start = j;
                int end = j + len - 1;
                if (end > N) break;

                if (ar[start] == ar[end] && dp[start + 1][end - 1] == 1) {
                    dp[start][end] = 1;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); // 출력도 모아서 빠르게
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E]).append("\n");
        }

        System.out.print(sb);
    }
}
