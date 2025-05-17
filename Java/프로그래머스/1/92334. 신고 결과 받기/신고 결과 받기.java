import java.util.*;

class Solution {
   
    public int[] solution(String[] id_list, String[] report, int k) {
       
         Map<String,Integer> s2i=new HashMap<>();
        int n=id_list.length;
       
         int[] answer = new int[n];
        List<Set<Integer>> s=new ArrayList<>();
        List<Integer> cnt;
        
        for (int i=0;i<n;i++){
            s2i.put(id_list[i],i);
            s.add(new HashSet<>());
        }
        
        for (String r:report){
            String[] tmp=r.split(" ");
            
            s.get(s2i.get(tmp[1])).add(s2i.get(tmp[0]));
          
        }
        
        for (int i=0;i<n;i++){
            if (s.get(i).size()<k) continue;
            for (Integer a:s.get(i)) answer[a]++;
        }
        return answer;
    }
}