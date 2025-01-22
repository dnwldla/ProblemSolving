import java.util.*;

public class Main {
    //bfs가 유리할 거 같은데 정확히 몇번 수행할지 수식으로 나타내지 못하겠다 ㅜ
    static int N,M;
    static int maxRange=100000;
    static int minRange=0;
    static int time=-1;
    static int ret=0;
    static int[] visited=new int[maxRange+1];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{N,0});
        visited[N]=0;
        while (!q.isEmpty()){
           int[] cur= q.poll();
           int curLoc=cur[0];
           int curTime=cur[1];
           if (curLoc==M && time==-1){
               time=curTime;
               ret++;
           }
           else if (curLoc==M && time==curTime){
               ret++;
           }
           else if (curLoc==M && time!=curTime){
               break;
           }

           //걷기 +1
            if (curLoc+1>=minRange && curLoc+1<=maxRange &&(visited[curLoc+1]== 0 ||visited[curLoc+1]==curTime+1)){
                q.add(new int[]{curLoc+1,curTime+1});
                visited[curLoc+1]=curTime+1;
            }

            if (curLoc-1>=minRange && curLoc-1<=maxRange&&(visited[curLoc-1]== 0 ||visited[curLoc-1]==curTime+1)){
                q.add(new int[]{curLoc-1,curTime+1});
                visited[curLoc-1]=curTime+1;
            }

            if (curLoc*2>=minRange && curLoc*2<=maxRange&&(visited[curLoc*2]== 0 ||visited[curLoc*2]==curTime+1)){
                q.add(new int[]{curLoc*2,curTime+1});
                visited[curLoc*2]=curTime+1;
            }

        }
        System.out.println(time);
        System.out.println(ret);
    }
}
