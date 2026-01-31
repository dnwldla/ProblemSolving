import java.util.*;

public class Main {
    static int N,M,X;
    static List<Integer>[] graph;
    static List<Integer>[] graph2;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); M=sc.nextInt(); X=sc.nextInt();

        graph=new List[N+1]; graph2=new List[N+1];
        for (int i=1;i<=N;i++){
            graph[i]=new ArrayList<>();
            graph2[i]=new ArrayList<>();
        }

        for (int i=1;i<=M;i++){
            int from=sc.nextInt(); int to=sc.nextInt();

            graph[from].add(to);
            graph2[to].add(from);
        }
        int min=go(X,graph);
        int max=go(X,graph2);

        System.out.printf("%d %d",max+1,N-min);




    }

    static int go(int x,List<Integer>[] g){
        visited=new boolean[N+1];
        Queue<Integer> q=new LinkedList<>();
        int cnt=0;

        q.add(x); visited[x]=true;

        while (!q.isEmpty()){
            int cur=q.poll();

            for (int next:g[cur]){
                if (!visited[next]){
                    visited[next]=true;
                    cnt++;
                    q.add(next);

                }
            }

        }
        return cnt;
    }



}

