#include <bits/stdc++.h>
#define INF 987654321
using namespace std;
int n,k,dp[100001];

int main(){
    cin>>n>>k;
    vector<int> coins(n);
    fill(dp,dp+10001,INF);

    for (int i=0;i<n;i++){
        int coin;
        cin>>coin;
        dp[coin]=1;
        coins[i]=coin;
    }
    dp[0]=0;

    for (int i=1;i<=k;i++){
        for (int c:coins){
            if (i<c) continue;
            dp[i]=min(dp[i],dp[i-c]+1);
        }
    }
  
    if (dp[k]==INF) cout<<-1;
    else cout<<dp[k];

}