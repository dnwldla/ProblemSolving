import java.util.*;

public class Main {
    static List<String> ret=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int M=sc.nextInt();

        for (int i=0;i<M;i++){
            String rawInput=sc.next();
            int l=0;
            int r=0;

            while (l<rawInput.length()){
                char c=rawInput.charAt(l);
                if (c<'0' || c>'9'){
                    l++;
                }else{ //l이 숫자인 경우
                   r=l;
                   //r이 문자를 가리킬때까지 움직인다
                   while (r<rawInput.length()&&rawInput.charAt(r)>='0' && rawInput.charAt(r)<='9'){
                       r++;
                   }
                   ret.add(findNumber(rawInput.substring(l,r)));
                   l=r+1;
                }
            }
        }

        Collections.sort(ret, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (o1.length() == o2.length()) {
                            return o1.compareTo(o2); // 사전순
                        }
                        return Integer.compare(o1.length(), o2.length()); // 길이순
                    }
                }
        );

        for (String s:ret){
            System.out.println(s);
        }
    }

    static String findNumber(String temp){
        int l=0;
        int r=temp.length();

        while (l<r-1){
            char c=temp.charAt(l);
            if (c=='0') l++;
            else break;
        }
        return temp.substring(l,r);
    }
}
