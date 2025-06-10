import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        int[][] dist=new int[N][3];
        int[][] dp=new int[N][3];
        for (int i=0;i<N;i++){
            for (int j=0;j<3;j++){
                dist[i][j]=sc.nextInt();
            }
        }
        int ans=1000*1000+1;
        for (int k=0;k<=2;k++){

            for (int j=0;j<=2;j++){ //첫번째
                if (j==k) dp[0][j]=dist[0][j];
                else dp[0][j]=1000*1000+1;
            }

            for (int i=1;i<N;i++){
                dp[i][0]=Math.min(dp[i-1][2],dp[i-1][1])+dist[i][0];
                dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+dist[i][1];
                dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+dist[i][2];
            }

            for (int j=0;j<=2;j++){
                if (j==k) continue;
                ans=Math.min(ans,dp[N-1][j]);

            }

        }

        System.out.println(ans);





    }
}
