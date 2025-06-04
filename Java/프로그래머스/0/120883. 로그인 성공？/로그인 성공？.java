class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        String id=id_pw[0],pw=id_pw[1];
        for (String[] data:db){
            String dbI=data[0],dbP=data[1];
            
            if (id.equals(dbI) && pw.equals(dbP)){
                answer="login";
                break;
            }else if (id.equals(dbI) && !pw.equals(dbP)){
                answer="wrong pw";
                break;
            }
            
        }
        if (answer.equals("")) answer="fail";
        return answer;
    }
}