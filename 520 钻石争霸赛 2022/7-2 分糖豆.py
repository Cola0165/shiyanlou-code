n, m, k = map(int, input().split())
x=m/n
if (x==k):
    print("zheng hao mei ren "+str(k)+"!")
elif (x>k):
    print("hai sheng "+str(m-n*k)+"!")
elif (x<k):
    print("hai cha "+str(n*k-m)+"!")