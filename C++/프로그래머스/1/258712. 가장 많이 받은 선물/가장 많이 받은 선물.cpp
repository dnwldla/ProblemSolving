#include <bits/stdc++.h> 
#define MAX_N 51
using namespace std;
vector<int> cmp;
map<string,int> idxMap;
int graph[MAX_N][MAX_N],flag[MAX_N][MAX_N];
int jisu[MAX_N],visited[MAX_N],ans[MAX_N];
int n;

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    
    //index 저장
    for (int i=0;i<friends.size();i++){
        idxMap[friends[i]]=i;
    }
    
    //make gifts graph
    for (string gift:gifts){
        int split=gift.find(" ");
        string from=gift.substr(0,split);
        string to=gift.substr(split+1);
        
        graph[idxMap[from]][idxMap[to]]+=1;
    }
    
    //선물 그래프 
    n=friends.size();
    
    //make gift summary: map
    //준 선물
    int i=0;
    while (i<n){
        int tot=0;
        for (int j=0;j<n;j++){
            tot+=graph[i][j];
            tot-=graph[j][i];
        }
        jisu[i]=tot;
        i++;
    }
    
    for (int i=0;i<n;i++){
        for (int j=0;j<n;j++){
            if (i==j) continue;
            if (flag[i][j] || flag[j][i]) continue;
           
            int cmp1=graph[i][j],cmp2=graph[j][i];
    
            if ((cmp1==cmp2) || (cmp1==0 && cmp2==0)){
            //선물지수가 달라야 함
            if (jisu[i]!=jisu[j]){
            //지수가 큰 사람 +1
            if (jisu[i]>jisu[j]) ans[i]++;
            else ans[j]++;
        }
    }else{ //선물 수로 비교
        if (cmp1>cmp2) ans[i]++;
        else ans[j]++;  
        }
        flag[i][j]=1;flag[j][i]=1;
    }
}
    
    for (int i=0;i<n;i++) answer=max(answer,ans[i]);
    return answer;
}