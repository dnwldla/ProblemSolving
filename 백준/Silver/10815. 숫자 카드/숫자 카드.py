N=int(input())
card=list(map(int,input().split()))
M=int(input())
check=list(map(int,input().split()))

#card 오름차순 sort
card.sort()


def find_num(idx,left,right):
    while left<=right:
        mid=(left+right)//2

        if card[mid]==check[idx]:
            return 1
        elif card[mid]<check[idx]:
            left=mid+1
        else:
            right=mid-1
    return 0

result=[]


for i in range(M):
    result.append(find_num(i,0,N-1))

for r in result:
    print(r,end=" ")