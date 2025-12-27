import java.util.*;
import java.io.*;

public class Main {
    static int T, N;

    static class Node {
        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            Node[] ar = new Node[N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                ar[j] = new Node(a, b);
            }

            Arrays.sort(ar, (o1, o2) -> o1.a - o2.a);

            int ret = 1;
            int max=ar[0].b;
            for (int j = 1; j < N; j++) {
                Node cur = ar[j];
                //cur의 두번째가 max보다 작아야 ret++
                if (cur.b<max) ret++;
                //max값을 업데이트한다
                max=Math.min(max,cur.b);

            }

            sb.append(ret).append('\n');
        }

        System.out.print(sb.toString());
    }
}
