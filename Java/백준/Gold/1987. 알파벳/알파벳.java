import java.util.*;
import java.io.*;

public class Main {
    static int R,C;
    static char[][] ar;
    static int ret=0;
    static int[] dx={0,1,-1,0},dy={1,0,0,-1};

    //똑같은거 있으면 return
    static void go(int x,int y,int cur,int cnt){
        ret=Math.max(cnt,ret);

        for (int i=0;i<4;i++){
            int nx=x+dx[i],ny=y+dy[i];
            if (outOfRange(nx,ny)) continue;

            int k= 1<<(ar[ny][nx]-'A'); // 여기만 수정

            if ((k&cur)==0){
                go(nx,ny,cur|k,cnt+1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        ar=new char[R][C];


        for (int i = 0; i < R; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < C; j++) {
                ar[i][j] = line.charAt(j);
            }
        }

        //입력 끝
        go(0,0,1<<ar[0][0]-'A',1);
        System.out.println(ret);



    }

    static boolean outOfRange(int x,int y){
        return y < 0 || y >= R || x < 0 || x >= C;
    }

}
