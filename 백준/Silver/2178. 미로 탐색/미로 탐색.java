import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N,M;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        //입력
         //N은 4, M은 6
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] rawNM=br.readLine().split(" ");
        N=Integer.parseInt(rawNM[0]);
        M=Integer.parseInt(rawNM[1]);

        graph=new int[N+1][M+1];
        dist=new int[N+1][M+1];
        visited=new boolean[N+1][M+1];


        for (int i=1;i<=N;i++){
            String[] rawInput=br.readLine().split("");
            for (int j=1;j<=M;j++){
                graph[i][j]=Integer.parseInt(rawInput[j-1]);
            }
        }

        //bfs를 돌린다
        int answer=bfs();
        System.out.println(answer);

    }

    static int bfs(){
        Queue<Integer[]> q=new LinkedList<>();
        q.add(new Integer[]{1,1});
        visited[1][1]=true;
        dist[1][1]=1;
        int[] dx=new int[]{0,0,-1,1};
        int[] dy=new int[]{1,-1,0,0};

        while (!q.isEmpty()){
            Integer[] top=q.poll();
            if (top[0]==N && top[1]==M){
                break;
            }
            //상하좌우
            for (int i=0;i<4;i++){
                int newX=top[0]+dx[i];
                int newY=top[1]+dy[i];

                if (isValid(newX,newY) && visited[newX][newY]==false&& graph[newX][newY]==1){
                    visited[newX][newY]=true;
                    q.add(new Integer[]{newX,newY});
                    dist[newX][newY]=dist[top[0]][top[1]]+1;
                }
            }
        }
        return dist[N][M];
    }

    static boolean isValid(int x,int y){
        if (x>=1 && x<=N && y>=1 && y<=M){
            return true;
        }
        return false;
    }
}
