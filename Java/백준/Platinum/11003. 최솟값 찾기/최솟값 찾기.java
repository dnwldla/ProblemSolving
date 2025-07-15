import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
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
            while (!dq.isEmpty() && i-dq.peekFirst()>=L){
                dq.pollFirst();
            }
            //덱의 앞이 더 크다는 것을 전제로 한다
            while (!dq.isEmpty() && ar[dq.peekLast()]>ar[i]){
                dq.pollLast();
            }
            dq.add(i);
           
            ret[i]=Math.min(ar[dq.peekFirst()],ar[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=N;i++) sb.append(ret[i]).append(" ");

        System.out.println(sb.toString());
    }
}
