import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static int N;
    static int ret=Integer.MAX_VALUE;
    static Pair[] ar;
    static int[] dp;
    static class Pair implements Comparable<Pair> {
        int x;int y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        public int getY(){
            return y;
        }
        public int getX(){
            return x;
        }

        @Override
        public int compareTo(Pair o) {
            return this.getX()-o.getX();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ar=new Pair[N];
        dp=new int[N];
        for (int i = 0; i < N; i++) {
            ar[i]=new Pair(sc.nextInt(),sc.nextInt());
        }

        //정렬
        Arrays.sort(ar);

        for (int i=0;i<N;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){ //이전
                int curY=ar[i].getY();
                int prevY=ar[j].getY();

                //curY가 크다면
                if (curY>prevY && dp[j]>=dp[i]) dp[i]=dp[j]+1;
            }
        }

        for (int i=0;i<N;i++){
            ret=Math.min(ret,N-dp[i]);
        }
        System.out.println(ret);

    }


}
