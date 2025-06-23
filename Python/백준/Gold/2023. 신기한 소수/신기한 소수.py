import math
N=int(input())

ar=[[] for _ in range(N+1)]
ar[1]=[2,3,5,7]


def find(num):
    cnt=0
    for i in range(2,int(math.sqrt(num))+1):
        if num%i==0:
            cnt+=1
    if cnt==0:
        return True
    else:
        return False

def isPrime(lessar,ar):
    for a in lessar:
        for i in range(1,10):
            if find(int(str(a)+str(i))):
                ar.append(int(str(a)+str(i)))



for i in range(2,N+1):
    isPrime(ar[i-1],ar[i])

for elem in ar[N]:
    print(elem)
