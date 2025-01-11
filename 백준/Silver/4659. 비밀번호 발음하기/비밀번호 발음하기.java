import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean isMo(char c){
        if (c=='i' || c=='a' || c=='e'|| c=='o'||c=='u') return true;
        return false;
    }

    static boolean isSameType(char c1,char c2){
        if (isMo(c1)&&isMo(c2)) return true;
        if (!isMo(c1)&&!isMo(c2)) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String rawInput=br.readLine();
            int pointer=0;
            int totalMo=0;
            boolean acceptable=true;
            if (rawInput.equals("end")){
                break;
            }

            for (int i=0;i<rawInput.length();i++){
                char c=rawInput.charAt(i);
                //첫번쨰 글자일때
                if (i==0){
                    if(isMo(c)){
                        totalMo+=1;
                    }
                    pointer=1;
                }
                //첫번째 글자가 아닐때
                else if (i!=0){
                    char bf=rawInput.charAt(i-1);
                    //이전글자와 같은 경우
                    if (c==bf){
                        if (pointer==1 && (c=='o' || c=='e')){
                            pointer+=1;
                        }else{
                            System.out.printf("<%s> is not acceptable.\n",rawInput);
                            acceptable=false;
                            break;
                        }
                    }
                    //이전글자와 다른 경우
                    else if (c!=bf){
                        if (isSameType(c,bf)){ //같은 형이면
                            if (pointer==2){
                                System.out.printf("<%s> is not acceptable.\n",rawInput);
                                acceptable=false;
                                break;
                            }
                            pointer+=1;
                        }else if (!isSameType(c,bf)){ //다른형이면
                            totalMo+=1;
                            pointer=1;
                        }
                    }
                }

            }

            if (acceptable){
                if (totalMo==0){
                    System.out.printf("<%s> is not acceptable.\n",rawInput);
                }else{
                    System.out.printf("<%s> is acceptable.\n",rawInput);
                }
            }


        }
    }
}
