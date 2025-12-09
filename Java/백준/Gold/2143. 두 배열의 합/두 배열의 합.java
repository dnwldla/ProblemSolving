
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int T,n,m;
    static int[] A;
    static int[] B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T=sc.nextInt();
        n=sc.nextInt();
        A=new int[n];

        for (int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }

        m=sc.nextInt();
        B=new int[m];
        for (int i=0;i<m;i++){
            B[i]=sc.nextInt();
        }

        //부분합 구하기
        List<Long> a=new ArrayList<>();
        List<Long> b=new ArrayList<>();

        for (int i=0;i<n;i++){
            long sum=A[i];
            a.add(sum);
            for (int j=i+1;j<n;j++){
                a.add(sum+=A[j]);
            }
        }

        for (int i=0;i<m;i++){
            long sum=B[i];
            b.add(sum);
            for (int j=i+1;j<m;j++){
                b.add(sum+=B[j]);
            }
        }

        //정렬
        Collections.sort(a); Collections.sort(b);

        int i=0,j=b.size()-1;
        long ret=0;

        while (true){
            if (i==a.size() || j==-1) break;

            long curA=a.get(i); long curB=b.get(j);

            if (curA+curB==T){
                long c1=0,c2=0;
                while (i<a.size() && a.get(i)==curA){
                    i++;
                    c1++;
                }
                while (j>=0 && b.get(j)==curB){
                    j--;
                    c2++;
                }
                ret+=(c1*c2);

            }
            else if (curA+curB<T){
                i++;
            }
            else if (curA+curB>T){
                j--;
            }

        }
        System.out.println(ret);



    }

}
