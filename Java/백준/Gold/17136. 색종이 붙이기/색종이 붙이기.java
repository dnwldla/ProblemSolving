import java.io.*;
import java.util.*;

public class Main {
    static int ans=Integer.MAX_VALUE;
    static int[] paper={0,5,5,5,5,5};
    static int[][] map=new int[11][11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i=0; i<10;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<10;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0,0,0);
        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
    }

    static void go(int x,int y,int cnt){
        //현재 위치에서 더 작은게 있다면 return
        if (cnt>=ans) return;
        //마지막 열일 때-> 다음 행일 때
        if (x!=10 && y==10){
            go(x+1,0,cnt);
            return;
        }
        if (x==10){
            ans=Math.min(ans,cnt);
            return;
        }

        if (map[x][y]==1){
            for (int k=1;k<=5;k++){ //탐색 개수
                //모두 1이면 붙이고
                if (check(x,y,k) && paper[k]>=1){
                    //붙인다
                    update(x,y,k,0);
                    //종이 개수를 줄인다-
                    paper[k]--;
                    //next를 탐색한다
                    go(x,y+1,cnt+1);
                    //원복한다
                    update(x,y,k,1);
                    paper[k]++;

                }

            }
        }else{ //오른쪽으로 이동
            go(x,y+1,cnt);
        }

    }

    static void update(int x,int y,int cnt,int n){
        for (int i=x;i<x+cnt;i++){
            for (int j=y;j<y+cnt;j++){
                map[i][j]=n;
            }
        }
    }

    static boolean check(int x,int y,int cnt){
        for (int i=x;i<x+cnt;i++){
            for (int j=y;j<y+cnt;j++){
                //outOfrange면 return false
                if (outOfRange(i,j)){
                    return false;
                }
                if (map[i][j]==0) return false;
                //0이 존재하면 false
            }
        }
        return true;
    }


    static boolean outOfRange(int x,int y){
        return x<0 || x>=10 || y<0 ||y>=10;
    }
}
