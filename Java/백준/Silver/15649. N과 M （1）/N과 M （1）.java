import java.util.*;

public class Main {
    static int N,M;
    static boolean[] visited;
    static List<Integer> ar=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt(); M=sc.nextInt();
       visited=new boolean[N+1];

        for (int i=1;i<=N;i++){
            go(i,1);
            ar.remove(ar.size()-1);
        }
    }

    static void go(int cur,int cnt){
        ar.add(cur);
        visited[cur]=true;
        if (cnt==M){
            for (Integer a:ar){
                System.out.print(a+" ");
            }
            System.out.println();
        }

        for (int i=1;i<=N;i++){
            if (i==cur) continue;
            if (visited[i]) continue;
            go(i,cnt+1);
            ar.remove(ar.size()-1);

        }
        visited[cur]=false;

    }
}
