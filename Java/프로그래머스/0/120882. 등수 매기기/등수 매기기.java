import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
       
        int n=score.length;
         int[] answer = new int[n];
        //평균 구하기
        float[] avg=new float[n];
        
        for (int i=0;i<n;i++){
            avg[i]=(float)((score[i][0]+score[i][1])/2.0);
        }
        for (int i=0;i<n;i++){
            int rank=1;
            for (int j=0;j<n;j++){
                if (i==j) continue;
                if (avg[i]<avg[j]) rank++;
            }
            answer[i]=rank;
        }
        return answer;
    }
}