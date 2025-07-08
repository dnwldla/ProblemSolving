import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        int ret=0;

        for (int i=0;i<M;i++){
            String s = br.readLine();
            String[] ar=s.split(" ");
            String ins=ar[0];
            int num=0;
            if (ar.length==2){
                num=Integer.parseInt(ar[1]);
            }

            //add
            if (ins.equals("add")){
                ret=ret|(1<<(num-1));
           
            }
            //rempve
            else if (ins.equals("remove")){
                //1이면 0 , 0이면 stay->0으로 바꾸는 건 & 연산
                ret&=~(1<<(num-1));

                //if (cnt[num]==1) cnt[num]=0;
            }

            //check
            else if (ins.equals("check")){
                if ((ret&(1<<(num-1)))!=0) sb.append("1\n");
                else sb.append("0\n");
            }

            //toggle
            else if (ins.equals("toggle")){
                ret=ret^(1<<(num-1));
            }

            else if (ins.equals("all")){
                ret=(1<<20)-1;
            }

            //empty
            else if (ins.equals("empty")){
                ret=0;
            }
        }
        System.out.println(sb);
    }

}
