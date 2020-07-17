#coding=utf-8
import subprocess
import re
db = dict()
for c in "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ{}0123456789_":
    r = subprocess.run(["./TsaiBro", c], stdout=subprocess.PIPE)
    text = r.stdout.decode("utf-8").split("\n")[1]
    db[text.strip()] = c
print(db)
# with open("TsaiBroSaid", "r") as f:
#     string = f.readlines()[1]
# rule = "(發財\\.+發財\\.+)"
# matchlist = re.findall(rule, string)
# flag = ""
# for cipher in matchlist:
#     flag += db[cipher.strip()]
# print(flag)
