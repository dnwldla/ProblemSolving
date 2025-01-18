import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] ret = new int[n];
        Stack<Integer> s = new Stack<>();

        // 배열 초기화
        Arrays.fill(ret, -1);

        // 입력 처리
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

            // 스택의 최상단 값과 비교
            while (!s.isEmpty() && a[s.peek()] < a[i]) {
                ret[s.pop()] = a[i];
            }

            // 현재 인덱스를 스택에 추가
            s.push(i);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(ret[i]).append(' ');
		}
		
		System.out.println(sb);
    }
}