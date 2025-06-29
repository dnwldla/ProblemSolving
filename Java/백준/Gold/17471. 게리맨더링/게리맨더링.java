import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int INF=Integer.MAX_VALUE;
    static int ret=INF;

    //연결고리를 찾는다
    static void checkList(int cur,int flag,int[]a){
        for (Integer next:graph[cur]){
            if (a[next]!=flag) continue;
            if (cyclecheck[next]) continue;
            cyclecheck[next] = true;
            checkList(next,flag,a);
        }
    }


    static int check(){
        List<Integer> A=new ArrayList<>();
        List<Integer> B=new ArrayList<>();

        for (int i=1;i<=N;i++) cyclecheck[i]=false;

        int[] a=new int[N+1]; //어느 지점인지 확인하는 함수
        for (int i=1;i<=N;i++){
            if (visited[i]){
                A.add(i);
                a[i]=1;
            }
            else{
                B.add(i);
                a[i]=0;
            }
        }
        if (A.isEmpty() || B.isEmpty()){
            return INF;
        }
        cyclecheck[A.get(0)]=true;
        int aCnt=0,n1=0,n2=0;
        checkList(A.get(0),1,a);
        for (int i=1;i<=N;i++){
            if (cyclecheck[i]){
                aCnt+=person[i];
                n1++;
            }
        }
        if (n1!=A.size()){
            return INF;
        }

        int bCnt=0;
        for (int i=1;i<=N;i++){
            cyclecheck[i]=false;
        }
        cyclecheck[B.get(0)]=true;
        checkList(B.get(0),0,a);

        for (int i=1;i<=N;i++){
            if (cyclecheck[i]){
                bCnt+=person[i];
                n2++;
            }
        }

        if (n2!=B.size()) return INF;

        return Math.abs(aCnt-bCnt);

    }

    static void go(int cur){
        ret=Math.min(ret,check());
//        for (int i=1;i<=N;i++){
//            if (visited[i]) System.out.print(i+" ");
//        }
//        System.out.printf("&&%d\n", ret);

        for (int i=cur+1;i<=N;i++){
            if (!visited[i]){
                visited[i]=true;
                go(i);
                visited[i]=false;
            }
        }
    }
    static int N;
    static int[] person=new int[11];
    static List<Integer>[] graph=new List[11];
    static boolean[] visited=new boolean[11];
    static boolean[] cyclecheck=new boolean[11];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for (int i=1;i<=N;i++){
            person[i]=sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=1;i<=N;i++){
            int M;
            M=sc.nextInt();
            for (int j=0;j<M;j++){
                graph[i].add(sc.nextInt());
            }
        }

        //구역 나누기

        for (int i=1;i<=N;i++){
            visited[i]=true;
            go(i);
            visited[i]=false;
        }
        if (ret==INF) System.out.println(-1);
        else System.out.println(ret);

    }
}
