#include <bits/stdc++.h>
using namespace std;
int N,M,a[100001],sum,ret,mx;
int lo=999999;
bool check(int tot){
    if (mx>tot) return false;
    int cnt=0;
    int temp_sum=0;

    for (int i=0;i<N;i++){
        if (temp_sum+a[i]<=tot){
            temp_sum+=a[i];
        }else{
            cnt++;
            temp_sum=a[i];
        }
    }

    return cnt+1<=M;
}

int main(){
    cin>>N>>M;
    for (int i=0;i<N;i++){
        cin>>a[i];
        sum+=a[i];
        lo=min(a[i],lo);
        mx=max(a[i],mx);
    }

    int hi=sum;  
    int mid=(hi+lo)/2;
    
    while (lo<=hi){
        mid=(lo+hi)/2;
        if (check(mid)){
            hi=mid-1;
            ret=mid;
            
        }else{
            lo=mid+1;
        }
       
    }
    cout<<ret;

}