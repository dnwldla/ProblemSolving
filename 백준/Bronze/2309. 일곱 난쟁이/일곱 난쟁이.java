import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int[] a = new int[9];
    static int n = 9, r = 7;

    public static void solve() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            sum += a[i];
        }
        if (sum == 100) {
            Arrays.sort(a, 0, 7); 
            for (int i = 0; i < r; i++) {
                System.out.println(a[i]);
            }
            System.exit(0);
        }
    }

    public static void makePermutation(int n, int r, int depth) {
        if (r == depth) {
            solve();
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(i, depth);
            makePermutation(n, r, depth + 1);
            swap(i, depth);
        }
    }

    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        makePermutation(n, r, 0);
    }
}