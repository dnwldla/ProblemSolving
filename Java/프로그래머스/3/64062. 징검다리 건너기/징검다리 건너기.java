class Solution {
    static int MAX=200000001;
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        //이분탐색으로 니니즈 수를 찾는다
        //다 건널 수 있으면 lo=mid+1 else hi=mid-1
        //같다면 니니즈를 줄여야 한다 
        int lo=0,hi=MAX,mid=0;
        
        while (lo<=hi){
            mid=(lo+hi)/2; //임시 니니즈 수
            
            int ret=check(stones,mid,k);
           // System.out.println(mid+" "+ret);
            if (ret<k){
                answer=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
            
        }
        
        return answer;
        
    }
    
    static int check(int[] stones,int n,int k){
        //연속된 0 이하 개수를 찾는다
        int psum=0;
        for (int stone:stones){
            int result=stone-n;
            
            //result이 0 이하면 누적합 
            if (result<0){
                psum++;
            }
            //result이 0 초과면 비교& 초기화
            else if (result>=0){
                if (psum>=k) break;
                psum=0;
            }
        }
        
        return psum;
    }
    
    
}