import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int cnt=Integer.parseInt(br.readLine());
        String pattern=br.readLine();

        int idx=pattern.indexOf("*");
        String startPattern=pattern.substring(0,idx);
        String endPattern=pattern.substring(idx+1);
        for (int i=0;i<cnt;i++){
            String word=br.readLine();
            if (startPattern.length()+endPattern.length()>word.length()){
                System.out.println("NE");
            }
            else if(word.startsWith(startPattern)&& word.endsWith(endPattern)){
                System.out.println("DA");
            }else{
                System.out.println("NE");
            }
        }

    }
}