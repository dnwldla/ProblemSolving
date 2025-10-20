import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long S,C;
        Scanner sc = new Scanner(System.in);
        S=sc.nextLong(); C=sc.nextLong();

        long[] p=new long[(int)S];
        long lo=1,hi=0;
        long sum=0;
        for (int i=0;i<S;i++){
            p[i]=sc.nextLong();
            sum+=p[i];
            hi=Math.max(hi,p[i]);
        }
        long ret=0;
        while (lo<=hi){
            long mid=(lo+hi)/2;

            long tot=0;

            for (int i=0;i<S;i++){
                tot+=(p[i]/mid);
            }

            if (C<=tot){
                lo=mid+1;
                ret=mid;
            }else if (C>tot){
                hi=mid-1;
            }
        }

        System.out.println(sum-ret*C);
    }

}
