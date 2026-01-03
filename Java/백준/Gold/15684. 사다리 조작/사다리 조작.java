import java.util.Scanner;

//index는 1부터
public class Main {
    static int N,M,H,Y,ans,size;
    static boolean[][] visited,visited2;
    static int[] dx={0,0,1};
    static int[] dy={1,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt(); M=sc.nextInt(); H=sc.nextInt();
        visited=new boolean[H+1][N+1];
        visited2=new boolean[H+1][N+1];

        ans=-1;

        for (int i=0;i<M;i++){
            int a,b;
            a=sc.nextInt();b=sc.nextInt();
            visited[a][b]=true;
        }

        for (int i=0;i<=3;i++){
            go(0,i,1,1);
            if (ans!=-1) break;
        }
        System.out.println(ans);


    }

    static boolean check(){
        for (int i=1;i<=N;i++){ //1번부터 n번
            int end=i;
            for (int j=1;j<=H;j++){

                if (visited[j][end]) end++; //오른쪽으로 이동
                else if (visited[j][end-1]) end--; //왼쪽으로 이동
                //아무것도 아니라면 아래로 이동
            }
            if (end!=i) return false;

        }return true;
    }


    //조합 구하기
    static void go(int cnt,int tot,int x,int y){
        if (y==N){
            go(cnt,tot,x+1,1);
            return;
        }

        if (cnt==tot){
            if (check()){ //모두 도달 가능하면 그 즉시 탈출
                ans=cnt;
            }
            return;
        }
        //base case
        if (x==H+1){
            return;
        }

        //자신을 선택
        if (!visited[x][y] && only(x,y)){
            visited[x][y]=true;
            go(cnt+1,tot,x,y+1);
            visited[x][y]=false;
        }
        //자신을 선택하지 않음
        go(cnt,tot,x,y+1);


    }

    //밑으로 내려간다
    static boolean only(int x,int y){
        int nx1=x,ny1=y+1;
        int nx2=x,ny2=y-1;

        if (!visited[nx1][ny1] && !visited[nx2][ny2]){
            return true;
        }
        return false;
    }

}
