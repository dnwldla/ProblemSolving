import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine(); 
        String temp = new StringBuilder(s).reverse().toString(); 

        if (temp.equals(s)) {
            System.out.println(1); 
        } else {
            System.out.println(0); 
        }
    }
}
