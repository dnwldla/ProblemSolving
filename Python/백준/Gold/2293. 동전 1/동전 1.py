n,k=map(int,input().split())
coins=[] #n가지의 동전

for _ in range(n):
    coins.append(int(input()))
coins.sort()

dp=[0]*(k+1)
dp[0]=1

for c in coins:
    for i in range(c,k+1):
        dp[i]+=dp[i-c]


print(dp[k])

