import java.util.Scanner;

public class Main {
    static int n;
    static long ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[]ar=new int[n+1];
        long[] dp=new long[n+1];

        for (int i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }
        dp[0]=ar[0];
        ret=dp[0];
        for (int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+ar[i],ar[i]);
            ret=Math.max(ret,dp[i]);
        }

        System.out.println(ret);


    }
}
