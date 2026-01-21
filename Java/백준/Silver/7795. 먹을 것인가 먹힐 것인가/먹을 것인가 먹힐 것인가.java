import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T=sc.nextInt();
        for (int tc=0;tc<T;tc++){
            int N=sc.nextInt(); int M=sc.nextInt();
            int[] A=new int[N]; int[]B=new int[M];
            for (int i=0;i<N;i++){
                A[i]=sc.nextInt();
            }
            for (int i=0;i<M;i++){
                B[i]=sc.nextInt();
            }
            Arrays.sort(A); Arrays.sort(B);

            System.out.println(search(A,B));
        }
    }

    static int search(int[] A,int[] B){
        int ret=0;

        for (Integer a:A){
            int lo=0,hi=B.length-1,mid=(lo+hi)/2;

            while (lo<=hi){
                mid=(lo+hi)/2;

                if (a<=B[mid]) hi=mid-1;
                else if (a>B[mid]) lo=mid+1;

            }
            ret+=lo;
        }
        return ret;
    }

}
