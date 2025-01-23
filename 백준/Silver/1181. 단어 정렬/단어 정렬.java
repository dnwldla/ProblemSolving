import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        HashSet<String> set=new HashSet<>();
        for (int i=0;i<N;i++){
            set.add(sc.next());
        }

        List<String> ar=new ArrayList<>(set);

        ar.sort((o1,o2)->{
            if (o1.length()==o2.length()){
                return o1.compareTo(o2);
            }else{
                return o1.length()-o2.length();
            }
        });

        for (String a:ar){
            System.out.println(a);
        }
    }
}
