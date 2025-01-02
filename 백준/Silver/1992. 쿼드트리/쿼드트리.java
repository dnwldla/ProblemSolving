import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        graph=new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 한 줄 읽기
            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j); // 문자를 숫자로 변환
            }
        }

        System.out.println(go(0,0,N));
    }

    static String go(int sx,int sy,int size){
        StringBuffer br=new StringBuffer();
        boolean isEqual=checkEqual(sx,sy,size);

        if (isEqual){
            br.append(graph[sx][sy]);
        }else if (!isEqual){
            br.append("(");
            br.append(go(sx, sy, size / 2));
            br.append(go(sx, sy + size / 2, size / 2));
            br.append(go(sx + size / 2, sy, size / 2));
            br.append(go(sx + size / 2, sy + size / 2, size / 2));
            br.append(")");
        }
        return br.toString();
    }

    static boolean checkEqual(int x,int y,int size){
        char ret=graph[x][y]; //기준값
        for (int i=x;i<x+size;i++){
            for (int j=y;j<y+size;j++){
                if (graph[i][j]!=ret){
                    return false;
                }
            }
        }
        return true;
    }
}
