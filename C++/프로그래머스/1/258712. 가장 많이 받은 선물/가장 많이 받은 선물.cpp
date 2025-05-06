#include <bits/stdc++.h> 
#define MAX_N 51
using namespace std;
vector<int> cmp;
map<string,int> idxMap;
int graph[MAX_N][MAX_N];
int jisu[MAX_N],visited[MAX_N],ans[MAX_N];
int n;

void compare(){
    int idx1=cmp[0],idx2=cmp[1];
    
    int cmp1=graph[idx1][idx2],cmp2=graph[idx2][idx1];
    
    //선물을 주고받지 않은 경우
    
    //같은 수의 선물을 주고 받은 경우
    
    if ((cmp1==cmp2) || (cmp1==0 && cmp2==0)){
        //선물지수가 달라야 함
        if (jisu[idx1]!=jisu[idx2]){
            //지수가 큰 사람 +1
            if (jisu[idx1]>jisu[idx2]) ans[idx1]++;
            else ans[idx2]++;
        }
    }else{ //선물 수로 비교
        if (cmp1>cmp2) ans[idx1]++;
        else ans[idx2]++;  
    }
    
}
void findCase(int start,int cnt){
    
    if (cnt==2){
        compare();
    }
    
    for (int i=start;i<n;i++){
        if (!visited[i]){
            visited[i]=1; cmp.push_back(i);
            findCase(i+1,cnt+1);
            visited[i]=0; cmp.pop_back();
        }
    }
}
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
    
    
    //완탐으로 경우의 수
    findCase(0,0);
    for (int i=0;i<n;i++) answer=max(answer,ans[i]);
    return answer;
}