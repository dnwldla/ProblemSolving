import java.util.*;
import java.io.*;

public class Main {
    static int N,k;

    static class Node{
        int cart;int id;int time;

        public Node(int cart,int id,int time){
            this.cart = cart;
            this.id = id;
            this.time = time;
        }
    }

    static class Customer{
        int id;int time;
        public Customer(int id,int time){
            this.id=id;
            this.time=time;
        }
    }
    public static void main(String[] args) throws Exception {
        long ret=0;

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Customer[] ar=new Customer[N];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            ar[i]=new Customer(id,time);
        }

        PriorityQueue<Node> inputPQ=new PriorityQueue<>((o1,o2)->{
            if (o1.time==o2.time){
                return o1.cart-o2.cart;
            }
            return o1.time-o2.time;

        });
        for (int i=1;i<=k;i++) inputPQ.add(new Node(i,0,0));

        PriorityQueue<Node> outputPQ=new PriorityQueue<>((o1,o2)->{

            if (o1.time==o2.time){
                return o2.cart-o1.cart;
            }
            return o1.time-o2.time;

        });
        //cart ,id, time
        for (int i=0;i<N;i++){
            Customer c=ar[i];

            Node cmp=inputPQ.poll();
            if (cmp.time!=0){
                //update
                outputPQ.add(new Node(cmp.cart,cmp.id,cmp.time));
                cmp.id=c.id;
                cmp.time+=c.time;
                inputPQ.add(cmp);
            }else{
                cmp.id=c.id;
                cmp.time+=c.time;
                inputPQ.add(cmp);

            }
            //print(inputPQ);

        }

        while (!inputPQ.isEmpty()){
            Node cur=inputPQ.poll();
            if (cur.time!=0) outputPQ.add(new Node(cur.cart,cur.id,cur.time));
        }
        int i=1;
        while (!outputPQ.isEmpty()){
            Node cur=outputPQ.poll();
            ret+=(long)i*(long)cur.id;
            i++;
        }
        System.out.println(ret);


    }

public static void print(Queue<Node> inputPQ){
        PriorityQueue<Node> pq=new PriorityQueue(inputPQ);

        while (!pq.isEmpty()){
            Node cur=pq.poll();
            System.out.printf("카트 번호: %d  회원 번호: %d 누적시간: %d\n",cur.cart,cur.id,cur.time);

        }
    System.out.println("end one cycle");
    }

}
