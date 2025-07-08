import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        int M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());
        int[] cnt = new int[21];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] ar = line.split(" ");
            String ins = ar[0];
            int num = 0;

            if (ar.length == 2) {
                num = Integer.parseInt(ar[1]);
            }

            if (ins.equals("add")) {
                cnt[num] = 1;
            } else if (ins.equals("remove")) {
                cnt[num] = 0;
            } else if (ins.equals("check")) {
                sb.append(cnt[num]).append('\n');
            } else if (ins.equals("toggle")) {
                if (cnt[num] == 1) cnt[num] = 0;
                else cnt[num] = 1;
            } else if (ins.equals("all")) {
                for (int j = 1; j <= 20; j++) cnt[j] = 1;
            } else if (ins.equals("empty")) {
                for (int j = 1; j <= 20; j++) cnt[j] = 0;
            }
        }

        System.out.print(sb);
    }
}
