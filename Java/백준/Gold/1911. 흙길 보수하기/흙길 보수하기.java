import java.util.*;

public class Main {

    public static void main(String[] args) {
        int N,L;
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt(); L=sc.nextInt();

        int[][] ar=new int[N][2];
        for (int i=0;i<N;i++){
            ar[i][0]=sc.nextInt();
            ar[i][1]=sc.nextInt();
        }

        Arrays.sort(ar,(o1,o2)->o1[0]-o2[0]);


        //cur[1]과 after[0] diff이 L 이상이면 cur에서 처리
        //else 누적
        int ret=0; int start=ar[0][0]; int end=ar[0][1];
        int idx=0;
       for (int i=0;i<N;i++){
           start=ar[i][0]; end=ar[i][1];
           if (end<=idx) continue;

           start=Math.max(idx,start);

           int diff=end-start;
           ret+=(int)Math.ceil((double)diff/(double)L);

           idx=start+(int)Math.ceil((double)diff/(double)L)*L;
       }


        System.out.println(ret);

    }

}
