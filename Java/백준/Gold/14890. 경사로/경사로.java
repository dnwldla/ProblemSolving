import java.util.*;

public class Main {
    static int N,L;
    static int[][] map;
    static int[][] map2;
    static int ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        ret=0;
        map = new int[N][N];
        map2=new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                map2[j][i]=map[i][j];
            }
        }
        
        go(map); go(map2);
        System.out.println(ret);



    }

    static void go(int[][] graph){
       for (int i=0;i<N;i++){
           int cnt=1;
           int j=0;
           for (j=0;j<N-1;j++){
               //같다면
               if (graph[i][j]==graph[i][j+1]) cnt++;

               //오르막
               else if (graph[i][j]+1==graph[i][j+1] && cnt>=L) cnt=1;
               //내리막
               else if (graph[i][j]-1==graph[i][j+1] &&cnt>=0) cnt=-L+1;
               else break;
           }

           //끝까지 왔다는 걸 증명
           if (j==N-1 && cnt>=0) ret++;

        }
    }



}
