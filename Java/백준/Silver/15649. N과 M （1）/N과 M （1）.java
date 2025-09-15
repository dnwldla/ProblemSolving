    import java.util.Scanner;

public class Main {
    static int N,M;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt(); M=sc.nextInt();
        visited=new boolean[N+1];
        arr=new int[N+1];

        go(1);
    }

    static void go(int cnt){

        if (cnt==M+1){
            StringBuilder sb=new StringBuilder();
            for (int i=1;i<cnt;i++){
                sb.append(arr[i]+" ");
            }
            System.out.println(sb.toString());
        }

        for (int i=1;i<=N;i++){
            if (!visited[i]){
                visited[i]=true;
                arr[cnt]=i;
                go(cnt+1);
                visited[i]=false;
            }
        }
    }

}
