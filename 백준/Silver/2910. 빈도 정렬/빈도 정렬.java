import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] a = new int[n];

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> firstOccurrenceMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            frequencyMap.put(a[i], frequencyMap.getOrDefault(a[i], 0) + 1);
            if (!firstOccurrenceMap.containsKey(a[i])) {
                firstOccurrenceMap.put(a[i], i + 1);
            }
        }

        List<int[]> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            freqList.add(new int[]{entry.getValue(), entry.getKey()});
        }

        freqList.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(firstOccurrenceMap.get(o1[1]), firstOccurrenceMap.get(o2[1]));
            }
            return Integer.compare(o2[0], o1[0]);
        });

        StringBuilder result = new StringBuilder();
        for (int[] pair : freqList) {
            int count = pair[0];
            int value = pair[1];
            for (int j = 0; j < count; j++) {
                result.append(value).append(" ");
            }
        }

        System.out.println(result.toString().trim());
        sc.close();
    }
}