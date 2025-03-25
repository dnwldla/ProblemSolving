#include <bits/stdc++.h>
using namespace std;
int N,K;
const int MAX = 200000; 
int visited[MAX+4];
long long cnt[MAX+4];
queue<int> q;
int main(){
    cin>>N>>K;
    if (N==K){
        puts("0"); puts("1");
        return 0;
    } 

    q.push(N);
    visited[N]=1;
    cnt[N]=1;
    
    while (!q.empty()){
        int now=q.front(); q.pop();
        //if (now==K) break;
        for (int next:{now-1,now+1,now*2}){
            if (0<=next && next<=200000){
                if (!visited[next]){
                    q.push(next);
                    visited[next]=visited[now]+1;
                    cnt[next]+=cnt[now];
                }else if (visited[next]==visited[now]+1){
                    cnt[next]+=cnt[now];
                }
            }
        }
    }
    cout<<visited[K]-1<<"\n";
    cout<<cnt[K]<<"\n";
    

}