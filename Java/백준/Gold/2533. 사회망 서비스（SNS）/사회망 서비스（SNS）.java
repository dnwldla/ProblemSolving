import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.valueOf(br.readLine());
        dp=new int[N+1][2];
        graph=new ArrayList[N+1];
        visited=new boolean[N+1];
        for (int i=1;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.valueOf(st.nextToken());
            int end=Integer.valueOf(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);

        }
        dfs(1);

        System.out.print(Math.min(dp[1][0],dp[1][1]));



    }

    static void dfs(int parent){
        visited[parent]=true;
        //0은 early adapter, 1은 early가 아님
        dp[parent][0]=1;
        dp[parent][1]=0;

        for (int child:graph[parent]){
            if (!visited[child]){
                dfs(child);
                //부모가 early면 no matter
                dp[parent][0]+=Math.min(dp[child][0],dp[child][1]);
                //부모가 early가 아니면 자식은 early이어야 한다
                dp[parent][1]+=dp[child][0];
            }



        }
    }
}