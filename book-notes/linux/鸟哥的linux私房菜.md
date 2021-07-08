# 鸟哥的linux私房菜



## 首次登入与在线求助



#### 指令的 --help 求助说明

---

使用『--help 』这个选项， 就能够将该指令的用法作一个大致了解

``` shell
[qing@study ~]$ date --help

Usage: date [OPTION]... [+FORMAT] # 这里有基本语法
or: date [-u|--utc|--universal] [MMDDhhmm[[CC]YY][.ss]] # 这是设定时间的语法
Display the current time in the given FORMAT, or set the system date.
# 底下是主要的选项说明
Mandatory arguments to long options are mandatory for short options too.
-d, --date=STRING display time described by STRING, not 'now'
-f, --file=DATEFILE like --date once for each line of DATEFILE
....(中间省略)....
-u, --utc, --universal print or set Coordinated Universal Time (UTC)
--help 显示此求助说明并离开
--version 显示版本信息并离开
# 底下则是重要的格式 (FORMAT) 的主要项目
FORMAT controls the output. Interpreted sequences are:
%% a literal %
%a locale's abbreviated weekday name (e.g., Sun)
%A locale's full weekday name (e.g., Sunday)
....(中间省略)....
# 底下是几个重要的范例 (Example)
Examples:
Convert seconds since the epoch (1970-01-01 UTC) to a date
$ date --date='@2147483647'
....(底下省略)....

```



#### man page

---

man 是manual(操作说明)的简写，使用该指令就可以看到很清楚的说明

```shell
[qing@study ~]$ man date
```

![0001](static\picture\0001.png)

在上个表格的第一行，可以看到的是：『DATE(1)』，DATE 是指令的名称， (1)代表的是『一般用户可使用的指令』的意思。其他的几个数字意义见下表

| 代号                      | 代表内容                                                     |
| ------------------------- | ------------------------------------------------------------ |
| <font color=blue>1</font> | <font color=blue>用户在shell环境中可以操作的指令或可执行文件</font> |
| 2                         | 系统核心可呼叫的函数与工具等                                 |
| 3                         | 一些常用的函数(function)与函式库(library)，大部分为C 的函式库(libc) |
| 4                         | 装置文件的说明，通常在/dev 下的文件                          |
| <font color=blue>5</font> | <font color=blue>配置文件或者是某些文件的格式</font>         |
| 6                         | 游戏(games)                                                  |
| 7                         | 惯例与协议等，例如Linux 文件系统、网络协议、ASCII code 等等的说明 |
| <font color=blue>8</font> | <font color=blue>系统管理员可用的管理指令</font>             |
| 9                         | 跟kernel 有关的文件                                          |

> 上述的表格内容可以使用『man man』来更详细的取得说明

man page 的内容也分成好几个部分来加以介绍该指令，大致分为以下几部分

![0002](static\picture\0002.png)

使用技巧

1. ​	先查看NAME的内容，简略的看下大致说明。
2. ​    详细的看DESCRIPTION，这部分会提到很多相关的资料和使用时机，可以学到很多小细节。
3. ​    之后就是查看OPTIONS，可以知道每个选项的意义，这样就可以比较细致的下达相关指令。
4. ​    最后可以查看 FILES与SEE ALSO，来获取更多的参考与进一步查阅数据。



#### info page

---

info 与man 的用途其实差不多，都是用来查询指令的用法或者是文件的格式。但是与man page一口气输出一堆信息不同的是，info page 则是将文件数据拆成一个一个的段落，每个段落用自己的页面来撰写， 并且在各个页面中还有类似网页的『超链接』来跳到各不同的页面中，每个独立的页面也被称为一个节点(node)。所以，你可以将 info page 想成是文本模式的网页显示数据。

> 由于man指令的说明，具有中文版，故info指令我没有做深入了解，仅仅截取原书中部分图片用于了解。

![0003](static\picture\0003.png)

![0004](static\picture\0004.png)



#### 其他资料文件

---

除了上述的『联机帮助文档』，还有相当多的说明需要额外的文件，部分软件不只告诉你『如何做』，还会有一些相关的原理会说明。

而这些文件就会保存在```/usr/share/doc```目录中，只要到这个目录底下， 就会发现很多的说明文件。同时，很多原版软件释出的时候，都会有一些安装须知、预计工作事项、未来工作规划等等的东西，还有包括可安装的程序等， 这些文件也都放置在```/usr/share/doc ```当中喔！而且```/usr/share/doc ```这个目录下的数据主要是以套件(packages)为主的， 例如 nano 这个软件的相关信息在`/usr/share/doc/nano-xxx`中(xxx 表示版本的意思)。



#### 超简单文书编辑器：nano

----

nano 的使用其实很简单，直接加上文档名，如果该文档存在，则会打开文档；如果该文档不存在，则会新建该文档并打开。

```shell
[qing@study ~]$ nano test.txt

```

![0005](static\picture\0005.png)

> 符号『^』代表键盘上的 『Control』键。由于我设置的系统语言是中文，所有这里显示的是中文，英文语言环境下，将显示的是英文说明。

**补充**

+ 『Control』+ _ ：直接输入行号，使光标快速移动到该行。
+ 『Control』+ M：开启鼠标移动光标功能。

