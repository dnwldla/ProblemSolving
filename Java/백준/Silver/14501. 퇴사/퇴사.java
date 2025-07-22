import java.util.Scanner;

public class Main {
    static int[] T;
    static int[] P;
    static int N,ret;
    public static void main(String[] args) {
        ret=0;
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        T=new int[N+1];
        P=new int[N+1];
        for (int i=0;i<N;i++){
            T[i]=sc.nextInt(); P[i]=sc.nextInt();
        }
        dfs(0,0);
        System.out.println(ret);

    }

    static void dfs(int idx,int tot){
        //base case
        if (idx>=N){
            ret=Math.max(ret,tot);
            return;
        }

        //상담했을 떄
        if (idx+T[idx]<=N){
            dfs(idx+T[idx],tot+P[idx]);
        }
        //상담하지 않을 때
        dfs(idx+1,tot);
    }
}
