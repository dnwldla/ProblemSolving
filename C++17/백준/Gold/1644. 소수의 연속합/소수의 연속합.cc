#include<bits/stdc++.h>
using namespace std; 
int N,ar[4000000],lo,hi,idx,sum,ret;
bool che[4000001];
int main(){
    cin>>N;

    for (int i=2;i<=N;i++){
        if (che[i]) continue;

        for (int j=2*i;j<=N;j+=i){
            che[j]=1;
        }
    }
    for (int i=2;i<=N;i++){
        if (!che[i]) ar[idx++]=i;
    }

    while (lo<idx && hi<idx){
        if (sum+ar[hi]<N){
            sum+=ar[hi];
            hi++;
        }else if (sum+ar[hi]==N){
            sum+=ar[hi];
            hi++;
            ret++;
        }else{
            sum+=ar[hi];
            hi++;

            while (true){
                if (sum<=N) break;
                sum-=ar[lo];
                lo++;
            }
            if (sum==N) ret++;
        }
    }
    cout<<ret;

}