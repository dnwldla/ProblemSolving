import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, w2;
        Edge(int to, int w2) { this.to = to; this.w2 = w2; }
    }

    static final int INF = 987654321;

    static int n, m, ret;
    static List<Edge>[] adj;
    static int[] dist;         
    static int[][] distWolf;    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w2 = d * 2; 
            adj[a].add(new Edge(b, w2));
            adj[b].add(new Edge(a, w2));
        }

        dist = new int[n + 1]; 
        distWolf = new int[2][n + 1]; 

        dijkstraFox();
        dijkstraWolf();

        int ans = 0;
        for (int i = 2; i <= n; i++) {
            int wolfBest = Math.min(distWolf[0][i], distWolf[1][i]);
            if (wolfBest > dist[i]) ans++;
        }
        System.out.println(ans);

    }

    static void dijkstraFox(){
        Arrays.fill(dist, INF);
        dist[1]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,1});

        while (!pq.isEmpty()) {
            int[] cur=pq.poll();
            int cd=cur[0],u=cur[1];

            if (dist[u]!=cd) continue;

            for (Edge e:adj[u]){
                int v=e.to;
                int nd=cd+e.w2; 
                if (nd<dist[v]) {
                    dist[v]=nd;
                    pq.add(new int[]{nd,v});
                }
            }
        }
    }

    static void dijkstraWolf(){
        Arrays.fill(distWolf[0], INF);
        Arrays.fill(distWolf[1], INF);
        distWolf[0][1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 1, 0});


        while (!pq.isEmpty()) {
            int[] cur=pq.poll();
            int cd=cur[0],u=cur[1],st=cur[2];

            if (distWolf[st][u]!=cd) continue;

            for (Edge e:adj[u]){
                int v=e.to;
                int cost=(st==0)?(e.w2/2):(e.w2*2);
                int nd=cd+cost;
                int nxt=st^1; 
                if (nd<distWolf[nxt][v]) {
                    distWolf[nxt][v]=nd;
                    pq.add(new int[]{nd,v,nxt});
                }
            }
        }
    }

}

