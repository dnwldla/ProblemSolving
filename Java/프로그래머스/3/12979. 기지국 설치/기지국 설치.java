import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int ans=0;

        int size=stations.length;
        int mod=2*w+1;

        for (int i=0;i<size;i++){ // i=0,1, size=2
            if(i==0){ // 첫번째 구간
                int start=stations[i]-w-1;

                // 음수라면 continue
                if(start<=0) continue;

                ans+=(start+mod-1)/mod;
            } else{ // 중간값이라면
                int prev=stations[i-1];
                int cur=stations[i];

                int start=prev+w+1;
                int end=cur-w-1;

                // 차이가 음수라면
                if(start>end) continue;

                int diff=end-start+1;
                ans+=(diff+mod-1)/mod;
            }
        }

        // 마지막 시작위치
        int end=stations[size-1]+w+1;
        if (end<=n) {
            int diff=n-end+1;
            ans+=(diff+mod-1)/mod;
        }

        return ans;
    }
}
