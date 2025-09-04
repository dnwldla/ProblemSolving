import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();

        int T=sc.nextInt();

        for (int i=0;i<T;i++){
            String p=sc.next();
            int n=sc.nextInt();
            String rawAr=sc.next();
            boolean isError=false;

            //문자열 처리해서 덱에 넣는다
            Deque<String> dq=new ArrayDeque<>();
            StringBuilder sb2=new StringBuilder();
            boolean isNew=true;
            for (int j=0;j<rawAr.length();j++){
                char cur=rawAr.charAt(j);
                if (cur=='[') continue;

                else if (cur==']' && !isNew){
                    dq.addLast(sb2.toString());
                }

                if (cur==',' && !isNew){
                    dq.addLast(sb2.toString());
                    sb2=new StringBuilder();
                    isNew=true;
                }
                else if (cur>='0' && cur<='9'){
                    sb2.append(cur);
                    isNew=false;
                }
            }
            //명령을 실행한다
            int rev=-1; //1이면 뒤에서 뺀다 -1이면 앞에서 뺀다
            for (int j=0;j<p.length();j++){
                char cur=p.charAt(j);
                //R 명령
                if (cur=='R'){
                    rev*=-1;
                }
                //D 명령
                else if (cur=='D'){
                    if (dq.isEmpty()){
                        sb.append("error").append("\n");
                        isError=true;
                        break;
                    }
                    if (rev==1){
                        dq.pollLast();
                    }else{
                        dq.pollFirst();
                    }
                }
            }
            int num=dq.size();
            if (!isError){
                sb.append("[");
                while (num>0){
                    //rev면 뒤에서부터 뺀다
                    if (rev==1){
                        sb.append(dq.pollLast());
                    }else{
                        sb.append(dq.pollFirst());
                    }
                    if (num>1) sb.append(",");
                    num--;
                }
                sb.append("]").append("\n");
            }


        }
        System.out.println(sb.toString());
    }

}
