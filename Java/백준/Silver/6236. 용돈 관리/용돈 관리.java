import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] ar;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M=sc.nextInt();
        int min=Integer.MIN_VALUE,max=1_000_000_004;

        ar=new int[N];
        for (int i=0;i<N;i++){
            ar[i]=sc.nextInt();
            min=Math.max(min,ar[i]);
        }

        int bud=0,ans=0,mid=0;

        int lo=min; int hi=max;
        while (lo<=hi){
           mid=(lo+hi)/2;
           
           if (check(mid)){
               ans=mid; //예산
               hi=mid-1;
           }else{
               lo=mid+1;
           }

        }
        System.out.println(ans);
    }


    static boolean check(int mid){
        int cnt=1;
        int temp=mid;
        for (int i=0;i<N;i++){
            //예산이 크다면
            if (mid-ar[i]<0){
                mid=temp;
                cnt++;
            }
            mid-=ar[i];
        }
        return cnt<=M;
    }

}
