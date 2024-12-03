import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String[] raw=br.readLine().split(" ");

            int N=Integer.parseInt(raw[0]);
            int K=Integer.parseInt(raw[1]);

            String[] rawNumbers=br.readLine().split(" ");
            int[] numbers=new int[rawNumbers.length+1];

            for (int i=1;i<=N;i++){
                numbers[i]=Integer.parseInt(rawNumbers[i-1]);
            }

            int[] dp=new int[N+1];

            for (int i=1;i<=N;i++){
                if (i<=K){
                    dp[i]=dp[i-1]+numbers[i];
                }else{
                    dp[i]=dp[i-1]+numbers[i]-numbers[i-K];
                }
            }

            int max=Integer.MIN_VALUE;
            for (int i=K;i<=N;i++){
                max=Math.max(max,dp[i]);
            }
            System.out.println(max);
    }
}