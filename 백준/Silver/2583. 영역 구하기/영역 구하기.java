import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int M,N,K;
    static int[][] graph;
    static boolean[][] visited;
    static List<Integer> ans=new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 행
        N = Integer.parseInt(st.nextToken()); // 열
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수

        graph = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 직사각형 영역 채우기
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    graph[y][x] = 1; // 직사각형 영역은 1로 표시
                }
            }
        }

        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                if (graph[i][j]!=1 && visited[i][j]==false){
                    ans.add(dfs(i,j));
                }
            }
        }

        //오름차순 정렬
        Collections.sort(ans);
        System.out.println(ans.size());
        for (Integer a:ans){
            System.out.printf("%d ",a);
        }
    }

    static int dfs(int x,int y){
        visited[x][y]=true;
        int ret=1;
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if (nx<0 || nx>=M || ny<0 || ny>=N) continue;
            if (visited[nx][ny]==true) continue;
            if (graph[nx][ny]==1) continue;

            ret+=dfs(nx,ny);
        }
        return ret;
    }
}
