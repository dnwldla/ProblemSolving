import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] cnt=new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());

        for (int i=0;i<num;i++){
            String player=br.readLine();
            cnt[player.charAt(0)-'a']++;
        }

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<26;i++){
            if (cnt[i]>=5){
                sb.append((char)('a'+i));
            }
        }

        if (sb.toString().isEmpty()){
            sb.append("PREDAJA");
        }

        System.out.println(sb.toString());
    }
}
