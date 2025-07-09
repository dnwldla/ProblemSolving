import java.util.Scanner;

public class Main {
    static int N;
    static int[] ar=new int[21];
    static int ret=Integer.MAX_VALUE;
    static void go(int here){
        if (here==N){
            int sum=0;
            //세로 확인
            for (int i=1<<(N-1);i>=1;i/=2){
                int cnt=0;

                for (int j=0;j<N;j++){
                    if ((ar[j]&i)!=0) cnt++; //100,010, 001 비교
                }
                sum+=Math.min(cnt,N-cnt);
            }
            ret=Math.min(ret,sum);
            return;
        }


        go(here+1);
        ar[here]=~ar[here]; //행 뒤집기
        go(here+1);
        ar[here]=~ar[here];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i=0;i<N;i++){
            String s;
            int val=1;
            s=sc.next();
            for (int j=s.length()-1;j>=0;j--){
                if (s.charAt(j)=='T') ar[i]|=val; //T일 때 1 부여
                val*=2;
            }
        }
        go(0);
        System.out.println(ret);
    }
}