在编辑后，使用『Control』+ X，之后可以选择是否保存，选择保存后，便进入下面的界面，在这里可以选择修改文件名，以节下面的其他操作。

![0006](static\picture\0006.png)



>  符号『M』代表键盘上的 『Alt』键。由于我设置的系统语言是中文，所有这里显示的是中文，英文语言环境下，将显示的是英文说明。



#### 关机注意事项

----

在Linux中，由于每个程序（或者说是服务）都是在其后台执行的，因此，<font color=blue>在看不到的屏幕背后其实可能有相当多的人在同一个注解上面工作的</font>，例如浏览网页，传送信件以FTP传送文件等操作。

除此之外，最大的问题是，<font color=blue>若不正常关机，则可能造文件系统的损坏</font>（因为来不及将数据回写到文件中，所以有些服务的文件会有问题！）。所以在正常关机时需要注意以下几件事：

+ <font color=blue>观察系统使用状态</font>

```shell
# 查看在线用户
[qing@study ~]$ who
# 查看网络链接状态
[qing@study ~]$ netstat -a 
# 查看后台执行的程序
[qing@study ~]$ ps -aux
```



+ <font color=blue>通知在线使用者关机的时刻</font>

> 在主机面前以实体终端机（tty1~tty7）来登入系统时，任何身份都可以关机，但是在使用远程管理工具是，关机就只有root具有权限。

**shutdown可以达到以下的工作**

​			<font color=blue>可以自由选择关机模式：是要关机或重新启动均可；</font>

​			<font color=blue>可以设定关机时间: 可以设定成现在立刻关机, 也可以设定某一个特定的时间才关机。</font>

​			<font color=blue>可以自定义关机讯息：在关机之前，可以将自己设定的讯息传送给在线user 。</font>

​			<font color=blue>可以仅发出警告讯息：有时有可能你要进行一些测试，而不想让其他的使用者干扰，或者是明白的告诉使用者某段时间要注意一下！这个时候可以使用shutdown 来吓一吓使用者，但却不是真的要关机啦！</font>

```shell
# 使用shutdown的特别指令来达到功能
[qing@study ~]$ /sbin/shutdown [-krhc] [time] [message]
################################################################
# 
# 选项参数：														 
# -k		:	不是真的关机，只是发送警告讯息！					 
# -r		:	将在系统的服务停掉之后就重新启动(常用)				
# -h		:	将系统的服务停掉后，立即关机。(常用)					 
# -c		:	取消已经在进行的shutdown指令内容。					
# time		:	指定系统关机的时间！若没有，则默认一分钟后进行			
# message	:	警告习提示信息
# 
################################################################

# eg. 系统将在十分钟后关机
[root@study ~]$ /sbin/shutdown -h 10 '将在十分钟后关机'

# 立即关机，其中now相当于时间为 0 的状态
[root@study ~]$ shutdown -h now
# 系统将在最近的时刻 20：00 关机。
[root@study ~]$ shutdown -h 20:00
# 系统再过十分钟后自动关机
[root@study ~]$ shutdown -h +10
# 系统立刻重新启动
[root@study ~]$ shutdown -r now
# 再过三十分钟后将会重启，并显示警告讯息
[root@study ~]$ shutdown -r +30 '将在三十分钟后关机'
# 仅发出警告信息，但是并不会真正关机。
[root@study ~]$ shutdown -k now '将立即关机'
```



+ <font color=blue>正确的关机指令</font>
  + 将数据同步写入硬盘中的指令：sync
  + 常用的关机指令：shutdown
  + 重新启动，关机：reboot，halt，poweroff

```shell
# 同步更新硬盘数据
[qing@study ~]$ sync # 个人操作，仅更新自己的。
[root@study ~]$ sync # root操作，更新整个系统的。
```

###### 实际中使用 systemctl 关机

```shell
# 系统管理
[root@study ~]$ systemctl [指令] 
################################################################
# 
# 指令项目包括如：														 
# halt			:	进入系统停止的模式，屏幕可能会保留一些讯息，这与电源管理模式有关！					 
# poweroff		:	进入系统关机模式，直接关机！				
# reboot		:	直接重新启动。				 
# suspend		:	进入休眠模式。					
# 
################################################################

[root@study ~]# systemctl reboot # 系统重新启动
[root@study ~]# systemctl poweroff # 系统关机

```



## Linux的文件权限与目录配置

>  基本权限概念：文件所有者、群组、其他人

### Linux 文件权限概念

#### Linux 文件属性

```sh
[root@study ~]# ls -al # 列出所有的文件详细的权限与属性
drwxrwxrwt.  18 root root 4096 6月   2 17:39 tmp

```

![0007](static\picture\0007.png)

##### 文件类型与权限













































## 附录

[Vmware中安装CentOS7中文教程](static/document/VMware安装CentOS7.docx "本地文件")

[Vmware中安装CentOS7中文教程](https://github.com/Sunqingbao/Study/tree/study-dev/book-notes/linux/document/VMware安装CentOS7.docx "GitHub线上文件")

[Vmware中安装CentOS7英文教程](https://www.tecmint.com/centos-7-installation/ "tecmint上教程地址")

