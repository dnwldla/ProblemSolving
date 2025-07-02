import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    static int N;
    static int[] person=new int[11];
    static List<Integer>[] graph=new List[11];
    static int[] comp=new int[11];
    static boolean[] visited=new boolean[11];
    static int result = INF;
    public static void main(String[] args) {

        //입력
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for (int i=1;i<=N;i++){
            person[i]=sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=1;i<=N;i++){
            int M;
            M=sc.nextInt();
            for (int j=0;j<M;j++){
                graph[i].add(sc.nextInt());
            }
        }

        for (int i=1;i<(1<<N)-1;i++){
            int idx1=-1,idx2=-1;
            Arrays.fill(comp,0);
            Arrays.fill(visited,false);
            for (int j=0;j<N;j++){
                //구역 1이라면
                if ((i&(1<<j))>0){
                    idx1=j+1;
                    comp[j+1]=1;
                }else{
                    idx2=j+1;
                }
            }

            Pair p1=go(idx1,1);
            Pair p2=go(idx2,0);
            
            if (p1.cnt+p2.cnt==N){
                result=Math.min(result,Math.abs(p1.people-p2.people));
            }
        }

        if (result==INF) System.out.println(-1);
        else System.out.println(result);
    }

    static Pair go(int idx,int flag){
        Pair pair=new Pair(1,person[idx]);
        visited[idx]=true;

        for (int there:graph[idx]){
            if (comp[there]!=flag) continue;
            if (visited[there]) continue;

            Pair future=go(there,flag);
            pair.people+=future.people;
            pair.cnt+=future.cnt;
        }
        return pair;
    }

    static class Pair{
        int cnt;
        int people;

        public Pair(int cnt,int people){
            this.cnt=cnt;
            this.people=people;
        }
    }
}
