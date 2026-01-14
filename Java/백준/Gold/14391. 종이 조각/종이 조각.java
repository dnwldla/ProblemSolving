import java.util.Scanner;

public class Main {
    static int N,M;
    static int[][] ar;
    static int ret=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt(); M=sc.nextInt();
        ar=new int[N][M];

        //입력
        for (int i=0;i<N;i++){
            String s=sc.next();
            for (int j=0;j<M;j++){
                ar[i][j]=s.charAt(j)-'0';
            }
        }
        for (int i=0;i<(1<<(N*M));i++){
            int tot1=0;
          //  System.out.printf("cur %d\n",i);
            for (int p=0;p<N;p++){
                int psum=0,sum=0;
                for (int q=0;q<M;q++){
                    int idx2=M*p+q;

                    if ((i&(1<<idx2))==0) {
                        psum=psum*10+ar[p][q];
                    }else{ //1이면 이전을 누적한다
                        sum+=psum;
                        psum=0;

                    }
                }
                //제일 마지막
                sum+=psum;
              //  System.out.printf("가로에서 행 별 합: %d\n",sum);
                tot1+=sum;
            }

            //세로 구하기
            int tot2=0;
            for (int p=0;p<M;p++){
                int psum2=0;int sum2=0;
                for (int q=0;q<N;q++){ //행
                    int idx2=M*q+p;

                    if ((i&(1<<idx2))!=0) {
                        psum2=psum2*10+ar[q][p];
                    }else{ //0이라면
                        sum2+=psum2;
                        psum2=0;

                    }
                }
                //제일 마지막
                sum2+=psum2;
              //  System.out.printf("세로에서 열 별 합: %d\n",sum2);
                tot2+=sum2;
            }
           ret=Integer.max(ret,tot1+tot2);

        }
        System.out.println(ret);


    }

    static void print() {
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                System.out.printf("%d ",ar[i][j]);
            }
            System.out.println();
        }
    }


}
