import java.util.*;

public class Main {
    static int N,M;
    static char[][] graph;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        graph=new char[N][M];

        for (int i=0;i<N;i++){
            String row=sc.next();
            for (int j=0;j<M;j++){
                graph[i][j]=row.charAt(j);
            }
        }
        int ret=-1;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (graph[i][j]=='L'){
                    ret=Math.max(ret,bfs(i,j));
                }
            }
        }
        System.out.println(ret);
    }

    static int bfs(int x,int y){
        int[][] visited=new int[N][M];
        Queue<int[]> queue=new LinkedList<>();
        for (int i=0;i<visited.length;i++){
            Arrays.fill(visited[i],-1);
        }
        visited[x][y]=0;
        queue.add(new int[]{x,y});
        int ret=-1;
        while (!queue.isEmpty()){
            int[] ar=queue.poll();
            int x1=ar[0];
            int y1=ar[1];
            ret=Math.max(ret,visited[x1][y1]);
            for (int i=0;i<4;i++){
                int nx=x1+dx[i];
                int ny=y1+dy[i];

                if (nx<0 || nx>=N || ny<0 ||ny>=M) continue;
                if (graph[nx][ny]=='W') continue;
                if (visited[nx][ny]!=-1) continue;

                queue.add(new int[]{nx,ny});
                visited[nx][ny]=visited[x1][y1]+1;
            }
        }
        return ret;
    }

}
