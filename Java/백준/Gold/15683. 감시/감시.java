import java.util.*;
import java.io.*;

//0부터
public class Main {
    //상부터 시계방향
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static List<int[]> cctvs=new ArrayList<>();
    static int N,M;
    static int[][] ar;
    static int ret=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        ar=new int[N][M]; //행, 열
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                ar[i][j]=Integer.parseInt(st.nextToken());
                if (ar[i][j]>=1 && ar[i][j]<=5){
                    cctvs.add(new int[]{i,j});
                }
            }
        }
        dfs(0);
        System.out.println(ret);


    }

    static void dfs(int here){

        if (here==cctvs.size()){
            int cnt=0;
            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if (ar[i][j]==0) cnt++;
                }
            }

            ret=Math.min(cnt,ret);
            return;
        }

        for (int k=0;k<4;k++){
            List<int[]> changed=extendCCTV(here,k);
            dfs(here+1);
            for (int[] p:changed)ar[p[0]][p[1]]=0;
        }
    }

    static List<int[]> extendCCTV(int here,int dir){
        List<int[]> changed=new ArrayList<>();
        int x=cctvs.get(here)[0];
        int y=cctvs.get(here)[1];
        int type=ar[x][y];

        if (type==1){
            mark(x,y,dir,changed);
        }else if (type==2){
            mark(x,y,dir,changed);
            mark(x,y,(dir+2)%4,changed);
        }else if (type==3){
            mark(x,y,dir,changed);
            mark(x,y,(dir+1)%4,changed);
        }else if (type==4){
            mark(x, y, dir, changed);
            mark(x, y, (dir + 1) % 4, changed);
            mark(x, y, (dir + 2) % 4, changed);
        }else if (type==5){
            mark(x, y, 0, changed);
            mark(x, y, 1, changed);
            mark(x, y, 2, changed);
            mark(x, y, 3, changed);
        }
        return changed;
    }

    static void mark(int sx,int sy,int dir,List<int[]> changed){
        int nx=sx,ny=sy;

        while (true){
            nx+=dx[dir];
            ny+=dy[dir];
            if (nx<0 || nx>=N || ny<0 || ny>=M) break;
            if (ar[nx][ny]==6) break;
            if (ar[nx][ny]==0){
                ar[nx][ny]=8; //벽 표시
                changed.add(new int[]{nx,ny});
            }
        }
    }

}
