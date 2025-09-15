import java.util.*;

class Solution {
    static int N,M,ret;
    static List<Integer> ar;
    static boolean[] visited;
    static Set<Integer> s=new HashSet<>();
    static String[] ban_id;
    static String[] user;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        N=user_id.length;
        M=banned_id.length;
        ar=new ArrayList<>();
        visited=new boolean[N+1];
        ban_id=banned_id;
        user=user_id;
        
        for (int i=1;i<=N;i++){
            visited[i]=true;
            ar.add(i);
            findCase(i,1);
            visited[i]=false;
            ar.remove(ar.size()-1);
        }
        
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
    static void findCase(int cur,int cnt){
        if (cnt==M){
            int result=0;
            boolean notSame=false;
            
            //순열 순이 banned_id와 같은지 확인한다
            for (int i=0;i<M;i++){
                boolean same=check(user[ar.get(i)-1],ban_id[i]);
                
                if (!same){
                    notSame=true; break;
                }
            }
            //같다면 비트마스킹으로 추가한다 else 담지 않는다
            boolean add=false;
            if (!notSame){
                int bitmask=0;
                add=false;
                //인덱스 비트마스킹
                for (Integer a:ar) bitmask|=(1<<a);
                
                if (!s.contains(bitmask)){
                    s.add(bitmask);
                    ret++;
                    add=true;
                } 
            }
          
            
            
           
        }
        
        for (int i=1;i<=N;i++){
            if (i==cur) continue;
            if (!visited[i]){
                visited[i]=true;
                ar.add(i);
                findCase(i,cnt+1);
                ar.remove(ar.size()-1);
                visited[i]=false;
            }
        }
    }
}