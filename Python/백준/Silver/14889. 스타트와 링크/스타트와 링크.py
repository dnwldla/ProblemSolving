import sys
import math
N=int(input())

ar=[list(map(int,input().split())) for _ in range(N)]

visited=[False]*N

min_num=sys.maxsize

def go(idx,cnt):
    global min_num
    if cnt>=N//2:
        return
    
    visited[idx]=True
    #baseCase
    if cnt==N//2-1:
        start=0
        link=0
        for i in range(N):
            for j in range(i+1,N):
                if visited[i]==True and visited[j]==True:
                    start+=ar[i][j]+ar[j][i]
                elif visited[i]==False and visited[j]==False:
                    link+=ar[i][j]+ar[j][i]
        min_num=abs(start-link) if abs(start-link)<min_num else min_num


    for i in range(idx+1,N):
        go(i,cnt+1)
    visited[idx]=False

    return


for i in range(N):
    go(i,0)
print(min_num)