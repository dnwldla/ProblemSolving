class Solution {
    static int MAX=200000001;
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        //이분탐색으로 니니즈 수를 찾는다
        //다 건널 수 있으면 lo=mid+1 else hi=mid-1
        
        int lo=0,hi=MAX,mid=0;
        
        while (lo<=hi){
            mid=(lo+hi)/2;
            if (check(mid,stones,k)){ //다 건널 수 없으면->니니즈를 줄여야 함
                hi=mid-1;
            }else{
                lo=mid+1;
                answer=mid;
            }
        }
        
        return answer;
        
    }
    
    static boolean check(int cnt,int[] stones, int k){
        int temp=0;
        
        //건널 수 있는지 확인
        for (int s:stones){
            if (s-cnt<0){
                temp++;
            }else temp=0;
            
            if (temp==k) return true;
        }
    
        if (temp==k) return true;
        else return false;
        
    }
}