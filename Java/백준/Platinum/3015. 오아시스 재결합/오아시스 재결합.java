import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        long h;
        int cnt;
        Pair(long h,int cnt) {
            this.h=h;
            this.cnt=cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());

        Stack<Pair> stack=new Stack<>();
        long ret=0;

        for (int i=0;i<n;i++) {
            long temp=Long.parseLong(br.readLine().trim());

            int cnt=1;
            while (!stack.isEmpty()&&stack.peek().h <= temp) {
                Pair top=stack.peek();
                ret+=top.cnt;

                if(top.h==temp) {
                    cnt=top.cnt+1;
                }else{
                    cnt=1;
                }
                stack.pop();
            }

            if (!stack.isEmpty())ret++;
            stack.push(new Pair(temp, cnt));
        }

        System.out.println(ret);
    }
}
