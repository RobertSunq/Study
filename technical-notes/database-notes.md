# database-notes



## 基础知识



## 基本语法



## 其他

### 经典语句备份

----

##### 序号的使用

```sql
-- 列分组拼接与添加序号  @i的应用
SELECT
	dm.ID,
	dd.PID,
	dm.r1,
	dm.r2,
	dm.r3,
	group_concat( 
	 concat(  @i := if (@grp = dd.PID, @i + 1, if(@grp := dd.PID,1,1)), '.',dd.remark  ) separator '\n') info
FROM
	data_main dm
	LEFT JOIN data_detail dd ON dd.PID = dm.ID ,
	(select @i := 0, @grp := '') init
WHERE
	1 = 1 
	AND dm.flag = 1 
GROUP BY dd.PID
ORDER BY dm.r1 ASC;
```





### mysql8安装

----

##### windows

1、下载本地安装文件夹。

2、配置系统环境变量为mysql.exe的保存位置	

```c
（eg.E:\user\ruanjian\mysql8\bin)
```

3、配置my.ini文件如下：

```mysql
[mysqld]
# 设置3306端口
port=3306
# 设置mysql的安装目录
basedir=E:\\user\\ruanjian\\mysql8
# 设置mysql数据库的数据的存放目录 低版本时需要手动创建data文件夹并解除下一行的注释
#datadir=E:\\user\\ruanjian\\mysql8\\data 
# 允许最大连接数
max_connections=200
# 允许连接失败的次数。
max_connect_errors=10
# 服务端使用的字符集默认为utf8mb4
character-set-server=utf8mb4
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
# 默认使用“mysql_native_password”插件认证
#mysql_native_password
default_authentication_plugin=mysql_native_password
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8mb4

[client]
# 设置mysql客户端连接服务端时默认使用的端口
port=3306
default-character-set=utf8mb4

```

4、以管理员权限启动CMD

```mysql
#初始化安装
mysqld  --initialize --console
```

![database-notes-mysql-0000](static\picture\database-notes\database-notes-mysql-0000.png)

```mysql
#安装mysql服务
mysqld --install
#启动服务器
net start mysql 
mysql -uroot -p'默认密码'
#修改默认密码
ALTER USER 'root'@'localhost' IDENTIFIED BY '新密码' PASSWORD EXPIRE NEVER;
```

5、如果无法登陆，则尝试下面方式

```mysql
#退出服务器
net stop mysql
#跳过输入密码
mysqld --defaults-file="D:\MySQL\my.ini" --console --skip-grant-tables
#重启服务器
net start mysql
#登陆
mysql -uroot -p'默认密码'
#更新密码
#无期限
ALTER USER 'root'@'localhost' IDENTIFIED BY '新密码' PASSWORD EXPIRE NEVER;
#有期限
ALTER USER 'root'@'localhost' IDENTIFIED BY '新密码' PASSWORD EXPIRE;
```

![database-notes-mysql-0001](static\picture\database-notes\database-notes-mysql-0001.png)

跳过成功。

