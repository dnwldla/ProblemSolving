import java.util.*;

public class Main {
    static int N;
    static char[][] ar;
    static boolean[][] visited;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();

        ar=new char[N][N];
        visited=new boolean[N][N];

        //입력
        for (int i=0;i<N;i++){
            String s=sc.next();
            for (int j=0;j<N;j++){
                ar[i][j]=s.charAt(j);
            }
        }

        //bfs
        List<Integer> ret=new ArrayList<>();
        int cnt=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                //방문하지 않고 1이라면 bfs를 돌린다
                //int를 return하고 list에 add하다
                if (!visited[i][j] && ar[i][j]=='1'){
                    visited[i][j]=true;
                    ret.add(bfs(i,j));
                    cnt++;

                }

            }
        }

        Collections.sort(ret);
        StringBuilder sb=new StringBuilder();
        
        for (Integer r:ret) sb.append(r).append("\n");
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    static int bfs(int x,int y){
        int ret=1;
        visited[x][y]=true;
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if (outOfRange(nx,ny)) continue;
            if (visited[nx][ny]) continue;
            if (ar[nx][ny]!='1') continue;

            ret+=bfs(nx,ny);
        }
        return ret;
    }

    static boolean outOfRange(int x,int y){
        return x<0 || x>=N || y<0 || y>=N;
    }
}
