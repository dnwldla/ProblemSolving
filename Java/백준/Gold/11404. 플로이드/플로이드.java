import java.io.*;
import java.util.*;

public class Main{
    //overflow 조심!
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i=0;i<m;i++){ //버스 입력
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            dist[a][b]=Math.min(dist[a][b],c);
        }

        //i: from, j: to, k: via
        for (int k=1;k<=n;k++){
            for (int i=1;i<=n;i++){
                if (dist[i][k]==INF) continue;
                for (int j=1;j<=n;j++){
                    if (dist[k][j]==INF) continue;
                    int cand=dist[i][k]+dist[k][j];
                    if (cand<dist[i][j]) dist[i][j]=cand;
                }
            }
        }

        StringBuilder sb=new StringBuilder();

        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if ((i==j) || dist[i][j]==INF)  sb.append("0").append(" ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
