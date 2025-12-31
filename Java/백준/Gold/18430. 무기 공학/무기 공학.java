import java.util.Scanner;

public class Main {
    static int N,M;
    static int[][] ar;
    static int ret,ans;
    static boolean[][] visited;
    //index 0,2는 dx, 1,3은 dy
    static int[][] D={
        {0,-1,1,0},
        {-1,0,0,-1},
        {-1,0,0,1},
        {1,0,0,1}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M=sc.nextInt();
        ar=new int[N][M];
        visited=new boolean[N][M];

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                ar[i][j]=sc.nextInt();
            }
        }
        go(0,0);
        System.out.println(ans);
    }

    static void go(int x,int y){
        if(y==M){
            go(x+1,0);
            return;
        }
        if(x==N){
            ans=Math.max(ans,ret);
            return;
        }
        for(int[] d:D){
            if(outOfRange(x,y,d)) continue;
            if(visit(x,y,d)) continue;
            int nx1=x+d[0],ny1=y+d[1];
            int nx2=x+d[2],ny2=y+d[3];
            int tmp=ar[x][y]*2+ar[nx1][ny1]+ar[nx2][ny2];
            visited[x][y]=true;visited[nx1][ny1]=true;visited[nx2][ny2]=true;
            ret+=tmp;
            go(x,y+1);
            ret-=tmp;visited[x][y]=false;visited[nx1][ny1]=false;visited[nx2][ny2]=false;
        }
        go(x,y+1);
    }


    static boolean outOfRange(int x,int y,int[] d){
        int nx1=x+d[0],ny1=y+d[1];
        int nx2=x+d[2],ny2=y+d[3];

        return nx1<0 || nx1>=N || ny1<0 || ny1>=M || nx2<0 || nx2>=N || ny2<0 || ny2>=M;
    }

    static boolean visit(int x,int y,int[] d){
        int nx1=x+d[0],ny1=y+d[1];
        int nx2=x+d[2],ny2=y+d[3];

        return visited[x][y] || visited[nx1][ny1] || visited[nx2][ny2];
    }

}
