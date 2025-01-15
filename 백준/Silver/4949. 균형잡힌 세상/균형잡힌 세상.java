import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String[] rawInput=br.readLine().split("");
            if (rawInput[0].equals(".")) break;

            if (check(rawInput)) System.out.println("yes");
            else System.out.println("no");
        }
    }

    static boolean check(String[] ar){
        Stack<String> s=new Stack<>(); //소괄호


        for (int i=0;i<ar.length;i++){
            if (ar[i].equals("(") || ar[i].equals("[")) s.push(ar[i]);

            else if (ar[i].equals(")")){
                if (s.isEmpty()) return false;
                else if (s.peek().equals("(")) s.pop();
                else if (s.peek().equals("[")) return false;
            }
            else if (ar[i].equals("]")){
                if (s.isEmpty()) return false;
                else if (s.peek().equals("[")) s.pop();
                else if (s.peek().equals("(")) return false;
            }
        }

        if (!s.isEmpty()) return false;
        return true;
    }
}
