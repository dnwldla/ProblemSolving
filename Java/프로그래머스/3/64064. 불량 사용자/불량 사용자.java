import java.util.*;

class Solution {
    static int N,M,ret;
    static boolean[] visited;
    static Set<Integer> s=new HashSet<>();
    static int[] arr;
    static String[] ban_id;
    static String[] user;
    public int solution(String[] user_id, String[] banned_id) {
        N=user_id.length;
        M=banned_id.length;
        visited=new boolean[N+1];
        ban_id=banned_id;
        user=user_id;
        arr=new int[N+1];
        
        findCase(0);
        
        return ret;
    }
    
    static boolean check(String s1,String s2){
        if (s1.length()!=s2.length()) return false;
        
        for (int i=0;i<s1.length();i++){
            if (s2.charAt(i)=='*') continue;
            
            if (s1.charAt(i)!=s2.charAt(i)) return false;
        }
        return true;
    }
    
    
    //순열 찾기
    static void findCase(int cnt){
         if (cnt==M){
            int result=0;
            boolean notSame=false;
            
            //순열 순이 banned_id와 같은지 확인한다
            for (int i=0;i<M;i++){
                boolean same=check(user[arr[i]],ban_id[i]);
                
                if (!same){
                    notSame=true; break;
                }
            }
            //같다면 비트마스킹으로 추가한다 else 담지 않는다
            if (!notSame){
                int bitmask=0;
                //인덱스 비트마스킹
                for (int i=0;i<M;i++) bitmask|=(1<<arr[i]);
                
                if (!s.contains(bitmask)){
                    s.add(bitmask);
                    ret++;
                } 
            }
        }
        
        for (int i=0;i<N;i++){
            if (!visited[i]){
                visited[i]=true;
                arr[cnt]=i;
                findCase(cnt+1);
                visited[i]=false;
            }
        }
    }
}