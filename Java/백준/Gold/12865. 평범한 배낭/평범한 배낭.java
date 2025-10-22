import java.util.Scanner;

public class Main {
    static int N,K;
    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt(); K=sc.nextInt();

        int w,v;
        int[] dp=new int[100001];

        while (N>0){
            //최소무게까지
            w=sc.nextInt(); v=sc.nextInt(); //무게, 가치
            for (int j=K;j>=w;j--){
                dp[j]=Math.max(dp[j],dp[j-w]+v);
            }
            N--;
        }
         System.out.println(dp[K]);

    }

}

