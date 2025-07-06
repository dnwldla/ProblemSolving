import java.util.*;

public class Main {
    static int N,M;
    static List<int[]> homes=new ArrayList<>();
    static List<int[]> chicken=new ArrayList<>();
    static boolean[] visited;
    static int ans=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();

        for (int i=1;i<=N;i++){
            for (int j=1;j<=N;j++){
                int k=sc.nextInt();

                if (k==1) homes.add(new int[]{i,j});
                else if (k==2) chicken.add(new int[]{i,j});
            }
        }
        visited=new boolean[chicken.size()];

        go(0,0);
        System.out.println(ans);
    }

    public static void go(int idx,int cnt){
        if (cnt==M){
            int temp=0;
            for (int[] home:homes){
                int ret=Integer.MAX_VALUE;
                for (int i=0;i< chicken.size();i++){
                    if (visited[i]){
                        int dist=Math.abs(home[0]-chicken.get(i)[0])+Math.abs(home[1]-chicken.get(i)[1]);

                        //한 가정에서 최소거리를 구한다
                        ret=Math.min(ret,dist);
                    }
                }
                temp+=ret;
            }
            ans=Math.min(ans,temp);
            return;
        }
        for (int i=idx;i< chicken.size();i++){
            visited[i]=true;
            go(i+1,cnt+1);
            visited[i]=false;
        }
    }

}
