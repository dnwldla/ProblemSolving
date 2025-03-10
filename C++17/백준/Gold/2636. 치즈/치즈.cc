#include <bits/stdc++.h>
using namespace std;
const int max_n=101;
int dx[]={1,-1,0,0};
int dy[]={0,0,-1,1};
int N,M;
int ar[max_n][max_n];
bool visited[max_n][max_n];
int day,leave;
queue<pair<int,int>> air,cheese,air_tmp;

void QClear(queue<pair<int,int>>&q){
    queue<pair<int,int>> empty;
    swap(q,empty);
}

int main(){
    cin>>N>>M;

    for (int i=0;i<N;i++){
        for (int j=0;j<M;j++){
            cin>>ar[i][j];
        }
    }
    air.push({0,0});
    visited[0][0]=true;
    
     while (air.size()){
        //replace air queue with cheese
        leave=air.size();
        day++;
        while (air.size()){
            pair<int,int> cur=air.front(); air.pop();
            int x=cur.first;
            int y=cur.second;
           
            for (int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if (nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if (visited[nx][ny]) continue;
                
                if (ar[nx][ny]==0){ //air
                    visited[nx][ny]=true;
                    air.push({nx,ny});
                }else{
                    if (!visited[nx][ny]){
                        cheese.push({nx,ny});
                        visited[nx][ny]=true;
                    } 
                } 
            }
        }
        
        air=cheese;
        
        
        //make cheese to air
        while (cheese.size()){
            pair<int,int>cur=cheese.front(); cheese.pop();
            ar[cur.first][cur.second]=0;
        }

        
        //clear chesse
        QClear(cheese);
        //day++;
        
    }

    cout<<day-1<<"\n";
    cout<<leave;
    
    
}