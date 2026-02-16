import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt=0;
        for (int i=666;;i++){
            String s=String.valueOf(i);

            if (s.contains("666")){
                cnt++;
            }

            if (cnt==N){
                System.out.println(i);
                break;
            }
        }
    }

}
