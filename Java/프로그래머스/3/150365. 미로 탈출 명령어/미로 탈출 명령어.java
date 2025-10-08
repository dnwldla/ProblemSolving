class Solution {
    static int[] dx={1,0,0,-1};
    static int[] dy={0,-1,1,0};
    static String[] s={"d","l","r","u"};
    static int X,Y,R,C,K,N,M;
    static String answer="";

    // 그래프는 1부터 시작
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        X=x;Y=y;R=r;C=c;K=k;N=n;M=m;
        StringBuilder sb=new StringBuilder();

        int dist0 = Math.abs(R - X) + Math.abs(C - Y);
        if (dist0 > K || ((K - dist0) & 1) == 1) return "impossible";

        dfs(x,y,0,sb);
        return answer.isEmpty() ? "impossible" : answer;
    }

    static void dfs(int x,int y,int cnt, StringBuilder sb){
        if (!answer.isEmpty()) return;

        if (cnt==K){
            if (x==R && y==C) answer=sb.toString();
            return;
        }

        int dist=Math.abs(x-R)+Math.abs(y-C);
        int rem = K - sb.length();
        if (dist > rem) return;
        if (((rem - dist) & 1) == 1) return;

        for (int i=0;i<4;i++){
            int nx=x+dx[i], ny=y+dy[i];
            if (outOfRange(nx,ny)) continue;

            sb.append(s[i]);
            dfs(nx,ny,cnt+1,sb);
            if (!answer.isEmpty()) return; 
            sb.deleteCharAt(sb.length()-1);
        }
    }

    static boolean outOfRange(int x,int y){
        return x<=0 || x>N || y<=0 || y>M;
    }
}
