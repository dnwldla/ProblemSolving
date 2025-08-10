import java.io.*;
import java.util.*;

public class Main {
    static int sum = 0, N;
    static int[][] board = new int[24][24];

    static void rotate(int[][] b) {
        int[][] temp = new int[24][24];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = b[N - 1 - j][i];
            }
        }
        copyInto(b, temp);
    }

    static void slide(int[][] b) {
        int[][] temp = new int[24][24];
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (b[i][j] == 0) continue;

                if (temp[i][cnt] == 0) {
                    temp[i][cnt] = b[i][j];
                } else if (temp[i][cnt] == b[i][j]) {
                    temp[i][cnt] *= 2;
                    cnt++;
                } else {
                    cnt++;
                    temp[i][cnt] = b[i][j];
                }
            }
        }
        copyInto(b, temp);
    }

    static void counting(int[][] b) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum = Math.max(sum, b[i][j]);
            }
        }
    }

    static void go(int here, int[][] b) {
        if (here == 5) {
            counting(b);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[][] cpy = copyOf(b);
            slide(cpy);
            go(here + 1, cpy);
            rotate(b);
        }
    }

    static int[][] copyOf(int[][] src) {
        int[][] dst = new int[24][24];
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, N);
        }
        return dst;
    }

    static void copyInto(int[][] dest, int[][] src) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, N);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, board);
        System.out.println(sum);
    }
}
