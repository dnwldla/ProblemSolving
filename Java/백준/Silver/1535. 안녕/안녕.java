import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();

        int[] loss=new int[N+1];
        int[] gain=new int[N+1];

        for (int i=1;i<=N;i++)
            loss[i]=sc.nextInt();


        for (int i=1;i<=N;i++) gain[i]=sc.nextInt();

        int[] dp=new int[101];

        for (int i=1;i<=N;i++){
            for (int j=99;j>=loss[i];j--){ //최대손실
                dp[j]=Math.max(dp[j],dp[j-loss[i]]+gain[i]);
            }
        }
        System.out.println(dp[99]);

    }
}
