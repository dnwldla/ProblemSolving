class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len=s.length();
        for (int i=1;i<=len;i++){
            String cmp=null; String cur=null;
            int cnt=0; //이게 맞냐
            StringBuilder sb=new StringBuilder();
            for (int j=0;j<len;j+=i){
                int last=Math.min(j+i,len);
                cur=s.substring(j,last);
                
                if (cmp==null){// 첫번째 chunk일 때
                    cnt=1; cmp=cur;
                }else{ //두번째 이상일 때
                    //cmp과 같으면 cnt를 update하고 넘어간다
                    if (cur.equals(cmp)){
                        cnt++;
                    }else{ //cur과 다르면 기존의 cmp, cnt를 append하고 cnt와 cmp을 초기화한다
                        if (cnt==1) sb.append(cmp);
                        else sb.append(cnt).append(cmp);
                        
                        cnt=1;
                        cmp=cur;
                        
                    }
                    
                }
                
            }
            //제일 마지막을 append 한다
          //  System.out.printf("%s %d\n",cur,cnt);
            if (cnt==1) sb.append(cur);
            else sb.append(cnt).append(cur);
            answer=Math.min(answer,sb.toString().length());
            
            
        }
        return answer;
    }
}