import java.util.*;

public class Main {
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt(); M=sc.nextInt();
        Set<Integer> a=new HashSet<>();
        Set<Integer> b=new HashSet<>();
        int[] ar1=new int[N],ar2=new int[M];

        for (int i=0;i<N;i++){
            int elem=sc.nextInt();
            a.add(elem);
            ar1[i]=elem;
        }

        for (int i=0;i<M;i++){
            int elem=sc.nextInt();
            b.add(elem);
            ar2[i]=elem;
        }


        int ret=0;

        for (int i=0;i<N;i++){
            if (!b.contains(ar1[i])) ret++;
        }
        for (int i=0;i<M;i++){
            if (!a.contains(ar2[i])) ret++;
        }
        System.out.println(ret);
    }
}
