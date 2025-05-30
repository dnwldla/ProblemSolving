#include <bits/stdc++.h>
using namespace std;
int n,m,c,y,x,a[51][51],dp[51][51][51][51];
int mod=1000007;

int go(int y,int x,int cnt,int prev){
    if (y>n || x>m) return 0;
    if (y==n && x==m){
        if (cnt==1 && prev<a[y][x]) return 1;
        if (cnt==0 && a[y][x]==0) return 1;
        else return 0;
    }

    int &ret=dp[y][x][cnt][prev];
    if (ret!=-1) return ret;
    ret=0;
    if (a[y][x]==0){
        ret=(go(y+1,x,cnt,prev)+go(y,x+1,cnt,prev))%mod;
    }else if (a[y][x]>prev){
        ret=(go(y+1,x,cnt-1,a[y][x])+go(y,x+1,cnt-1,a[y][x]))%mod;
    }
    return ret;

}

int main(){
    memset(dp,-1,sizeof(dp));
    cin>>n>>m>>c;

    for (int i=1;i<=c;i++){
        cin>>y>>x;
        a[y][x]=i;
    }

    for (int i=0;i<=c;i++){
        cout<<go(1,1,i,0)<<" ";
    }
}