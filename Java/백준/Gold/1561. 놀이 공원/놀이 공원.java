import java.io.*;
import java.util.*;

public class Main {
    //hit: 기구들을 개별적으로 관리하지 않아도 되는게 어려웠음
    static long n, m;
    static long[] ar;
    static final long HI = 60000000004L;

    static boolean check(long mid){
        long temp=m; //시간 0에 m명 탑승

        for (int i=0;i<m;i++){
            temp+=mid/ar[i]; //시간 당 몇명이 탈 수 있는지
            if (temp>=n) return true;
        }
        return temp>=n; //정해진 학생 수보다 많은 학생이 탔다-> mid를 줄여야 한다
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n, m
        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());

        ar=new long[(int)m]; //놀이기구 개수

        String[] s=br.readLine().split(" ");
        for (int i=0;i<m;i++){
            ar[i]=Long.parseLong(s[i]);
        }
        
         if (n<=m){
            System.out.println(n);
            return;
        }

        long lo=0,hi=HI,ret=0;//ret은 최적의 시간

        while (lo<=hi){
            long mid=(lo+hi)/2;

            if (check(mid)){ //학생수보다 많다면
                hi=mid-1;
                ret=mid;
            }else{
                lo=mid+1;
            }

        }

        long temp=m;
        for (int i=0;i<m;i++){
            temp+=(ret-1)/ar[i];
        }

        for (int i=0;i<m;i++){
            if (ret%ar[i]==0) temp++;
            if (temp==n){
                System.out.println(i+1);
                break;
            }
        }
    }
}
