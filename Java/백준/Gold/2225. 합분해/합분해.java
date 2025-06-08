import java.util.*;

public class Main {
    static int N,K;
    static int mod = 1000000000;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();

        int[][] dp=new int[K+1][N+1];
       dp[0][0]=1;
       for (int i=1;i<=K;i++){
           for (int j=0;j<=N;j++){
               dp[i][j]=dp[i-1][j];
               if (j-1>=0) dp[i][j]+=dp[i][j-1];

               dp[i][j]%=mod;
           }
           
       }

        System.out.println(dp[K][N]);

    }
}
