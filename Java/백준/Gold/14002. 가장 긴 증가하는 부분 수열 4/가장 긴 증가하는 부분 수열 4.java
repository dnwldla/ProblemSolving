import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dp = new int[N];
        int[] parent=new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<N;i++){
            dp[i]=1;
            parent[i]=-1;
        }
        ArrayList<Integer> ret=new ArrayList<>();
        for (int i=0;i<N;i++){ //기준
            for (int j=0;j<i;j++){
                //i번째가 j보다 seq가 크고 j번째보다 dp 값이 작다면 +1
                if (seq[i]>seq[j] && dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }
        }

        int ans=0;
        int root=0;
        for (int i=0;i<N;i++){
            if (ans<dp[i]){
                ans=dp[i];
                root=i;
            }
        }
        StringBuilder sb=new StringBuilder();
        while (root!=-1){
            ret.add(seq[root]);
            root=parent[root];
        }
        Collections.reverse(ret);
        for (Integer r:ret) sb.append(r).append(" ");
        //i번째 기준으로
        System.out.println(ans);
        System.out.println(sb.toString());

    }
}
