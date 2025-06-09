class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int val1=0,val2=0;
       String[] ar=polynomial.split(" ");
        
        for (String s:ar){
            //x일 때
            if (s.contains("x")){
                //계수가 1
                if (s.length()==1) val1++;
                //계수가 2이상
                else val1+=Integer.parseInt(s.substring(0,s.length()-1));
            }
            //숫자일 때
            else if (s.charAt(0)>='1' && s.charAt(0)<='9'){
                val2+=Integer.parseInt(s);
            }
        }
        
        if (val1==1) answer+="x";
        else if (val1>=2) answer+=String.valueOf(val1)+"x";
        
        if (val1==0 && val2==0) return answer;
        else if (val1==0 && val2!=0) answer+=String.valueOf(val2);
        else if (val1!=0 && val2==0) return answer;
        else if (val1!=0 && val2!=0) answer+=" + "+String.valueOf(val2);
        return answer;
    }
}