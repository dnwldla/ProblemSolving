import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int T,N,M;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i=0;i<T;i++){
            N = sc.nextInt();
            HashSet<Integer> set=new HashSet<>();
            for (int j=0;j<N;j++){
                int post=sc.nextInt();
                set.add(post);
            }

            M=sc.nextInt();
            StringBuilder sb=new StringBuilder();
            for (int j=0;j<M;j++){
                int ans= sc.nextInt();
                if (set.contains(ans)) sb.append("1").append("\n");
                else sb.append("0").append("\n");

            }

            System.out.print(sb.toString());

        }
    }
}


