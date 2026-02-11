import java.util.*;

/**
 tc
 3 3 1
 0 30 7
 -1 10 0
 -1 0 20
 */
public class Main {
    //index는 0부터
    static int N,M,T;
    static int[][] graph;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int first=-1; // 공기청정기 시작 행
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt(); M=sc.nextInt(); T=sc.nextInt();
        graph=new int[N][M];

        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                graph[i][j]=sc.nextInt();
                if (first==-1 &&graph[i][j]==-1){
                    first=i;
                }
            }
        }

        for (int i=0;i<T;i++){
            int[][] tmp=diffuse();
            //그래프를 업데이트 한다
            updateGraph(tmp);
            //그래프를 d
            rotate(true);
            rotate(false);
           // print(graph);
        }

        //합을 구한다
        int ret=0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (graph[i][j]!=-1){
                    ret+=graph[i][j];
                }
            }
        }
        System.out.println(ret);




    }

    static void rotate(boolean hi){
        //덱을 만든다
        ArrayDeque<Integer> q=new ArrayDeque<>();

        //->: 행 고정
        int x1=hi?0:first+1;
        int y1=hi?0:1;
        for (int i=y1;i<=M-2;i++){
            q.add(graph[x1][i]);
        }

        //하: 열이 M-1로 고정
        int s1=hi?0:first+1;
        int e1=hi?first-1:N-2;
        for (int i=s1;i<=e1;i++){
            q.add(graph[i][M-1]);
        }

        //<-: 행이 first로 고정 & -1은 제외
        int x2=hi?first:N-1;
        for (int i=M-1;i>=1;i--){
            q.add(graph[x2][i]);
        }


        //상: 열이 0으로 고정
        int s2=hi?first-1:N-1;
        int e2=hi?1:first+2;
        for (int i=s2;i>=e2;i--){
            q.add(graph[i][0]);
        }

        if (hi){
            q.add(q.pollFirst());
        }else{
            q.addFirst(q.pollLast());
        }

//        다시 대입:
        for (int i=y1;i<=M-2;i++){
            graph[x1][i]=q.pollFirst();
        }

        for (int i=s1;i<=e1;i++){
            graph[i][M-1]=q.pollFirst();
        }

        for (int i=M-1;i>=1;i--){
            graph[x2][i]=q.pollFirst();
        }

        for (int i=s2;i>=e2;i--){
            graph[i][0]=q.pollFirst();
        }

        if (hi) graph[first][1]=0;
        else graph[first+1][1]=0;




    }

    //확산-> return tmp
    static int[][] diffuse(){
        int[][] tmp=new int[N][M];

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                int cnt=0;
                //미세먼지가 없다면 확산되지 않는다
                if (graph[i][j]==0|| graph[i][j]==-1) continue;

                for (int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];

                    if (outOfRange(nx,ny)) continue;
                    if (isAir(nx,ny)) continue;

                    tmp[nx][ny]+=graph[i][j]/5; cnt++;
                }
                tmp[i][j]-=graph[i][j]/5*cnt;
            }
        }
        return tmp;


    }

    static void updateGraph(int[][] tmp){
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                graph[i][j]+=tmp[i][j];
            }
        }
    }

    static boolean outOfRange(int x,int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
    //공기청정기 영역
    static boolean isAir(int x,int y){
       return graph[x][y]==-1;
    }

    static void print(int[][] map){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
