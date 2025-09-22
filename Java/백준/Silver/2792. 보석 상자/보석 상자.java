import java.util.Scanner;

public class Main {
    static int M,N;
    static int[] ar;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt(); M=sc.nextInt();
        ar=new int[M];
        int hi=0,mid=0;
        for (int i=0;i<M;i++){
            ar[i]=sc.nextInt();
            hi=Math.max(hi,ar[i]);
        }

        int lo=1,ret=0;

        while (lo<=hi){
            mid=(lo+hi)/2;

            if (check(mid)){//질투심보다 작거나 같다면
                hi=mid-1;
                ret=mid;
            }else{
                lo=mid+1;
            }
        }
        System.out.println(ret);

    }

    static boolean check(int mid){
        int tmp=0;
        for (int i=0;i<M;i++){
            tmp+=ar[i]/mid;
            if (ar[i]%mid!=0) tmp++;
        }

        return tmp<=N;
    }
}
