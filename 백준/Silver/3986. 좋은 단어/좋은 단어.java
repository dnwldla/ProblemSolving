import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        int ret=0;
        for (int i=0;i<N;i++){
            String s=sc.next();
            Stack<Character> q=new Stack<>();
            for (int j=0;j<s.length();j++){
                char c=s.charAt(j);
                if (!q.isEmpty()&&q.peek()==c){
                    q.pop();
                }else{
                    q.push(c);
                }
            }
            if (q.isEmpty()) ret++;
        }
        System.out.println(ret);
    }
}