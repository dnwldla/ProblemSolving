import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        int answer=0;

        String[] rawInput=br.readLine().split(" ");
        int[] ar=new int[N];

        for (int i=0;i<N;i++){
            ar[i]=Integer.parseInt(rawInput[i]);
        }

        Arrays.sort(ar);

        int left=0;
        int right=ar.length-1;

        while (left<right){
            if (ar[left]+ar[right]<M){
                left++;
            }else if (ar[left]+ar[right]==M){
                left++;
                right--;
                answer++;
            }else{
                right--;
            }
        }

        System.out.println(answer);
    }
}
