import java.util.*;

public class Main {
    static int N;
    static int min,max;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};
    static List<int[]> union=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        min=sc.nextInt();
        max=sc.nextInt();

        graph=new int[N][N];
        visited=new boolean[N][N];

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                graph[i][j]=sc.nextInt();
            }
        }
        int cnt=0;
        while (true){
            int flag=0;
            for (int i=0;i<visited.length;i++){
                Arrays.fill(visited[i],false);
            }
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    if (!visited[i][j]){
                        int ret=dfs(i,j); //합을 구한다
                        if (ret!=graph[i][j]){
                            flag++;
                            //union을 update한다
                            int num=union.size();
                            ret/=num;
                            for (int[] c:union){
                                graph[c[0]][c[1]]=ret;
                            }
                        }
                        union.clear();
                    }
                }
            }
            if (flag==0) break;
            cnt++;
        }
        System.out.println(cnt);
    }

    static int dfs(int x,int y){
        int ret=graph[x][y];
        union.add(new int[]{x,y});
        visited[x][y]=true;
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if (nx<0 || nx>=N || ny<0 ||ny>=N) continue;

            int dist=Math.abs(graph[x][y]-graph[nx][ny]);
            if (dist<min || dist>max) continue;
            if (visited[nx][ny]) continue;

            ret+=dfs(nx,ny);
        }
        return ret;
    }
}
