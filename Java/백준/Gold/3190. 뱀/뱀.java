import java.util.*;

public class Main {
    static int N,K,L;
    static int[][] graph;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int[][] dir={
        {3,1},
        {0,2},
        {1,3},
        {2,0}
    };
    static boolean[][] me;
    static class Node{
        int time; char c;

        public Node(int time, char c) {
            this.time = time;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N + 1][N + 1];
        me=new boolean[N+1][N+1];
        K = sc.nextInt();

        // 사과 위치 입력
        for (int i = 0; i < K; i++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            graph[R][C] = 1;   // 사과 표시
        }
        L = sc.nextInt();

        ArrayDeque<Node> dirQ=new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            int X = sc.nextInt();
            char C = sc.next().charAt(0);
            dirQ.add(new Node(X,C));
        }

        int time=0;
        int state=0;
        //뱀
        Deque<Integer[]> dq=new LinkedList<>();
        dq.add(new Integer[]{1,1});
        me[1][1]=true;
        while (true){
            //초는 언제 늘려야 하는가
            time++;

            //늘린다
            Integer[] cur=dq.peekLast();
            me[cur[0]][cur[1]]=true;
            Integer[] next={cur[0]+dx[state],cur[1]+dy[state]};

            //벽이나 자기자신이면 끝
            if (outOfRange(next[0],next[1])){
           //     System.out.printf("%d초에서 벽을 만나서 실패\n",time);
                break;
            }
            if (me[next[0]][next[1]]){
             //   System.out.printf("%d에서 자기랑 충돌해서 실패, next는 %d %d \n ",time,next[0],next[1]);
               // printDQ(dq);
                break;
            }

            //다음칸 추가
            dq.add(next);
            me[next[0]][next[1]]=true;

            //next에 사과가 있다면
            if (graph[next[0]][next[1]]==1){
                graph[next[0]][next[1]]=0;
            }
            //사과가 없다면 꼬리를 죽인다
            else if (graph[next[0]][next[1]]==0){
                Integer[] del=dq.peekFirst();
                me[del[0]][del[1]]=false;
                dq.pollFirst();
            }

            //state update: empty 처리 필수
            if (!dirQ.isEmpty()){
                Node node=dirQ.peekFirst();
                int cmpTime=node.time;

                if (time==cmpTime){
                    char c=node.c;
                    if (c=='L'){
                        state=dir[state][0];
                    }else if (c=='D'){
                        state=dir[state][1];
                    }
                    dirQ.pollFirst();
                }
            }
            //시간 안걸리면 state 유지



        }

        System.out.println(time);

    }

    private static void printDQ(Deque<Integer[]> dq) {
        while (!dq.isEmpty()){
            System.out.println("====덱에 있는 원소 출력");
            Integer[] cur=dq.pollFirst();
            System.out.println(cur[0]+" "+cur[1]);
        }
    }

    static boolean outOfRange(int x,int y){
        return x<=0 || x>N || y<=0 || y>N;
    }

}
