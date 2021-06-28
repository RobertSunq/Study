# git-notes

> 鹅厂程序猿常用的 Git 命令思维导图

![git-notes-0000](static\picture\git-notes\git-notes-0000.svg)

[^资源来自]: https://www.processon.com/view/link/5c6e2755e4b03334b523ffc3#map



## 详解

----

### 基础

`git`的配置级别主要分为三类

> 1. 仓库级别 `local` [优先级最高]
>    1. `git` 仓库级别对应的配置文件是当前仓库下的`.git/config`，默认是隐藏的 
>    2. **`git config --local -l`**  or **`git config --local --list`**  [查看仓库级别的配置] 
>    3. `git config --local -e` 编辑仓库级别配置文件
> 2. 用户级别 `global`[优先级次之]
>    1. `git` 用户级别对应的配置文件是用户宿主目录下的`~/.gitconfig`（`C:\Users\XXX\.gitconfig`）
>    2. **`git config --global -l`**or **`git config --global --list`**  [查看用户级别的配置]
>    3. `git config --global -e` 编辑用户级别配置文件
> 3. 系统级别 `system`[优先级最低]
>    1. `git`系统级别对应的配置文件是git安装目录下的` /etc/gitconfig`（`[install-path]\mingw64\etc\gitconfig`）
>    2. **`git config --system -l`** or **`git config --system --list`** [查看系统级别的配置
>    3. `git config --system -e` 编辑系统级别配置文件
> 4. 查看全部
>    1. **`git config -l`** or **`git config --list`** 
>    2. 其中的分类为
>       + `core.XXX`	为仓库级配置
>       + `user.XXX`    为用户级配置
>       + `http.XXX`    为系统级配置

> 添加邮箱和用户名
>
> - `git config --global user.email “XXX@xxx.com” `    # 用户级
> - `git config --global user.name “XXX” `                # 用户级





### SSH配置

1. 首先确保用户名与账号的配置完成
2. 生成密钥对
```sh
 $ ssh-keygen -t rsa -C "xxx@xxx.com" 	# 生成秘钥
# 之后会又两个输入选项：
# 		1、第一个是指定生成的密钥文件名(将会放在用户文件目录下)，如果不指定，则使用默认的文件名称
# 					id_rsa.pub  公钥	id_rsa  私钥
# 		2、第二个是指定验证密码，不输入则默认为空
```
![image-20210624211250110](static\picture\git-notes\git-notes-0001.png)

3. 进入到用户宿主目录下，获取公钥 `cat ~/.ssh/id_rsa.pub`	(也可以直接访问id_rsa.pub文件查看)
5. 进入github或者其他版本管理系统，添加此处获得的公钥

6. 测试访问 `ssh -T git@github.com` 

   ​		返回如下提示则配置成功 `Hi xxxx! You've successfully authenticated, but GitHub does not provide shell access.`

   ​		![git-notes-0002](static\picture\git-notes\git-notes-0002.png)

7. 修改`git`的`remote url`

```sh
# 查看当前的 remote url
$ git remote -v	
origin https://github.com/XXX/XXXproject.git (fetch) # 此结果说明 使用https协议进行访问
origin https://github.com/XXX/XXXproject.git (push)

#  复制SSH链接，进行调整
$ git remote set-url origin git@github.com:XXX/XXXproject.git

# 之后可再次使用查看 remote url 会发现已经被修改
$ git remote -v	
origin  git@github.com:XXX/XXXproject.git (fetch)  # git开头则表示是git协议
origin  git@github.com:XXX/XXXproject.git (push)

```











