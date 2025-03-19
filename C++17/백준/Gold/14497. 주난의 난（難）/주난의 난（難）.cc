#include<bits/stdc++.h>
using namespace std; 
char graph[301][301];
bool visited[301][301],flag;
int N, M, startX, startY, endX, endY,ret; 
queue<pair<int,int>> q,temp_q;
int dx[4]={0,0,-1,1},dy[4]={1,-1,0,0};

int main() {
    cin >> N >> M;
    cin >> startX >> startY >> endX >> endY;

    for (int i = 1; i <=N; i++) {
        for (int j = 1; j <= M; j++) {
            cin >> graph[i][j];
        }
    }
    q.push({startX,startY});
    visited[startX][startY]=true;

    while (true){
        while (q.size()){
            
            pair<int,int>cur=q.front(); q.pop();
            int curX=cur.first;
            int curY=cur.second;

            if (curX==endX && curY==endY){
                flag=true;
                break;
            }
            for (int i=0;i<4;i++){
                int nx=curX+dx[i];
                int ny=curY+dy[i];

                if (nx<=0 || nx>N || ny<=0 || ny>M) continue;
                if (visited[nx][ny]) continue;

                if (graph[nx][ny]=='0'){
                    q.push({nx,ny});
                    
                } 
                else if (graph[nx][ny]=='1'||graph[nx][ny]=='#') temp_q.push({nx,ny});

                visited[nx][ny]=true;

            }
        }
        if (flag) break;
        ret++;
        q=temp_q;
        while (temp_q.size()){
            pair<int,int>tmp=temp_q.front(); temp_q.pop();
            graph[tmp.first][tmp.second]='0';

        }
        
    }
    cout<<ret;


    
}