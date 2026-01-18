import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        int[] ar=new int[n];
        Stack<Integer> st=new Stack<>();
        for (int i=0;i<n;i++){
            char c=s.charAt(i);

            if (c=='('){
                st.push(i);
            }

            else if (c==')'){
               if (!st.isEmpty()){
                   int top=st.peek();
                   ar[top]=ar[i]=1;
                   st.pop();

               }
            }

        }
        int cnt=0,ret=0;
        for (int i=0;i<n;i++){
            if (ar[i]==1) cnt++;
            else{
                ret=Math.max(ret,cnt);
                cnt=0;
            }
        }
        ret=Math.max(ret,cnt);
        System.out.println(ret);

    }

}
