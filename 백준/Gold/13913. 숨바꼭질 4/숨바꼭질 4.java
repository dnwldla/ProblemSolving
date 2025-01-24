import java.util.*;

public class Main {
    static final int MAX = 100000;
    static final int MIN=0;
    static int[] visited = new int[MAX + 4];
    static int[] parent=new int[MAX+1];
    
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            Queue<Integer> q=new LinkedList<>();
            q.add(n);
            visited[n]=1;

            while (!q.isEmpty()){
                //꺼낸 것의 loc이 m과 같다면 break
                int here=q.poll();
                if (here==m){
                    break;
                }
                //3개 순회
                for (int there:new int[]{here+1,here-1,here*2}){
                    if (there>=MIN && there<=MAX){
                        if (visited[there]==0){
                            visited[there]=visited[here]+1;
                            q.add(there);
                            parent[there]=here;
                        }
                    }
                }
            }
            if (n==m) System.out.println(0);
            else System.out.println(visited[m]-1);
            List<Integer> ret=new ArrayList<>();


            while (true){
                ret.add(m);
                if (m==n) break;
                m=parent[m];
            }

            Collections.reverse(ret);
            for (Integer a:ret){
                System.out.printf(a+" ");
            }



    }
}
