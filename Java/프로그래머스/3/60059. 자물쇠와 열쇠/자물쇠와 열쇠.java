import java.util.*;

class Solution {
    static int N,M,lockSize;
    static int NUM;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        //lockSize를 구한다: 0 개수 
        for (int[] l:lock){
            for (int ll:l){
                if (ll==0) lockSize++;
            }
        }
        
        //자물쇠 
        N=lock[0].length;
        M=key[0].length;
        NUM=2*N+M-2;
        int[][] newKey=new int[NUM][NUM];
        
        for (int i=0;i<M;i++){
            for (int j=0;j<M;j++){
                newKey[i+N-1][j+N-1]=key[i][j];
            }
        }
        
        //확인-rotate-확인.. 순
        return go(newKey,lock);
    }
    
    static boolean go(int[][] curKey,int[][] lock){
        //일치하는게 있으면 종료
        if (check(curKey,lock)) return true;
        
        int cnt=3;
        
        while (cnt>0){
            int[][] temp=new int[NUM][NUM];
            
            //회전한다
            for (int i=0;i<NUM;i++){
                for (int j=0;j<NUM;j++){
                    temp[i][j]=curKey[j][NUM-i-1];
                }
            }
            if (check(temp,lock)) return true;
            
            //다음 작업을 위해 복사한다
            for (int i=0;i<NUM;i++){
                for (int j=0;j<NUM;j++){
                    curKey[i][j]=temp[i][j];
                }
            }
            cnt--;

        }
        return false;
       
    }
    
    static boolean check(int[][] curKey,int[][] lock){
        //열쇠돌기,자물쇠 돌기가 만나는 경우 return false
        boolean flag=false;
        for (int i=0;i<N+M-1;i++){
            for (int j=0;j<N+M-1;j++){
                boolean ret=cal(i,j,curKey,lock);
                
                if (ret){
                    flag=true;
                    break;
                }
            }
            if (flag) break;
        }
        return flag;
        
    }
    
    static boolean cal(int dx,int dy,int[][] key,int[][] lock){
        int tot=0;
        boolean flag=false;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (lock[i][j]==1 && key[i+dx][j+dy]==1){
                    flag=true;
                    break;
                }
                //lock은 0이고 key는 1이어야 한다
                if (lock[i][j]==0 && key[i+dx][j+dy]==1){
                    tot++;
                }
            }
            if (flag==true) break;
        }
        if (flag || tot!=lockSize) return false;
        return true;
    }
    
    
    
    
}