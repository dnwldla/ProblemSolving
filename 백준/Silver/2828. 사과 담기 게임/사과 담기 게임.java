import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int j = sc.nextInt();

        int l = 1;
        int r;
        int temp;
        int ret = 0;

        for (int i=0;i<j;i++){
            temp=sc.nextInt();
            r=l+m-1;
            //사과가 바구니 사이에 있다면
            if (temp>=l && temp<=r){
                continue;
            }else{
                if (temp<l){
                    ret+=(l-temp);
                    l=temp;
                }else{
                    l+=(temp-r);
                    ret+=(temp-r);
                }
            }

        }
        System.out.println(ret);
    }
}