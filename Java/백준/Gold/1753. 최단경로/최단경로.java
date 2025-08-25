import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] adj;
    static int[] dist;
    static int INF=Integer.MAX_VALUE;
    static boolean[] visited;
    static class Node{
        int to,w;
        public Node(int to,int w){
            this.to=to;
            this.w=w;
        }

    }

    static void dijkstra(int start){

        //오름차순 우선순위 큐
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        Arrays.fill(dist,INF);

        dist[start]=0;
        pq.add(new int[]{0,start}); //누적 거리, cur 노드

        while (!pq.isEmpty()){
            int[] cur=pq.poll();
            int hereCost=cur[0];
            int u=cur[1];

            visited[u]=true;
            for (Node n:adj[u]){
                if (visited[n.to]) continue;
                if (dist[n.to]>dist[u]+n.w){
                    dist[n.to]=dist[u]+n.w;
                    pq.add(new int[]{dist[n.to],n.to});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점 수 V
        int m = Integer.parseInt(st.nextToken()); // 간선 수 E

        int start = Integer.parseInt(br.readLine());

        adj=new ArrayList[n+1];
        visited=new boolean[n+1];
        for (int i=1;i<=n;i++) adj[i]=new ArrayList<>();
        dist=new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();

        for (int i=1;i<=n;i++){
            if (dist[i]==INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb.toString());

    }
}
