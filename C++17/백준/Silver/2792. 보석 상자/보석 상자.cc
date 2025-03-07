#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n,m,a[300004],ret=1e18;

bool check(ll mid){ //
    ll num=0;
    //7 4를 4로 나누자
    for (int i=0;i<m;i++){ //보석 개에 대여
        num+=a[i]/mid; //보석 개수를 mid로 나누어서 받는 사람 출력
        if (a[i]%mid) num++; // 나누어떨어지지 않는다면 1 증가
    }
    return n>=num; //사람수가 더 많다면 true return
}
int main(){
    cin>>n>>m;
    ll lo=1,hi=0,mid;

    for (int i=0;i<m;i++){
        cin>>a[i];
        hi=max(hi,a[i]); //보석의 개수가 제일 많음
    }
    //5 2 //사람 다섯명 
    //7
    //4

    while (lo<=hi){
        mid=(lo+hi)/2; // mid는 4
        if (check(mid)){ //사람 수가 더 많다면
            ret=min(ret,mid);
            hi=mid-1;
        }else lo=mid+1; //보석을 분배한 사람이 더 많다면
    }
    cout<<ret;
    //질투심이 뭔데..? 
}