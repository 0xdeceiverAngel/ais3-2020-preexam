#!/usr/bin/env python3
table ='56789{}_WXY0yzABabcdmnopSTUVGHIJKLMNuvwxefghqrstijklOPQRCDEF1234'
f = open("./TsaiBroSaid","r").read().split('\n')[1]
f = f.split("aa")[1:]
ans=''
for i in range(0,len(f),2):
    ans+=(table[(len(f[i])-1)*8+len(f[i+1])-1])
    print(ans)