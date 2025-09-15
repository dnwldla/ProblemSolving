import java.util.*;
import java.io.*;

public class Main{
    static class Pair{
        int x,y;

        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int N,M,ret;
    static List<int[]> chicken=new ArrayList<>();
    static List<int[]> house=new ArrayList<>();
    static Pair[] ar;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());        
        ar=new Pair[N*N+1];
        visited=new boolean[N+1][N+1];
        ret=Integer.MAX_VALUE;

        for (int i=0;i<N;i++){
            String[] raw=br.readLine().split(" ");
            for (int j=0;j<raw.length;j++){
                if (raw[j].equals("1")){
                    house.add(new int[]{i,j});
                }else if (raw[j].equals("2")){
                    chicken.add(new int[]{i,j});
                }
            }
        }
        //치킨 조합을 구한다
        go(0,0);
        System.out.println(ret);
    }

    static void go(int cur,int depth){

        if (depth==M){
            int cmp=0;
            for (int j=0;j<house.size();j++){
                int[] curH=house.get(j);
                int x=curH[0],y=curH[1];
                int minDist=Integer.MAX_VALUE;
                for (int i=0;i<M;i++){
                    int cX=ar[i].x,cY=ar[i].y;
                    minDist=Math.min(Math.abs(x-cX)+Math.abs(y-cY),minDist);
                }
                cmp+=minDist;
            }
            ret=Math.min(ret,cmp);
        }

        for (int i=cur;i<chicken.size();i++){
            int[] curC=chicken.get(i);
            int x=curC[0],y=curC[1];

            if (!visited[x][y]){
                visited[x][y]=true;
                ar[depth]=new Pair(x,y);
                go(i+1,depth+1);
                visited[x][y]=false;
            }
        }

    }
}
