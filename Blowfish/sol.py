import pickle
data=pickle.load(open("user.pickle",'rb'))
print(data)

from pwn import *


knw = open("user.pickle", "rb").read()
# h = "60.250.197.227"
# p = 12001
r = remote(h, p)
r.recvuntil("Your token:")
enc_b64 = r.recvuntil("\n")
enc = b64d(enc_b64.decode("utf-8").strip())
cc = xor(enc, knw)
d = [{'name': 'a', 'password': 'a', 'admin': True}]
print(d)
r.sendlineafter("username : ", "a")
r.sendlineafter("password : ", "a")
rb = pickle.dumps(d)
f = b64e(xor(cc, rb))
print(f)
r.interactive()
