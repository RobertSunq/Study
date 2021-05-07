# 鸟哥的linux私房菜



## 首次登入与在线求助



#### 指令的 --help 求助说明

---

使用『--help 』这个选项， 就能够将该指令的用法作一个大致了解

``` markdown
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

```markdown
[qing@study ~]$ date --help
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











## 附录

[Vmware中安装CentOS7中文教程](static/document/VMware安装CentOS7.docx "本地文件")

[Vmware中安装CentOS7中文教程](https://github.com/Sunqingbao/Study/tree/study-dev/book-notes/linux/document/VMware安装CentOS7.docx "GitHub线上文件")

[Vmware中安装CentOS7英文教程](https://www.tecmint.com/centos-7-installation/)

