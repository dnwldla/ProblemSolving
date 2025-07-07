import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        int X;
        Scanner sc = new Scanner(System.in);
        X=sc.nextInt();
        int cnt=0;
        while (X>0){
            if (X%2!=0) cnt++;
            X/=2;
        }
        System.out.println(cnt);
    }
}
