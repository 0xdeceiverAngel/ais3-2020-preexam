from pwn import *
from struct import pack
context.log_level = 'DEBUG'

while 1:
    h="60.250.197.227"
    p=11001
    p=remote(h,p)

    p.sendline("AIS3{aaaaaaaaaaaaaaaaaaaaaaaaaa}")
    p.recvall()
    p.close()

p.interactive()