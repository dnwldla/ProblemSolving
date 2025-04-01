#include <bits/stdc++.h> 
#define MAX_N 16
const int INF = 987654321;
using namespace std; 
int n, dp[MAX_N][1 << MAX_N], dist[MAX_N][MAX_N];
int tsp(int here, int visited){
    if(visited == (1 << n) - 1){ //전체 다 방문했다면 
        return dist[here][0] ? dist[here][0] : INF;
    }
    //이미 거리가 계산되어 있으면 반환 
    if (dp[here][visited]!=-1) return dp[here][visited];
    int ret = INF;
    for(int i = 0; i < n; i++){
        if(visited & (1 << i)) continue;
        if(dist[here][i] == 0) continue;
        ret = min(ret, tsp(i, visited | (1 << i)) + dist[here][i]);
    }
    dp[here][visited]=ret;
    return ret;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> dist[i][j];
        }
    }

    memset(dp, -1, sizeof(dp));
    cout << tsp(0, 1) << '\n';
    return 0;
}