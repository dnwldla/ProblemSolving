import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());

        for (int i=0;i<tc;i++){
            int N=Integer.parseInt(br.readLine());

            Map<String,Integer> map=new HashMap<>();
            int result=1;

            for (int j=0;j<N;j++){
                String kind=br.readLine().split(" ")[1];
                map.put(kind,map.getOrDefault(kind,0)+1);
            }

            for (Map.Entry<String,Integer> entry:map.entrySet()){
                result*=(entry.getValue()+1);
            }
            System.out.println(result-1);
        }
    }
}
