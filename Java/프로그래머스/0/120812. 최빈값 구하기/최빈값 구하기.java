import java.util.*;

class Pair{
    int first; int second;
    
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
    
    int getFirst(){
        return this.first;
    }
    int getSecond(){
        return this.second;
    }
}

class Solution {
    public int solution(int[] array) {
        List<Pair> ar=new ArrayList<>();
        
        int answer = 0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int a:array){
            if (!map.containsKey(a)) map.put(a,1);
            else{
                int val=map.get(a); val++;
                map.put(a,val);
            }
        }
        
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            ar.add(new Pair(entry.getKey(),entry.getValue()));
        }
        
        ar.sort((o1,o2)->{
            return o2.getSecond()-o1.getSecond();
        });
        if (ar.size()==1) return ar.get(0).getFirst();
        if (ar.get(0).getSecond()==ar.get(1).getSecond()) return -1;
        answer=ar.get(0).getFirst();
        return answer;
    }
}