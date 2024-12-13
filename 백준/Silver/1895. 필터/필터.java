import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] image;

    static int findImage(int idx1,int idx2){
        List<Integer> bfSort=new ArrayList<>();
        for (int i=idx1;i<idx1+3;i++){
            for (int j=idx2;j<idx2+3;j++){
                bfSort.add(image[i][j]);
            }
        }
        Collections.sort(bfSort);

        return bfSort.get(4);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int R=Integer.parseInt(input[0]);
        int C=Integer.parseInt(input[1]);
        image=new int[R][C];

        //입력
        for (int i=0;i<R;i++){
            String[] rawInput=br.readLine().split(" ");
            for (int j=0;j<C;j++){
                image[i][j]=Integer.parseInt(rawInput[j]);
            }
        }

        int T=Integer.parseInt(br.readLine());
        List<Integer> ans=new ArrayList<>();
        
        for (int i=0;i<=R-3;i++){
            for (int j=0;j<=C-3;j++){
                ans.add(findImage(i,j));
            }
        }
     
        int count=0;
        for (Integer elem:ans){
            if (elem>=T){
                count++;
            }
        }
        System.out.println(count);
    }
}
