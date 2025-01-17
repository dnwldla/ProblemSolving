import java.util.*;

public class Main {
    static int N,del,root;
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        graph=new List[N+1];
        visited=new boolean[N+1];
        for (int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        for (int i=0;i<N;i++){
            //i번째가 -1이라면 continue
            //else graph[sc].add(i)
            int k=sc.nextInt();
            if (k==-1){
                root=i;
                continue;
            }
            graph[k].add(i);
        }
        del=sc.nextInt();

        System.out.println(dfs(root));


    }
    static int dfs(int idx){
        int child=0;
        int ret=0;
        if (idx==del) return ret;

        for (int there:graph[idx]){
            if (there==del) continue;
            ret+=dfs(there);
            child++;
        }
        if (child==0) return 1;
        return ret;
    }
}
