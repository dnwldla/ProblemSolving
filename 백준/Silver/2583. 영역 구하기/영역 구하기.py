M,N,K=map(int,input().split())
import sys
sys.setrecursionlimit(10**7)

s=[[False]*N for _ in range(M)]

for _ in range(K):
    start_x,start_y,end_x,end_y=map(int,input().split())
    
    for i in range(start_y,end_y):
        for j in range(start_x,end_x):
            s[i][j]=True

dx=[0,0,1,-1]
dy=[1,-1,0,0]

cnt=0
def dfs(i,j):
    global cnt


    if s[i][j]==True:
        return
    
    s[i][j]=True
    cnt+=1

    for k in range(4):
        nx=i+dx[k]
        ny=j+dy[k]

        if nx>=0 and nx<M and ny>=0 and ny<N and s[nx][ny]==False:
            dfs(nx,ny)
    
    return cnt



result=[]
for i in range(M):
    for j in range(N):
        if s[i][j]==False:
            cnt=0
            result.append(dfs(i,j))

result=sorted(result)  

print(len(result))
for r in result:
    print(r,end=" ")
    
