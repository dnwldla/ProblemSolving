import java.util.*;

public class Main {

    static class Pair{
        int x;
        int y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int[][] graph;
    static boolean[][] visited;
    static int N, M;
    static int ret1, ret2;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Pair> cheese=new ArrayList<>();
    static Queue<Pair> q=new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        q.add(new Pair(0,0));
        int time=0,ret=0;
        while (true) {

            go();
            if (cheese.isEmpty()) break;
            time++;
            q = new LinkedList<>(cheese);
            ret=cheese.size();
            cheese.clear();
        }

        System.out.println(time);
        System.out.println(ret);
    }

    static void go() {
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;

                if (graph[nx][ny] == 1) {
                    cheese.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    continue;
                }
                visited[nx][ny] = true;
                q.add(new Pair(nx, ny));
            }
        }
    }
}