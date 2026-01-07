import java.util.*;

public class Main {
    static int n,d;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int ret=0;
        int[][] ar=new int[n][2];

        for (int i=0;i<n;i++){
            ar[i][1]=sc.nextInt(); ar[i][0]=sc.nextInt();
        }

        Arrays.sort(ar,(o1,o2)->o1[0]-o2[0]);

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for (int i=0;i<n;i++){
            //돈을 담는다
            pq.add(ar[i][1]);
            if (pq.size()>ar[i][0]) pq.poll();
        }

        while (!pq.isEmpty()){
            ret+=pq.poll();
        }

        System.out.println(ret);
    }
}
