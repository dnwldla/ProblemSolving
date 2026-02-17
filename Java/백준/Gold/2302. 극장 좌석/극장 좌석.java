import java.util.Scanner;

public class Main {
    static int N,M;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();

        int[] ar=new int[N+1];
        int[] dp=new int[N+1];

        for (int i=0;i<M;i++){
            int k=sc.nextInt();
            ar[k]=1;
        }
        int cmp=0; //기준
        for (int i=1;i<=N;i++){
            //1이면 초기화 & continue
            //diff가 3 이상이면 더하기 가능
            if (ar[i]==1){
                cmp=i;
                continue;
            }

            if (i-cmp==1){
                dp[i]=1;
            }else if (i-cmp==2){
                dp[i]=2;
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }



        }
        int ret=1;

        for (int i=2;i<=N;i++){
            int cur=dp[i];
            int bf=dp[i-1];

            if (cur==0 && bf!=0){
                ret*=bf;
            }
        }
        if (dp[N]!=0) ret*=dp[N];
        System.out.println(ret);
    }

}
