import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);

        int N =sc.nextInt();
        int minDan = sc.nextInt();
        int minFat = sc.nextInt();
        int minTan = sc.nextInt();
        int minVit = sc.nextInt();

        int[][] arr = new int[N][5];

        for(int i = 0; i < N; i++){

            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            arr[i][3] = sc.nextInt();
            arr[i][4] = sc.nextInt();
        }

        int max = (1 << N);

        int minCost = Integer.MAX_VALUE;
        String resultSet = "-1";

        for(int i = 0; i < max; i++){
            int sumDan = 0;
            int sumFat = 0;
            int sumTan = 0;
            int sumVit = 0;
            int sumCost = 0;

            StringBuilder set = new StringBuilder();
            for(int j = 0; j < N; j++){
                if((i & (1 << j)) != 0){
                    sumDan += arr[j][0];
                    sumFat += arr[j][1];
                    sumTan += arr[j][2];
                    sumVit += arr[j][3];
                    sumCost += arr[j][4];

                    set.append((j + 1)).append(" ");
                }

            }

            if(minDan <= sumDan && minFat <= sumFat && minTan <= sumTan && minVit <= sumVit){
                if(minCost >= sumCost){
                    if(minCost == sumCost){
                        if(resultSet.compareTo(set.toString()) > 0){
                            resultSet = set.toString();
                        }
                    } else{
                        minCost = sumCost;
                        resultSet = set.toString();
                    }
                }
            }
        }

        if(minCost == Integer.MAX_VALUE){
            System.out.println(resultSet);
        } else{
            System.out.println(minCost);
            System.out.println(resultSet);
        }
    }
}