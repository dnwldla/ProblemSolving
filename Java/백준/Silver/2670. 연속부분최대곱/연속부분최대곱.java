import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        double[] ar=new double[N];
        double[] psum=new double[N];

        for (int i=0;i<N;i++){
            ar[i]=sc.nextDouble();
            psum[i]=ar[i];
        }

        for (int i=1;i<N;i++){
            //곱한게 크다면 누적
            if (psum[i-1]*ar[i]>=ar[i]) psum[i]=psum[i-1]*ar[i];
            //작다면 stay
        }

        double max=0;
        for (int i=0;i<N;i++) max=Math.max(max,psum[i]);
        String ret=String.format("%.3f",max);
        System.out.println(ret);
    }
}
