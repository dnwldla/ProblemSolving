import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] tree;
    static int[][] points;
    static int[] ys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            points = new int[n][2];
            ys = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken()) * -1; // y 내림차순 정렬 위해 음수화
                points[i][0] = x;
                points[i][1] = y;
                ys[i] = y;
            }

            // 좌표 압축
            Arrays.sort(ys);
            Map<Integer, Integer> yIndex = new HashMap<>();
            int idx = 1;
            for (int y : ys) {
                if (!yIndex.containsKey(y)) {
                    yIndex.put(y, idx++);
                }
            }

            Arrays.sort(points, (a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]); // y는 음수니까 내림차순됨
            });

            tree = new int[idx + 2]; // 압축된 y index 최대값 기준

            long res = 0;
            for (int i = 0; i < n; i++) {
                int yIdx = yIndex.get(points[i][1]);
                res += sum(yIdx);
                update(yIdx, 1);
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    static void update(int i, int v) {
        while (i < tree.length) {
            tree[i] += v;
            i += (i & -i);
        }
    }

    static int sum(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= (i & -i);
        }
        return res;
    }
}
