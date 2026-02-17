import java.util.Scanner;

public class Main {
    static long C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B=sc.nextLong();
        C=sc.nextLong();

        System.out.println(go(A,B));





    }

    static long go(long num,long cnt){
        //basecase
        if (cnt==1){
            return num%C;
        }

        long ret=go(num,cnt/2)%C;
        long tmp=(ret*ret)%C;

        if (cnt%2!=0){
            tmp=(tmp*num)%C;
        }

        return tmp;


    }

}
