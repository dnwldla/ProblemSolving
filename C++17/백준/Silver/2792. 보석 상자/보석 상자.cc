#include <bits/stdc++.h>
using namespace std;
#define MAX 1000000001
int N,M,k,ret,ans;
vector<int> jew;

int check(int mid){
    int cnt=0;
    for (auto j:jew){
        cnt+=(j/mid);
        if (j%mid) cnt++;
    }
    return cnt;
}
int main(){
    cin>>N>>M;
    ans=MAX;
    while (M--){
        cin>>k;
        jew.push_back(k);
    }

    sort(jew.begin(),jew.end());

    int lo=1;int hi=jew[jew.size()-1];
    int mid=(lo+hi)/2;

    while (lo<=hi){
        mid=(lo+hi)/2;
        ret=check(mid);

        if (ret>N) lo=mid+1;
        else{
            hi=mid-1;
            ans=min(ans,mid);
        }
    }
    cout<<ans;
}