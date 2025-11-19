import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp=new int[N+1];
        int ret=0;
        for (int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            dp[num]=dp[num-1]+1;
            ret=Math.max(ret,dp[num]);
            
        }
        System.out.println(N-ret);
    }

}
