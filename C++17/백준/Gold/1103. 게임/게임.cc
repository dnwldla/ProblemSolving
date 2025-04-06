#include <bits/stdc++.h> 
using namespace std; 
static int N,M,visited[50][50];
static long long cnt[50][50],ret;
static char graph[50][50];
int dx[4]={1,-1,0,0},dy[4]={0,0,-1,1};
int changeToInt(char c){
    return c-'0';
}

void dfs(int x,int y,int tot){
    if (x<0 || x>=N||y<0||y>=M) return;
    if (graph[x][y]=='H') return;
    if (visited[x][y]){
        cout<<-1<<"\n";
        exit(0);
    }

    if (cnt[x][y]>=tot) return;
    cnt[x][y]=tot;
    visited[x][y]=1;
    int move=changeToInt(graph[x][y]);
    for (int i=0;i<4;i++){
        int nx=x+dx[i]*move;
        int ny=y+dy[i]*move;

        dfs(nx,ny,tot+1);
    }
    visited[x][y]=0;

}
int main(){
    cin>>N>>M;
    for (int i=0;i<N;i++){
        for (int j=0;j<M;j++){
            cin>>graph[i][j];
        }
    }
    dfs(0,0,1);

    for (int i=0;i<N;i++){
        for (int j=0;j<M;j++){
            ret=max(ret,(long long)cnt[i][j]);
        }
    }
    
    cout<<ret;
    
  
}