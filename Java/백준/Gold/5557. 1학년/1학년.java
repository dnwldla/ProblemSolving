import java.util.Scanner;

public class Main {
    static int N,ret;
    static int[] ar;
    static long[][] dp=new long[101][21];
    static long go(int cur,int tot){
        //baseCase
        if (cur==N-1){
            if (tot==ar[cur+1]) return 1;
            return 0;
        }
        //음수이거나 20초과일때 return
        if (tot<0 || tot>20) return 0;
        if (dp[cur][tot]!=0) return dp[cur][tot];

        //다음수를 더함
        dp[cur][tot]+=go(cur+1,tot+ar[cur+1]);
        //다음 수를 뺌
        dp[cur][tot]+=go(cur+1,tot-ar[cur+1]);

        return dp[cur][tot];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        ar=new int[N+1];
        for (int i=1;i<=N;i++) ar[i]=sc.nextInt();
        go(1,ar[1]);

        System.out.println(dp[1][ar[1]]);
    }
}
