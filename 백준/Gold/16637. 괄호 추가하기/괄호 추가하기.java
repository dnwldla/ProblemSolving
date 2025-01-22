import java.util.*;

public class Main {
    static List<Integer> num=new ArrayList<>();
    static List<Character> operator=new ArrayList<>();
    static int N;
    static int ret=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        String s=sc.next();

        for (int i=0;i<N;i++){
            if (i%2==0){
                num.add(s.charAt(i)-'0');
            }else{
                operator.add(s.charAt(i));
            }
        }

        go(0,num.get(0));
        System.out.println(ret);

    }
    static void go(int here,int currentNum){
        //마지막 수일 때
        if (here==num.size()-1){
            ret=Math.max(ret,currentNum);
            return;
        }

        //현재 숫자를 다음숫자와 연산
        go(here+1,calculate(operator.get(here),currentNum,num.get(here+1)));

        //다음 두 숫자를 먼저 계산
        if (here+2<=num.size()-1){
            int tmp=calculate(operator.get(here+1),num.get(here+1),num.get(here+2));
            go(here+2,calculate(operator.get(here),currentNum,tmp));
        }
    }

    static int calculate(char op, int a, int b) {
        switch (op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
        }
        return -1;
    }


}
