#include<bits/stdc++.h>
using namespace std; 
int const MAX=1000000;
int lo,hi,cnt[MAX],N,ar[MAX];
long long ret;
int main(){
    cin>>N;
    for (int i =0;i<N;i++){
        cin>>ar[i];
    }
    
    while (hi<N){
        if (!cnt[ar[hi]]){ //겹치면 
            cnt[ar[hi]]++;
            hi++;
        }else{ //중복수가 등장하면
            ret+=(hi-lo);
            cnt[ar[lo]]--;
            lo++;
        }
    }
    ret+=(long long)(hi-lo)*(hi-lo+1)/2;
    cout<<ret;


}