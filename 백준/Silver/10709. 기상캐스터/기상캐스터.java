import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String[][] graph;
    static int[][] ret;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] rawInput=br.readLine().split(" ");
        int H=Integer.parseInt(rawInput[0]);
        int W=Integer.parseInt(rawInput[1]);

        graph=new String[H][W];
        ret=new int[H][W];
        for (int i=0;i<H;i++){
            String[] input=br.readLine().split("");
            for (int j=0;j<W;j++){
                graph[i][j]=input[j];
            }
        }

        //로직 시작
        for (int i=0;i<H;i++){
            int idx=-1;
            for (int j=0;j<W;j++){
                if (graph[i][j].equals("c")){
                    idx=0;
                }else{
                    if (idx>=0){
                        idx++;
                    }
                }
                ret[i][j]=idx;
            }
        }

        for (int i=0;i<H;i++){
            for (int j=0;j<W;j++){
               System.out.printf(ret[i][j]+" ");
            }
            System.out.println();
        }
    }
}
