import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++){
            String line=br.readLine();
            String[] ar=line.split("");
            Stack<String> stack=new Stack<>();
            Stack<String> deleteStack=new Stack<>();
            StringBuilder sb=new StringBuilder();

            for (String elem:ar){
                if (elem.equals("<")){
                    if (!stack.isEmpty()){
                        deleteStack.push(stack.pop());
                    }
                }else if(elem.equals(">")){
                    if (!deleteStack.isEmpty()){
                        stack.push(deleteStack.pop());
                    }
                }else if (elem.equals("-")){
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                }else{ //숫자, 문자
                    stack.push(elem);
                    //while (!deleteStack.isEmpty()){
                      //  stack.push(deleteStack.pop());
                    //}
                }
            }
            //나머지 처리
            while (!deleteStack.isEmpty()){
                stack.push(deleteStack.pop());
            }

            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse().toString());
        }
    }
}
