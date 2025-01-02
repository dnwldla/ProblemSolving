import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int M,N,K;
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());

        for (int i=0;i<tc;i++){
            String[] rawInput=br.readLine().split(" ");
            M=Integer.parseInt(rawInput[0]); //열
            N=Integer.parseInt(rawInput[1]); //행
            K=Integer.parseInt(rawInput[2]);
            int answer=0;

            graph=new int[N][M];
            visited=new boolean[N][M];

            for (int j=0;j<K;j++){
                String[] raw=br.readLine().split(" ");
                int newM=Integer.parseInt(raw[0]);
                int newN=Integer.parseInt(raw[1]);
                graph[newN][newM]=1;
            }

            for (int k=0;k<N;k++){
                for (int j=0;j<M;j++){
                    if (visited[k][j]==false && graph[k][j]==1){
                        bfs(k,j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    static void bfs(int x,int y){
        Queue<Integer[]> q=new LinkedList<>();
        q.add(new Integer[]{x,y});
        visited[x][y]=true;
        int[] dx=new int[]{0,0,-1,1};
        int[] dy=new int[]{1,-1,0,0};

        while (!q.isEmpty()){
            Integer[] top=q.poll();
            //상하좌우
            for (int i=0;i<4;i++){
                int newX=top[0]+dx[i];
                int newY=top[1]+dy[i];

                if (isValid(newX,newY) && visited[newX][newY]==false&& graph[newX][newY]==1){
                    visited[newX][newY]=true;
                    q.add(new Integer[]{newX,newY});
                }
            }
        }
    }

    static boolean isValid(int x,int y){
        if (x>=0 && x<N && y>=0 && y<M){
            return true;
        }
        return false;
    }
}
