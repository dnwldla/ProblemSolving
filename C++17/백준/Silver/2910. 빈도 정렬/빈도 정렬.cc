#include <bits/stdc++.h>
#define MAX 1001
using namespace std;
int N,C,ar[MAX],K;
map<int,int> freq,freq_first;
vector<pair<int,int>> v;

bool cmp(pair<int,int> a,pair<int,int> b){
    //등장 횟수가 같으면 먼저 나온 것이 앞에 
    if (a.second==b.second){
        return freq_first[a.first]<freq_first[b.first];
    }
    //많이 등장하는게 앞에 있어야 한다
    return a.second>b.second;
}

int main(){
    cin>>N>>C;

    for (int i=0;i<N;i++){
        cin>>K;
        if (freq[K]==0) freq_first[K]=i;
        freq[K]+=1;
    }

    for (auto it:freq){
        v.push_back({it.first,it.second});
    }

    sort(v.begin(),v.end(),cmp);

   for (auto it:v){
    int time=it.second;
    while (time--){
        cout<<it.first<<" ";
    }
   }

}