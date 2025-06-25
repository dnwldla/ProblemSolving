import java.util.Scanner;

public class Main {
    static final int INF=987654321;
    static int n,m,h,a,b,ret=INF;
    static int[][] visited=new int[34][34];

    //전체가 다
    static boolean check(){
        for (int i=1;i<=n;i++){ //1번부터 n번
            int end=i;
            for (int j=1;j<=h;j++){

                if (visited[j][end]==1) end++; //오른쪽으로 이동
                else if (visited[j][end-1]==1) end--; //왼쪽으로 이동
                //아무것도 아니라면 아래로 이동
            }
            if (end!=i) return false;

        }return true;
    }

    public static void go(int here,int cnt){
        if (cnt>3 || cnt>=ret) return;

        if (check()){
            ret=Math.min(ret,cnt); return;
        }

        for (int i=here;i<=h;i++){ //가로선
            for (int j=1;j<n;j++){ //세로선
                if (visited[i][j]==1 || visited[i][j-1]==1 ||visited[i][j+1]==1)  continue;

                visited[i][j]=1;
                go(i,cnt+1);
                visited[i][j]=0;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h=sc.nextInt();

        for (int i=0;i<m;i++){
            a=sc.nextInt();//a에서 연결
            b=sc.nextInt(); //세로선
            visited[a][b]=1;
        }

        go(1,0);
        if (ret==INF) ret=-1;
        System.out.println(ret);
    }
}
