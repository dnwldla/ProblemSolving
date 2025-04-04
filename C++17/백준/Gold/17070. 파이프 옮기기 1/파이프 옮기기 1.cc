#include <bits/stdc++.h> 
using namespace std; 
static int N,graph[17][17];
static long long cnt[17][17][3];

bool checkSpace(int i,int j,int dir){
    //공통
    if (graph[i][j]==1) return false;
    if (dir==0 && graph[i][j+1]==1) return false;
    if (dir==1 && graph[i+1][j]==1) return false;
    if (dir==2 && (graph[i][j+1]==1 ||graph[i+1][j]==1 || graph[i+1][j+1]==1)) return false;
    return true;
}

bool checkRange(int i,int j){
    if (graph[i][j]==1) return false;
    return true;
}
int main(){
    cin>>N;
    memset(graph,1,sizeof(graph));
    for (int i=1;i<=N;i++){
        for (int j=1;j<=N;j++){
            cin>>graph[i][j];
        }
    }
    //0:가로, 1은 세로, 2는 대각선
    cnt[1][1][0]=1;

    for (int i=1;i<=N;i++){
        for (int j=1;j<=N;j++){
            //가로
            if (checkSpace(i,j,0)){
                //이전이 대각선
                if (checkRange(i-1,j-1)) cnt[i][j][0]+=cnt[i-1][j-1][2];
                //이전이 가로
                if (checkRange(i,j-1)) cnt[i][j][0]+=cnt[i][j-1][0];
            }
            //세로
            if (checkSpace(i,j,1)){
                 //이전이 대각선
                 if (checkRange(i-1,j-1)) cnt[i][j][1]+=cnt[i-1][j-1][2];

                  //이전이 세로
                if (checkRange(i-1,j)) cnt[i][j][1]+=cnt[i-1][j][1];
            }
            //대각선
            if (checkSpace(i,j,2)){
                //이전이 대각선
                if (checkRange(i-1,j-1)) cnt[i][j][2]+=cnt[i-1][j-1][2];

                //이전이 세로
              if (checkRange(i-1,j)) cnt[i][j][2]+=cnt[i-1][j][1];
                //이전이 가로
                if (checkRange(i,j-1)) cnt[i][j][2]+=cnt[i][j-1][0];
            }
        }
    }
    
    cout<<cnt[N-1][N-1][2]+cnt[N][N-1][0]+cnt[N-1][N][1];



}
