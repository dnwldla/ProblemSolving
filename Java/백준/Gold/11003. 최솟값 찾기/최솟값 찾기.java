import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int N,L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NL=br.readLine().split(" ");
        N = Integer.parseInt(NL[0]); L = Integer.parseInt(NL[1]);
        int[] ar=new int[N+1];
        String[] raw=br.readLine().split(" ");
        for (int i=1;i<=N;i++) ar[i]=Integer.parseInt(raw[i-1]);

        int[] ret=new int[N+1];

        ArrayDeque<Integer> dq=new ArrayDeque<>();

        for (int i=1;i<=N;i++){
            //1. 범위 조정
            while (!dq.isEmpty() && i-dq.peekFirst()>=L){
                dq.pollFirst();
            }

            //2. 덱의 앞이 구간 내의 최솟값이다
            while (!dq.isEmpty() && ar[dq.peekLast()]>ar[i]){
                dq.pollLast();
            }
            
            dq.add(i);

            //3. cur값(새로 들어오는 값과 기존 최솟값을 비교한다)
            ret[i]=Math.min(ar[dq.peekFirst()],ar[i]);
            
            
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=N;i++) sb.append(ret[i]).append(" ");

        System.out.println(sb.toString());

    }
}
