#include <bits/stdc++.h>
#define MAX_N 1000004
#define MAX_SIZE 987654321
using namespace std;

int dp[MAX_N],N;

void print(int here){

    cout<<here<<" ";

    if (here%3==0 && dp[here]==dp[here/3]+1) print(here/3);
    
    else if(here % 2 == 0 && dp[here] == (dp[here / 2] + 1)) print(here / 2);
    else if((here - 1 >= 0) && (dp[here] == (dp[here - 1] + 1))) print(here - 1);
}

int go(int here){
    if (here==1) return 0;
    if (here==2 || here==3) return 1;

    int &ret=dp[here]; //0이 아니면 
    if (ret!=MAX_SIZE){
        return ret;
    } 
    
    if (here%3==0) dp[here]=min(dp[here],go(here/3)+1);
    if (here%2==0) dp[here]=min(dp[here],go(here/2)+1);
    if (here>1) dp[here]=min(dp[here],go(here-1)+1);

    return ret;
}

int main(){
    cin>>N;
    fill(dp,dp+MAX_N,MAX_SIZE);
    dp[1]=0;
    dp[2]=1;
    dp[3]=1;
    cout<<go(N)<<"\n";
    print(N);
}