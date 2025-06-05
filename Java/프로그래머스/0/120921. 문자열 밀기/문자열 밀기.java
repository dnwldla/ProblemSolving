class Solution {
    public int solution(String A, String B) {
        int answer=-1,n=A.length();
        String temp=A;
        for (int i=0;i<n;i++){
            if (temp.equals(B)){
                return i;
            }
            temp=temp.charAt(n-1)+temp.substring(0,n-1);
        }
        
        return answer;
    }
}