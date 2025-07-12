import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T,N,M;
    static boolean[] visited;
    static List<Integer>[] ar;

    static int dfs(int cur){
        int ret=1;
        for (int next:ar[cur]){
            if (!visited[next]){
                visited[next]=true;
                ret+=dfs(next);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());

        for(int j=0;j<T;j++){

            StringTokenizer st;
            N=Integer.parseInt(br.readLine()); //노드 개수
            M=Integer.parseInt(br.readLine()); //간선 개수
            visited=new boolean[N+1];

            ar = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                ar[i] = new ArrayList<>();
            }
            for (int i=0;i<M;i++){
                st=new StringTokenizer(br.readLine()," ");
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                ar[a].add(b);
                ar[b].add(a);

            }

            visited[1]=true;
            int ret=dfs(1);

            if (ret!=N|| N-M!=1) System.out.println("graph");
            else System.out.println("tree");

        }
    }
}
