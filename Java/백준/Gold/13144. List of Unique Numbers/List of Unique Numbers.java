import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static long ret = 0;

    public static void main(String[] args)  throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        boolean[] visited = new boolean[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }


        int s = 0, e = 0;

        while (e < N) {
            if (!visited[ar[e]]) {
                visited[ar[e]] = true;
                e++;
            } else {
                ret +=e - s;
                visited[ar[s]] = false;
                s++;
            }
        }
       ret+=((long) (e - s + 1) *(e-s))/2;

        System.out.println(ret);
    }
}
