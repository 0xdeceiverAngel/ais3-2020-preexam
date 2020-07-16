#!/usr/bin/env python3
table = ['a','b','c','d','e','f','g','h',
         'i','j','k','l','m','n','o','p',
         'q','r','s','t','u','v','w','x',
         'y','z','A','B','C','D','E','F',
         'G','H','I','J','K','L','M','N',
         'O','P','Q','R','S','T','U','V',
         'W','X','Y','0','1','2','3','4',
         '5','6','7','8','9','{','}','_']
tab=[
        ['5','6','7','8,','9','{','}','_'],
        ['W','X','Y','0,','y','z','A','B'],
        ['a','b','c','d,','m','n','o','p'],
        ['S','T','U','V,','G','H','I','J'],
        ['K','L','M','N,','u','v','w','x'],
        ['e','f','g','h,','q','r','s','t'],
        ['i','j','k','l,','O','P','Q','R'],
        ['C','D','E','F,','1','2','3','4']
]
f = open("./TsaiBroSaid","r").read().split('\n')[1]
f = f.split("aa")[1:]
ans=''
# for i in f:
    # print(i)
for i in range(0,len(f),2):
    try:
        # ans+=tab[len(f[i+1])-1][len(f[i])-1]
        print(len(f[i]),len(f[i+1]))
        ans+=tab[len(f[i])-1][len(f[i+1])-1]

        print(ans)
    except:
        print('a')