import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<N;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){ //이전
                if (seq[j]<seq[i] && dp[j]>=dp[i]) dp[i]=dp[j]+1;
            }
        }
        
        int ret=0;
        for (int i=0;i<N;i++) ret=Math.max(ret,dp[i]);
        System.out.println(ret);
    }
}
