import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N,K;
        int INF=500001;
        int[][] visited=new int[INF][2];
        int[] dx={1,-1,2};
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); K = in.nextInt();
        if (N==K){
            System.out.println(0);
            return;
        }

        Queue<Integer> q=new LinkedList<>();
        q.add(N);
        int cnt=1;
        int ret=-1;

        while (!q.isEmpty()){
            int qSize=q.size();
            while (qSize>0){
                int curX=q.poll();
                if (K>=INF) break;
                if (visited[K][(cnt+1)%2]!=0 && visited[K][(cnt+1)%2]!=cnt%2){
                    ret=cnt-1;
                    break;
                }
                qSize--;
                int nx;
                for (int i=0;i<3;i++){
                    if (i==2) nx=curX*2;
                    else nx=curX+dx[i];

                    if (nx>=INF || nx<0) continue;
                    if (visited[nx][cnt%2]!=0) continue;

                    visited[nx][cnt%2]=visited[curX][(cnt+1)%2]+1;
                    q.add(nx);
                }
            }
            if (ret!=-1) break;
            if (K>=INF) break;
            K+=cnt;
            cnt++;
        }
        System.out.println(ret);

    }
}
