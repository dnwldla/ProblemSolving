import java.util.*;

//(1,1) 부터 시작
public class Main{
    //M개의 정수
    static int N,M,T,cnt;
    static int[][] ar;
    static int[] dx={0,0,1,-1};
    static int[] dy={-1,1,0,0};
    static boolean flag=false;
    static boolean[][] visited;
    static List<int[]> change=new ArrayList<>();
    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M=sc.nextInt(); T=sc.nextInt();
        cnt=N*M;

        //회전 입력
        ar=new int[N+1][M+1];
        for (int i=1;i<=N;i++){
            for (int j=1;j<=M;j++){
                ar[i][j]=sc.nextInt();
            }
        }

        //T개 줄에 x,d,k
        for (int i=0;i<T;i++){
            int x,d,k;
            x=sc.nextInt(); d=sc.nextInt(); k=sc.nextInt();
            visited=new boolean[N+1][M+1];

            //x의 배수를 d방향으로 k칸 회전 ->N까지 가능
            int tmp=1;
            //회전한다
            while (true){
                if (x*tmp>N) break;
                rotate(x*tmp,d,k%M);
                tmp++;
//                for (int p=1;p<=N;p++){
//                    for (int q=1;q<=M;q++){
//                        System.out.printf(ar[p][q]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("rotate end");
                //인접하면서 같은 수가 있는걸 찾느다

            }
            //회전 끝
//            System.out.println("rotate end range");
//            for (int p=1;p<=N;p++){
//                for (int q=1;q<=M;q++){
//                    System.out.printf(ar[p][q]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("one rotate end");
            flag=false;
            //인접한 점 체크
            for (int p=1;p<=N;p++){
                for (int q=1;q<=M;q++){
                    if (ar[p][q]==0 || visited[p][q]) continue;
                    dfs(p,q);
                    for (int[] c:change) ar[c[0]][c[1]]=0;
                    change=new ArrayList<>();

                }
            }

            if (flag==false){
                double avg=getAvg();
                update(avg);
            }
//            System.out.println("cycle end start");
//           // 한 사이클이 끝난 후 후 원판 상태
//            for (int p=1;p<=N;p++){
//                for (int q=1;q<=M;q++){
//                    System.out.printf(ar[p][q]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("cycle end end");
        }
        int ret=0;
        for (int i=1;i<=N;i++){
            for (int j=1;j<=M;j++){
                ret+=ar[i][j];
            }
        }
        System.out.println(ret);


    }

    static void update(double avg){
        for (int i=1;i<=N;i++){
            for (int j=1;j<=M;j++){
                if (ar[i][j]==0) continue;
                else if (avg<(double)ar[i][j]) ar[i][j]-=1;
                else if (avg>(double)ar[i][j]) ar[i][j]+=1;
            }
        }
    }

    static double getAvg(){
        double tot=0;
        int cnt=0;
        for (int i=1;i<=N;i++){
            for (int j=1;j<=M;j++){
                if (ar[i][j]!=0) cnt++;
                tot+=ar[i][j];
            }
        }
        return tot/(double)cnt;
    }

    static void dfs(int x,int y){
        //baseCase
        if (ar[x][y]==0) return;
        for (int i=0;i<4;i++){
            int nx=x+dx[i],ny=y+dy[i];
            //열 보정
            if (ny==0) ny=M; if (ny==M+1) ny=1;
            if (nx<=0 || nx>N) continue;
            if (ar[x][y]==ar[nx][ny] && ar[x][y]!=0 && !visited[nx][ny]){
                if (!visited[x][y]) change.add(new int[]{x,y});
                change.add(new int[]{nx,ny});
                visited[nx][ny]=true; if (!visited[x][y]) visited[x][y]=true;

                flag=true;
                dfs(nx,ny);
            }
        }
    }
    //
    static void rotate(int x,int d,int k){
       int[] tmp=new int[M+1];
       int idx=0;
        if (d==0){//시계방향 회전
            for (int i=1;i<=M;i++){
                idx=(i+k)%M;
                if (idx==0) idx=M;
                tmp[idx]=ar[x][i];
            }
        }else{
            for (int i=1;i<=M;i++){
                idx=(i+M-k)%M;
                if (idx==0) idx=M;
                tmp[idx]=ar[x][i];
            }
        }
        //원복
        for (int i=1;i<=M;i++){
            ar[x][i]=tmp[i];
        }

    }
}
