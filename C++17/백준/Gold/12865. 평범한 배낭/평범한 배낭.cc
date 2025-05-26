#include<bits/stdc++.h>
using namespace std;
int dp[100001];
int n, k, w, v;
int main(){
    cin>>n>>k;
    while(n--){
        cin>>w>>v;
        for(int j = k; j >= w; j--){
            dp[j] = max(dp[j], dp[j - w] + v);
        }
        
    }
    cout<<dp[k];
  
    return 0;
}
