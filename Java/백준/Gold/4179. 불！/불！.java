import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean flag;
    static int R,C,ret;
    static char[][] map = new char[1001][1001];
    static boolean[][] visited = new boolean[1001][1001];
    static class Pair{
        int x;int y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        boolean isEnd() {
            if (x==0 || x==R-1) return true;
            if (y==0 || y==C-1) return true;
            return false;
        }
    }

    static boolean outOfRange(int x,int y){
        if (x<0 || x>=R || y<0 || y>=C) return true;
        return false;
    }

    static boolean isWall(int x,int y){
        if (map[x][y] == '#') return true;
        return false;
    }

    static  boolean isEnd(int x,int y) {
        if (x==0 || x==R-1) return true;
        if (y==0 || y==C-1) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();C=sc.nextInt();
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        Queue<Pair> fireQ=new LinkedList<>();
        Queue<Pair> locQ=new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String s=sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j]=s.charAt(j);

                if (map[i][j]=='J') {locQ.add(new Pair(i,j)); visited[i][j]=true;}
                else if (map[i][j]=='F') {fireQ.add(new Pair(i,j)); visited[i][j]=true;}

            }
        }

        if (locQ.peek().isEnd()){
            System.out.println(1);
            return;
        }
        ret=1;
        boolean impossible=false;
        while (true){
            int fireSize=fireQ.size();
            while (fireSize>0){
                Pair fire=fireQ.poll();
                fireSize--;
                //상하좌우 벽 제외하고 불뿌리기
                for (int i=0;i<4;i++){
                    int nx=fire.getX()+dx[i];
                    int ny=fire.getY()+dy[i];

                    if (outOfRange(nx,ny)) continue;
                    if (isWall(nx,ny)) continue;
                    if (visited[nx][ny]) continue;

                    fireQ.add(new Pair(nx,ny));
                    visited[nx][ny]=true;
                    map[nx][ny]='F';
                }
            }

            int locSize=locQ.size();
            //현 위치에서 이동가능한 곳 판별: 가장자리면 break, else push
            while (locSize>0){
                Pair loc=locQ.poll();
                locSize--;

                for (int i=0;i<4;i++){
                    int nx=loc.getX()+dx[i];
                    int ny=loc.getY()+dy[i];

                    if (outOfRange(nx,ny)) continue;
                    if (visited[nx][ny]) continue;
                    if (isWall(nx,ny)) continue;
                    if (map[nx][ny]=='F') continue;

                    if (isEnd(nx,ny)){
                        flag=true;
                        break;
                    }
                    locQ.add(new Pair(nx,ny));
                    visited[nx][ny]=true;

                }
            }
            if (flag) break;
            if (locQ.isEmpty()){
                impossible=true;
                break;
            }
            ret++;
        }

        if (impossible) System.out.println("IMPOSSIBLE");
        else System.out.println(ret+1);

    }
}
