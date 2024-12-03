import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] psum = new int[n + 1]; // 누적 합 배열
        int ret = Integer.MIN_VALUE; // 최댓값 초기화
        
        String[] rawInput=br.readLine().split(" ");
        
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(rawInput[i-1]);
            psum[i] = psum[i - 1] + temp;
        }
        for (int i = k; i <= n; i++) {
            ret = Math.max(ret, psum[i] - psum[i - k]);
        }

        System.out.println(ret);
    }
}