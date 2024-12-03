import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer,String> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] raw=br.readLine().split(" ");
        int N=Integer.parseInt(raw[0]);
        int M=Integer.parseInt(raw[1]);

        for (Integer i=1;i<=N;i++){
            String pocketmon=br.readLine();
            map1.put(i,pocketmon);
            map2.put(pocketmon,i);
        }
        //출력
        for (int i=0;i<M;i++){
            String input=br.readLine();

            //문자라면 숫자를 출력한다
            if (input.charAt(0)>='A' && input.charAt(0)<='Z'){
                System.out.println(map2.get(input));
            }else{ //숫자라면 문자를 출력한다
                int idx=Integer.parseInt(input);
                System.out.println(map1.get(idx));
            }
        }
    }
}
