import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] ar=new int[N];
        String[] rawInputs=br.readLine().split(" ");

        //예산요청
        for (int i=0;i<N;i++){
            ar[i]=Integer.parseInt(rawInputs[i]);
        }
        //총 예산
        int M=Integer.parseInt(br.readLine());

        //로직 시작
        Arrays.sort(ar);
        long total=Arrays.stream(ar).sum();
        int maxMoney=0;

        //케이스별 상한액
        long onProcess=M/N;

        if (total<=M){
            maxMoney=ar[N-1];
            System.out.println(maxMoney);
        }else if (total>M){
            for (int i=0;i<N-1;i++){
                M-=ar[i];
                onProcess=Math.max(onProcess,M/(N-i-1));
            }
            System.out.println(onProcess);

        }
    }
}