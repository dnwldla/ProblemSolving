import java.util.Scanner;

public class Main {

    static int[] cnt=new int[26];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.next();

          for (int i=0;i<word.length();i++){
              cnt[word.charAt(i)-'a']++;
          }

          for (int i=0;i<26;i++){
              System.out.printf("%d ",cnt[i]);
          }
    }
}
