from pwn import *
context.arch = 'amd64'
sc = shellcraft.sh()
print(sc,asm(sc))
enc = pwnlib.encoders.encoder.printable(asm(sc))

