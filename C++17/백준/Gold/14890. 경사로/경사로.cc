#include <bits/stdc++.h>
using namespace std;
int N,L,a[101][101],b[101][101],ret;

void go(int graph[101][101]){
    for (int i=0;i<N;i++){
        int cnt=1;
        int j=0;
        for (j=0;j<N-1;j++){
            if (graph[i][j]==graph[i][j+1]) cnt++;
            else if (graph[i][j]+1==graph[i][j+1] && cnt>=L) cnt=1;
            else if (graph[i][j]-1==graph[i][j+1] && cnt>=0) cnt=-L+1;
            else break; 
        }
        if (j==N-1 && cnt>=0) ret++;
    }
    return;
}

int main(){
    cin>>N>>L;

    for (int i=0;i<N;i++){
        for (int j=0;j<N;j++){
            cin>>a[i][j];
            b[j][i]=a[i][j];
        }
    }

    go(a);
    go(b);
    cout<<ret;
}