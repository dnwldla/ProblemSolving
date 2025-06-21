import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static int N,M,R;
    static int sX,sY,eX,eY;
    static int[][] ar=new int[301][301];
    static boolean[][] visited=new boolean[301][301];

    static void fix(ArrayDeque<Integer> deque){

        for (int i=sY;i<=eY-1;i++){
            ar[sX][i]=deque.poll();
        }

        //아래
        for (int i=sX;i<=eX-1;i++){
            ar[i][eY]=deque.poll();
        }
        //행 고정
        for (int i=eY;i>sY;i--){
            ar[eX][i]=deque.poll();
        }

        //열 고정
        for (int i=eX;i>sX;i--){
            ar[i][sY]=deque.poll();
        }
    }

    static void rotate(){
        ArrayDeque<Integer> deque=new ArrayDeque<>();

        //->
        for (int i=sY;i<=eY-1;i++){
            deque.add(ar[sX][i]);
            visited[sX][i]=true;
        }

        //아래
        for (int i=sX;i<=eX-1;i++){
                deque.add(ar[i][eY]);
                visited[i][eY]=true;
        }
        //행 고정
        for (int i=eY;i>sY;i--){
                deque.add(ar[eX][i]);
                visited[eX][i]=true;
        }

        //열 고정
        for (int i=eX;i>sX;i--){
                deque.add(ar[i][sY]);
                visited[i][sY]=true;
        }

        for (int i=0;i<R;i++){
            //System.out.println(deque.peek());
            deque.add(deque.poll());
        }

        fix(deque);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M=sc.nextInt(); R=sc.nextInt();

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                ar[i][j]=sc.nextInt();
            }
        }
        sX=0;sY=0;
        eX=N-1;eY=M-1;
        while (true){
            if (visited[sX][sY]) break;
            rotate();
            sX++;sY++;
            eX--;eY--;
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                System.out.printf(ar[i][j]+" ");
            }
            System.out.println();
        }

    }
}
