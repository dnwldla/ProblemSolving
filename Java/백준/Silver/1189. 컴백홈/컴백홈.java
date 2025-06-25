import java.util.Scanner;

public class Main {

    static void go(int row,int col,int cnt){
        if (row==0 && col==C-1){
            if (cnt==K){
                ret++;
                return;
            }
        }

        for (int i=0;i<4;i++){
            int nx=row+dx[i]; int ny=col+dy[i];

            if (nx<0 || nx>=R || ny<0 || ny>=C)continue;
            if (graph[nx][ny]=='T') continue;
            if (visited[nx][ny])continue;

            visited[nx][ny] = true;
            go(nx,ny,cnt+1);
            visited[nx][ny] = false;
        }

    }
    static int R,C,K,ret;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static char[][] graph=new char[6][6];
    static boolean[][] visited=new boolean[6][6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt(); C=sc.nextInt(); K= sc.nextInt();

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                graph[i][j]=s.charAt(j);
            }
        }

        visited[R-1][0]=true;
        go(R-1,0,1);
        System.out.println(ret);
    }
}
