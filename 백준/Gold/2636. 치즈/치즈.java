import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int N,M;
    static int ret1,ret2;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static List<int[]> cheese=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        graph=new int[N][M];
        visited=new boolean[N][M];

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                graph[i][j]=sc.nextInt();
            }
        }

        while (true){
            boolean allZero=true;
            //모두 0이면 break
            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if (graph[i][j]==1) allZero=false;
                }
            }
            if (allZero) break;

            cheese.clear();
            //0인 부분에서 dfs
            for (int i=0;i< visited.length;i++){
                Arrays.fill(visited[i],false);
            }
            go(0,0);

            for (int[] c:cheese){
                graph[c[0]][c[1]]=0;
            }
            //시간을 더한다
            ret1++;
            //남아있는 치즈개수를 구한다
            ret2=cheese.size();
        }

       System.out.println(ret1);
        System.out.println(ret2);
    }

    static void go(int i,int j){
       visited[i][j]=true;
        if (graph[i][j]==1){
            cheese.add(new int[]{i,j});
            return;
        }
        for (int k=0;k<4;k++){
            int nx=i+dx[k];
            int ny=j+dy[k];

            if (nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) continue;
            go(nx,ny);
        }

    }
}
