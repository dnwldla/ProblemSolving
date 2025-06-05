import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        Arrays.sort(spell);
        
        for (String d:dic){
            int cnt=0;
            String[] word=d.split("");
            Arrays.sort(word);
            if (word.length!=spell.length){
                continue;
            }
            
            for (int i=0;i<word.length;i++){
                if (word[i].equals(spell[i])) cnt++;
            }
            if (cnt==word.length){
                answer=1;
                break;
            } 
           
        }
        return answer;
    }
}