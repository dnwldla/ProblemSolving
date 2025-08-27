import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int r,c,d;

        public Node(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    private static StringTokenizer st;
    private static int r,c,t,d;
    private static int[][] map;
    private static int DIST_LIMIT = 52*52*25*25+1;

    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws Exception {
        init();
        int answer=solution(f(false),f(true));
        System.out.println(answer);

    }

    private static int solution(int[][] a,int[][] b){
        //거리 비교
        int ret=0;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (a[i][j]+b[i][j]>d) continue;

                ret=Math.max(ret,map[i][j]);
            }
        }
        return ret;
    }

    private static int[][] f(boolean reverse){
        PriorityQueue<Node> pq=new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {return o1.d-o2.d;}
        });
        int[][] dist=new int[r][c];
        boolean[][] v=new boolean[r][c];

        for (int[] row:dist) Arrays.fill(row,DIST_LIMIT);
        pq.add(new Node(0,0,0));
        dist[0][0]=0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();
            int cr = cur.r;
            int cc = cur.c;
            int cd = cur.d;

            //from->to compress visit or 단일 노드 visit?
            if (v[cr][cc]) continue;
            v[cr][cc] = true;

            for (int i=0;i<4;i++){
                int nx=cr+dx[i];
                int ny=cc+dy[i];

                if (outOfRange(nx,ny)){
                    continue;
                }
                //높이 차이가 T 초과면 continue
                if (Math.abs(map[cr][cc]-map[nx][ny])>t) continue;
                //누적 거리를 구한다

                int distDiff=!reverse?getTimeDiff(map[cr][cc],map[nx][ny]):getTimeDiff(map[nx][ny],map[cr][cc]);

                // d 초과하면 continue: 중복 조건임
                if (cd+distDiff>d){ //cd 대신 dist[cd][cc]로 하면 안될까?
                    continue;
                }

                if (dist[nx][ny]>cd+distDiff){
                    //pq에 삽입
                    dist[nx][ny]=cd+distDiff;
                    pq.add(new Node(nx,ny,dist[nx][ny]));
                }

            }


        }
        return dist;
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r=ni(); c=ni(); t=ni(); d=ni();
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char tmp = row.charAt(j);
                map[i][j] = tmp >= 'a' ? tmp - 'a' + 26 : tmp - 'A';
            }
        }
    }

    private static int ni() { return Integer.parseInt(st.nextToken()); }


    static boolean outOfRange(int x,int y){
        return x<0 || x>=r || y<0 || y>=c;
    }

    static int getTimeDiff(int curH,int futH){
        //현재 위치보다 같거나 낮으면 1 리턴
        if (curH>=futH) return 1;
            //제곱 계산
        else{
            return Math.abs((curH-futH)*(curH-futH));
        }
    }


}
