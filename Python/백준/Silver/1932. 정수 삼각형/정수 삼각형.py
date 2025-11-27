import sys
#처음에 그리디로 생각했다가 아님
n=int(input())
ar=[]
#입력
for i in range(n):
    ar.append(list(map(int,input().split())))


dp=[[0]*i for i in range(1,n+1)]

dp[0][0]=ar[0][0]

for i in range(1,n):
    for j in range(0,i+1):
        if j==0:
            dp[i][j]+=dp[i-1][j]+ar[i][j]
        elif i==j:
            dp[i][j]+=dp[i-1][j-1]+ar[i][j]
        else:
            dp[i][j]+=max(dp[i-1][j-1],dp[i-1][j])+ar[i][j]

print(max(dp[n-1])) #이게 돼?
    


