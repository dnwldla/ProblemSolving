import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int team1=0,team2=0; //점수
        int ret1=0,ret2=0; //시간
        String prevTime="";
        for (int i=1;i<=N;i++){
            String[] rawInput=br.readLine().split(" ");

            int team=Integer.parseInt(rawInput[0]);
            String curTime=rawInput[1];

            if (team1>team2){
                ret1+=convertTime(prevTime,curTime);
            }else if (team1<team2){
                ret2+=convertTime(prevTime,curTime);
            }
            prevTime=curTime;

            //점수 부여
            if (team==1) team1++;
            else team2++;
        }
        if (team1>team2) ret1+=convertTime(prevTime,"48:00");
        else if(team1<team2) ret2+=convertTime(prevTime,"48:00");

        int min1=ret1/60;
        int sec1=ret1%60;
        int min2=ret2/60;
        int sec2=ret2%60;

        System.out.printf("%02d:%02d\n",min1,sec1);
        System.out.printf("%02d:%02d",min2,sec2);
    }

    static int convertTime(String prev,String cur){
        String curT[]=cur.split(":");
        String prevT[]=prev.split(":");
        int curTime=Integer.parseInt(curT[0])*60+Integer.parseInt(curT[1]);
        int prevTime=Integer.parseInt(prevT[0])*60+Integer.parseInt(prevT[1]);
        return curTime-prevTime;
    }
}
