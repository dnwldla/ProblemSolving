//5-H
#include<bits/stdc++.h>
using namespace std; 
int const MAX=1000000;
int lo,hi,N,ar[MAX];
long long ret;
bool visited[MAX];
int main(){
    cin>>N;
    for (int i =0;i<N;i++){
        cin>>ar[i];
    }
    
    while (hi<N){
        if (!visited[ar[hi]]){
            visited[ar[hi]]=true;
            hi++;
        }else{
            ret+=(hi-lo);
            visited[ar[lo]]=false;
            lo++;
        }
    }
    ret+=(long long)(hi-lo)*(hi-lo+1)/2;
    cout<<ret;


}