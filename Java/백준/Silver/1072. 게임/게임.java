import java.util.Scanner;

public class Main {
    static long X,Y,Z;
    static long ret=-1;
    static long MAX=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        X = sc.nextLong(); Y= sc.nextLong();
        Z=Y*100/X;

        long lo=1,hi=MAX;
        go(lo,hi);
        System.out.println(ret);
    }

    static void go(long lo,long hi){
        //이분탐색
        while (lo<=hi){
            long mid=(lo+hi)/2;
            long newZ=((Y+mid)*100)/(X+mid);

            if (newZ>Z){
                ret=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }

    }

}
