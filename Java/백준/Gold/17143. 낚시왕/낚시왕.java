import java.io.*;
import java.util.*;

public class Main {

    static class Shark {
        int y, x, s, dir, z;
        boolean death;
    }

    // dir: 0=up, 1=down, 2=right, 3=left 
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Shark[] a = new Shark[M + 1];
        int[][] shark = new int[R][C];
        int[][] temp = new int[R][C];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            Shark s = new Shark();
            s.y = Integer.parseInt(st.nextToken()) - 1;
            s.x = Integer.parseInt(st.nextToken()) - 1;
            s.s = Integer.parseInt(st.nextToken());
            s.dir = Integer.parseInt(st.nextToken()) - 1; 
            s.z = Integer.parseInt(st.nextToken());
            s.death = false;

            if (s.dir <= 1) {
                if (R > 1) s.s %= (2 * (R - 1));
                else s.s = 0;
            } else {
                if (C > 1) s.s %= (2 * (C - 1));
                else s.s = 0;
            }

            a[i] = s;
            shark[s.y][s.x] = i;
        }

        int ret = 0;

        for (int t = 0; t < C; t++) {
            for (int y = 0; y < R; y++) {
                if (shark[y][t] != 0) {
                    int idx = shark[y][t];
                    a[idx].death = true;
                    ret += a[idx].z;
                    shark[y][t] = 0;
                    break;
                }
            }

            for (int i = 0; i < R; i++) {
                Arrays.fill(temp[i], 0);
            }

            for (int i = 1; i <= M; i++) {
                Shark s = a[i];
                if (s == null || s.death) continue;

                int y = s.y, x = s.x;
                int spd = s.s;
                int d = s.dir;
                int ny, nx;

                while (true) {
                    ny = y + spd * dy[d];
                    nx = x + spd * dx[d];

                    if (0 <= ny && ny < R && 0 <= nx && nx < C) break;

                    if (d <= 1) { // up/down
                        if (ny < 0) {
                            spd -= y;
                            y = 0;
                        } else {
                            spd -= (R - 1 - y);
                            y = R - 1;
                        }
                    } else { // right/left
                        if (nx < 0) {
                            spd -= x;
                            x = 0;
                        } else {
                            spd -= (C - 1 - x);
                            x = C - 1;
                        }
                    }
                    d ^= 1; // 방향 바꾸기
                }

                if (temp[ny][nx] != 0) {
                    int otherIdx = temp[ny][nx];
                    if (a[otherIdx].z < s.z) {
                        a[otherIdx].death = true;
                        temp[ny][nx] = i;
                    } else {
                        s.death = true;
                    }
                } else {
                    temp[ny][nx] = i;
                }
                s.y = ny;
                s.x = nx;
                s.dir = d;
            }

            for (int i = 0; i < R; i++) {
                System.arraycopy(temp[i], 0, shark[i], 0, C);
            }
        }

        System.out.println(ret);
    }
}
