import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        for (int i=0;i<N;i++){
            String[] rawInput=br.readLine().split("");
            Stack<String> s=new Stack<>();
            boolean flag=false;
            for (int j=0;j<rawInput.length;j++){
                if (rawInput[j].equals("(")) s.push(rawInput[j]);
                else{
                    if (s.isEmpty()){
                        flag=true;
                    }
                    else s.pop();
                }
            }
            if (s.isEmpty()&&!flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
