import java.util.*;

public class Main {
    static int MOD=9901;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();

        int[][] dp=new int[N][3];
        dp[0][0]=1;dp[0][1]=1;dp[0][2]=1;

        if (N==1){
            System.out.println(dp[0][0]+dp[0][1]+dp[0][2]);
            return;
        }

        for (int i=1;i<N;i++){
            dp[i][0]=(dp[i-1][1]+dp[i-1][2])%MOD;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%MOD;
            dp[i][2]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%MOD;

        }
        System.out.println((dp[N-1][0]+dp[N-1][1]+dp[N-1][2])%MOD);



    }
}
