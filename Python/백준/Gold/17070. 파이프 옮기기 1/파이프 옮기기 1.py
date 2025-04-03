N=int(input())
ar=[]
for i in range(N):
    ar.append(list(map(int,input().split())))

dp = [[[0 for _ in range(N)] for _ in range(N)] for _ in range(3)]

#배열 원소는 차례로 state,행,열

if ar[0][2]!=1:
    dp[0][0][2]=1
if ar[1][2]!=1 and ar[0][2]!=1 and ar[1][1]!=1:
    dp[2][1][2]=1

for i in range(0,N):
    for j in range(0,N):
        #현 상태가 가로
        if j>=1 and ar[i][j]!=1: #이전이 가로인 경우
            dp[0][i][j]+=dp[0][i][j-1] #열만 바뀜
        if j>=1  and ar[i][j]!=1: #이전이 대각선
            dp[0][i][j]+=dp[2][i][j-1] #열만 바뀜
        
        #현 상태가 세로
        if i>=1 and ar[i][j]!=1: #이전이 세로
            dp[1][i][j]+=dp[1][i-1][j] #행만 바뀜
        if i>=1 and ar[i][j]!=1: #이전이 대각선
            dp[1][i][j]+=dp[2][i-1][j] #행만 바뀜
        
        #현 상태가 대각선
        if i>=1 and j>=1 and ar[i][j]!=1 and ar[i-1][j]!=1 and ar[i][j-1]!=1: #이전이 가로
            
            dp[2][i][j]+=dp[0][i-1][j-1] #둘 다 바뀜
            
        if i>=1 and j>=1 and ar[i][j]!=1 and ar[i-1][j]!=1 and ar[i][j-1]!=1: #이전이 세로
            dp[2][i][j]+=dp[1][i-1][j-1]
            
        if i>=1 and j>=1 and ar[i-1][j]!=1 and ar[i][j]!=1 and ar[i][j-1]!=1:
            dp[2][i][j]+=dp[2][i-1][j-1]
            

total=0
total+=dp[0][N-1][N-1]+dp[1][N-1][N-1]+dp[2][N-1][N-1]
print(total)