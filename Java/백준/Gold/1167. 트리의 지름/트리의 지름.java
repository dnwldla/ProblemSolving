import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int V;
    static List<Pair>[] list;
    static boolean[] visited;
    static int maxDist;
    static int[] result=new int[2];

    static class Pair{
        int node,cost;

        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        public int getNode(){
            return node;
        }
        public int getCost(){
            return cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V=sc.nextInt();
        list=new ArrayList[V+1];
        visited=new boolean[V+1];
        for (int i=1;i<=V;i++){
            list[i]=new ArrayList<>();
        }

        int startNode=0;
        for (int i=1;i<=V;i++){
            int f=sc.nextInt();

            while (true){
                int node=sc.nextInt();
                if (node==-1) break;
                int cost=sc.nextInt();
                list[f].add(new Pair(node,cost));
                startNode=node;
            }
        }
        visited[startNode]=true;
        go(startNode,0);

        int leaf=result[0];
        for (int i=1;i<=V;i++)visited[i]=false;
        maxDist=0; result[0]=0; result[1]=0;

        visited[leaf]=true;
        go(leaf,0);
        System.out.println(result[1]);

    }

    static void go(int cur,int dist){
        int isLeaf=0;
        for (Pair next:list[cur]){
            if (visited[next.getNode()]) continue;
            visited[next.getNode()]=true;
            go(next.getNode(),dist+next.getCost());
            isLeaf++;
        }

        if (isLeaf==0){
            maxDist=Math.max(maxDist,dist);
            if (maxDist==dist){
                result[0]=cur;
                result[1]=dist;
            }
        }
    }
}
