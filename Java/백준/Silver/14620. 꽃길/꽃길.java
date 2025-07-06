import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main{
    static int ans=Integer.MAX_VALUE;
    static int N;
    static int[][] graph=new int[11][11];
    static boolean[][] visited=new boolean[11][11];
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};

    static class Pair{
        int x;int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    static int check() {
        boolean oor=false;
        HashSet<Pair> set=new HashSet<>();
        int tot=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    set.add(new Pair(i,j));
                    tot+=graph[i][j];
                    for (int k=0;k<4;k++){
                        int nx=i+dx[k];
                        int ny=j+dy[k];

                        if (nx<0 || ny<0 || nx>=N || ny>=N){
                            oor=true;
                            break;
                        }
                        set.add(new Pair(nx,ny));
                        tot+=graph[nx][ny];
                    }
                }
                if (oor) break;
            }
            if (oor) break;
        }

        if (set.size()!=15) return -1;
        if (oor) return -1;
        return tot;

    }



    static void go(int cnt){
        if (cnt==3){
            int ret=check(); //겹치는 원소가 있는지 check
            if (ret!=-1){
                ans=Math.min(ans,ret);
            }
            return;
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
               if (!visited[i][j]){
                   visited[i][j]=true;
                   go(cnt+1);
                   visited[i][j]=false;

               }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                graph[i][j]=sc.nextInt();
            }
        }

        go(0);
        System.out.println(ans);
    }
}
