import java.util.Scanner;

public class Main {
    //r은 행, c는 열
    static int r1,c1,r2,c2;
    static int[][] ret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r1 = sc.nextInt(); c1 = sc.nextInt(); r2 = sc.nextInt(); c2 = sc.nextInt();
        ret=new int[r2-r1+1][c2-c1+1];
        int maxNum=0;
        for (int i=0;i<=r2-r1;i++){
            for (int j=0;j<=c2-c1;j++){
                ret[i][j]=check(i+r1,j+c1);
                maxNum=Math.max(maxNum,ret[i][j]);
            }
        }

        int maxLen=String.valueOf(maxNum).length();
        StringBuilder sb=new StringBuilder();

        for (int i=0;i<=r2-r1;i++){
            for (int j=0;j<=c2-c1;j++){
                //일관되게 출력
                int diff=maxLen-String.valueOf(ret[i][j]).length();
                for (int k=0;k<diff;k++) sb.append(" ");
                sb.append(ret[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());


    }

    static int check(int r,int c){
        int ret=0;
        //행, 열 중 큰 값의 section을 찾는다
        int num=Math.max(Math.abs(r),Math.abs(c));

        int minX=num*-1,minY=num*-1;

        //구간의 좌상단, 우하단을 구한다
        int low=(num*2)*(num*2)+1;

        //좌표값 차이를 구한다
        int val=Math.abs(minX-r)+Math.abs(minY-c);

        //행이 num이거나 열이 Num((num,num)은 제외)
        if ((c==num && r!=num)||r==minX){
            ret=low-val;
        }else{
            ret=low+val;
        }
        return ret;
    }

}
