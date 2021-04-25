# java-notes



## 基础知识



### 标准类基本格式：

1. 所有的成员变量都要使用private关键字修饰。
2. 为没给成员变量编写一对Getter/Setter方法。
3. 编写一个五参数的构造方法。
4. 编写一个全参数的构造方法。

```java
package cn.test.day0628;


public class Demo0 {
    private String name;
    private int num;

    public Demo0() {
    }

    public Demo0(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public static void main(String[] args) {
        Demo0 test = new Demo0();
        test.dem();

//        System.out.println(num);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void dem() {
        int num0;
//        System.out.println(num0);
        System.out.println(name);
        System.out.println(this.num);

    }
}
```



### 应用类型一般使用步骤

1. 导包
   如果需要使用的目标类和当前类位于同一个包下，则可以省略导包语句。

   只有java.lang包下的内容不需要导包，其他的包都需要import语句

2. 创建

   类名称 对象名 = new类名称()

3. 使用

   对象名.成员方法名()

   

### 类型转换

布尔类型不允许进行类型转换。

“类”数据类型不允许进行类型转换。

对象可以在其所属类型的类族之间进行类型转换。

```java
/*自动类型转换（隐式）
*	1.特点：代码不需要进行特殊处理自动完成
*	2.规则：数据类型范围从小到大
*
*/

long num1 = 1000;// int --> long   true
float num2 = 30L;// long --> float  true
int num3 = 100L; // lont --> int  false
```

```java
/*强制类型转换（显式）
*	1.特点：代码需要进行特殊的格式处理，不能自动完成。
*	2.范围小的类型  范围小的变量名 = （范围小的类型） 原本范围大的数据
*	
*	注：
*		1.强制类型转换可能会发生净损失、数据溢出等情况的发生
*		2.byte/short/char这三种类型都可以发生数学运算。
*		3.byte/short/char这三种类型在运算的时候，都会被首先提升为int类型，进行运算。
*		4.boolean类型不能发生数据类型转换
*/

int num0 = (int) 100L; // True
```



### javadoc 标签示例

```java
/**
@see：：引用其他类
@link package.class#member label：与see类型相似，应用于行
@docRoot：文档根目录的相对路径
@inheritDoc：继承相关文档的注释
@version：版本信息
@author：作者等相关信息
@since：指定JDK版本
@param：参数列表说明
@return：返回值含义
@throws：“抛出”异常
@Deprecated：旧特性被新特性所取代


*/
```



### 按位操作符

|  &   |  \|  |  ~   |  ^   |
| :--: | :--: | :--: | :--: |
|  与  |  或  |  非  | 异或 |



### 方法

---

#### 方法小结

```java
/**
定义一个方法的格式：
	public static void 方法名称(){
		方法体;
	
	}
方法名称的命名规则和变量一样，使用小驼峰体，
方法体：即大括号中可以包含任意条语句。


注：
	1.方法定义的先后顺序无所谓。
	2.方法的定义不能产生嵌套包含关系。
	3.方法定义好了之后，不会执行的，执行需要【调用】。
	4.
	
调用：
	方法名称();
	
	
*/
```

#### 方法重载

- 方法名相同但是参数列表不相同（包含：顺序不同，数据类型不同等）

- 如果传入的数据类型（实际参数类型）小于方法中声明的形式参数类型，实际数据类型就会被提升（类似于隐式的数据类型转换）。char类型数据有所不同，如果无法找到恰好接受char参数的方法，就会吧char直接提升为int型。

- 如果方法传入的较小的基本类型作为参数，就需要进行显式的强制类型转换。

#### 构造器

```java
class Bath{
  private String s1="H",s2 = "H",s3,s4;
  private int i;
  private float toy;
  public Bath(){};  // 默认构造器
  public Bath(String s4){ // 重载定义构造器
      System.out.println("Inside Bath()");
      s3 = "joy";
      toy = 3.14F;
      this.s4 = "Tom";
  };
}


/*
注：
	构造方法的名称必须和所在类名称完全一样，大小写也要一样。
	构造方法不要写返回值类型，连void都不要写。
	构造方法不能return一个具体的返回值。
	如果没有编写任何构造方法，那么编译器将会默认赠送一个构造方法，没有参数，方法什么事情都不做。
	一旦编写了至少一个构造方法，那么编译器不在赠送。
	构造方法也可以进行重载
*/
```



### 选择结构

---

#### switch

```java
/**
注：
	1、多个case的关键值不可以相同。
	2、switch 判断关键字只能为：
		基本数据类型：byte/short/char/int
		引用数据类型：String字符串、enum美剧

*/
int num = 2;
switch(num){
    case 1:
        sout(1);
        break;
    case 2:
        sout(2);
        break;
    default:
        sout("stop");
        break;
     
}// switch
```



### 类

---

#### 访问权限

1. 每个编译单元（文件）都只能有同一个public类。

2. public类的名称必须完全与含有该编译单元的文件名称相匹配。

3. 虽然不是很常用，但编译单元内完全不带public类也是可能的。在这种情况下，可以随意对文件命名。

   

#### 继承

关键字：**extends**



### 内存划分

---

#### 栈（Stack）：

**存放的都是方法中的局部变量，方法的运行一定要在栈当中。**

- 局部变量：方法的参数，或者是方法()内部的变量。
- 作用域：一旦超出作用域，立刻从栈内存当中消失。

#### 堆（Heap）：

**凡是new出来的东西，都在堆当中。**

​						堆内存里面的数据，都有默认值，规则为：

| 堆内存里面的数据都有默认值，规则为： | 默认值   |
| ------------------------------------ | -------- |
| 整数                                 | 0        |
| 浮点数                               | 0.0      |
| 字符                                 | '\u0000' |
| 布尔                                 | false    |
| 引用类型                             | null     |

#### 方法区（Method Area）：

**存储.class相关信息，包含方法的信息。**

#### 本地方法栈（Native Method Stack）：

**与操作系统相关。**

#### 寄存器（pc Register）：

**与CPU相关。**



### protected

- **对于普通类型数据：**

其初始化方法命名为**setXxxx()**，无返回值，参数类型与成员变量相同。

其获取值方法命名为**getXxxx()**，返回值与成员变量类型相同。

- **对于boolean类型数据：**

初始化函数方法命名规则相同，但是获取值方法命名为**isXxxx()**、

### ==

基本类型：是进行数值的比较。

引用类型：时进行地址值的比较。



## 关键字说明

### super()

**概念：**一个代指变量，用于在子类中代指父类对象。

**应用范围：**

​				访问父类中的方法。

​				调用父类构造方法。

​				访问父类中的隐藏成员变量。

**使用：**

​		

```java
package cn.test.day0625;
class Father{
    protected String father_a = new String("father_a");
    public Father(){ // 无参构造器
        father_a = "父类：曹操";
        System.out.println("我是无参构造器，"+father_a);
    }
    public Father(String father_a){ // 有参构造器
        this.father_a = father_a;
        System.out.println("我是有参构造器，"+father_a);

    }
    void doSomething(){
        System.out.println("曹操：狭天子以令诸侯");
    }
}
class Son extends Father{
    private String son_a=new String("son_a");
    public Son(){  // 无参构造器
        //super(); // 代表父类  即执行父类中的无参构造器
        super("子类传递给父类的参数");
        son_a = "子类：曹冲";
        System.out.println("我是子类的构造器："+son_a);
    }

    @Override
    void doSomething() {
        super.doSomething();// 访问父类中的方法
        System.out.println("********分隔符********");
        System.out.println("访问父类中的成员变量"+super.father_a); // 访问父类中的成员变量
        System.out.println("访问子类中的成员变量"+this.son_a);
    }
}
public class Demo_super {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println();
        son.doSomething();
    }
}

```

![java-notes-0000](static\pircture\java-notes\java-notes-0000.png)

### @Override注解

用以覆写某个方法时，可以选择添加该注解，当不留心重载而非覆写该方法时，编译器会产生错误信息。

**防止在不想重载的时候对方法进行重载。**



### final

1. 一个永不改变的**编译时常量**。
2. 一个运行时被初始化的值，而你不希望它被改变。
3. 一个既是**static**又是**final**的域只占据一段不能改变的存储空间。

##### 空白final

声明为final但又未给定初值的域。	使得一个类中的**final**域可以做到根据对象而有所不同，但又保持其恒定不变的特性。

**注：必须在域的定义处或者每个构造器中表达式对final进行赋值。**

![java-notes-0001.png](static\pircture\java-notes\java-notes-0001.png)



### Scanner类

1.导包   

```java
import java.util.Scanner;
```

2.创建

```java
Scanner sc = new Scanner(System.in); // 该关键字是从键盘获取输入
```

3.使用

对象名.成员方法名()

```java
int num = sc.nextInt();//从键盘上获取整型
String str = sc.next();//从键盘上获取字符串
```



### Random类

1.导入包

```java
import java.util.Random;
```

2.创建对象

```java
Random rand0 = new Random();// 括号中的数据为种子，无参数时默认以当前时间序列为种子
Random rand1 = new Random(38);
```

3.调用方法

```java
rand1.nextInt(100) // 指定上限
```



### Array List类

```java
/*
  ArrayList集合的长度是可以随意变化的
  
  对于ArrayList来说，有一个尖括号<E>代表泛型。
  泛型：也就是装在集合当中的所有元素，全部是统一的什么类型。
  		泛型只能是引用类型，不能是基本类型。
*/

ArrayList<E> list = new ArrayList<>();// 后面E可有可无
// ArrayList 当中的常用方法

public boolean add(E e);// 向集合当中添加元素，参数的类型和泛型一致
public E get(int index);// 从集合当中获取元素，参数是索引编号，返回值就是对应位置的元素
public E remove(int index);//从集合当中删除元素，参数是索引编号，返回值就是被删除掉的元素
public int size();//获取集合的尺寸长度，返回值是集合中包含的元素个数


// 如果希望想集合ArrayList当中存储基本类型数据，必须使用基本类型对应的“包装类”

```

包装类

| 基本类型 | 包装类(引用类型)  |
| -------- | ----------------- |
| byte     | Byte              |
| short    | Short             |
| int      | Integer【特殊】   |
| long     | Long              |
| float    | Float             |
| double   | Double            |
| char     | Character【特殊】 |
| boolean  | Boolean           |



### String

#### 特点：

1. 字符串的内容用不可变，即常量【重点】
2. 正由于字符串不可改变，所以字符串是可以共享使用的。
3. 字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组。

```java
/*常见三种构造方法与直接构造*/
public String();//创建一个空白字符串，不含有任何内容。
public String(char[] array);//根据字符数组的内容，来创建对应的字符串。
public String(byte[] array);// 根据字节数组的内容，来创建对应的字符串。
String str = "Hello"; // 直接创造，直接写上就是字符串对象

```

字符串常量池：程序当中直接写上的双引号字符串，就在字符串常量池中。而new的对象不再池当中。

#### 比较

```java
public boolean equals(Object obj) //参数可以是任何对象，只有参数是一个字符串并且内容相同的炒菜会给true，否则返回false.
    
    /*
    注：
    任何队形都能用object接收。
    equals方法具有对称性，即a.equals(b) 与 b.equalt(a)效果一样
    如果比较双方一个常量一个变量，推荐吧常量字符串写在前面："abc".equals(str)
    */
    String str1 = "Hello";
	char[] charArray = {'H','e'.'l','l','o'};
	String str2 = new String(charArray);
	System.out.println(str1.equals(str2));// true
    

public boolean equalsIgnoreCase(String str) // 忽略大小写进行比较
```

#### 常用方法

```java
public int length();//获取字符串当中含有的字符个数，拿到字符串长度 
public String concat(String str);//将当前字符串和参数字符串拼接成为返回值新的字符串
public char charAt(int index);//获取指定索引位置的单个字符。
public int indexOf(String str);//查找参数字符串在本字符串当中首次出现的索引位置，如果没有返回-1值
```





## 其他



### 正则表达式

---

``` java
/**
注：
在其他语言中，\\ 表示：我想要在正则表达式中插入一个普通的（字面上的）反斜杠，请不要给它任何特殊的意义。

在 Java 中，\\ 表示：我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义。

所以，在其他的语言中（如Perl），一个反斜杠 \ 就足以具有转义的作用，而在 Java 中正则表达式中则需要有两个反斜杠才能被解析为其他语言中的转义作用。也可以简单的理解在 Java 的正则表达式中，两个 \\ 代表其他语言中的一个 \，这也就是为什么表示一位数字的正则表达式是 \\d，而表示一个普通的反斜杠是 \\\\。

在js语法中修饰符为 /正则匹配式主体/ ， 及使用反斜杠包含匹配式 
*/
```



### IDEA相关

---

#### 快捷缩写

```java
psvm	=	public static void main(){};
sout	=	System.out.println();
6.fori  =   for (int i = 6; i > 0; i++) {}
6.forr  =   for (int i = 6; i > 0; i--) {}


```

#### 快捷键

| 快捷键                 | 结果                              |
| ---------------------- | --------------------------------- |
| **Alt+Enter**          | 导入包，或者自动修正代码          |
| **Ctrl+Alt+L**         | 格式化代码                        |
| **Alt+/**              | 打开提示行                        |
| Ctrl+Y                 | 删除光标所在行                    |
| **Ctrl+D**             | 复制光标所在行，到其下一行        |
| Ctrl+/                 | 单行注释		//                |
| Ctrl+Shift+/           | 多行注释		/**/              |
| Alt+Ins                | 自动生成代码，toString; get; set; |
| Alt+shift+上下         | 移动当前代码行                    |
| **Alt+Insert**         | 打开Code选项中的快速构造器        |
| **Ctrl+N**             | 查找类                            |
| **Ctrl+Shift+N**       | 查找文件                          |
| **Ctrl+R**             | 替换文本                          |
| **Ctrl+Shift+Space**   | 自动补全代码                      |
| **Ctrl+space**         | 代码提示                          |
| **Ctrl+Alt+space**     | 类名或者接口名提示                |
| **Ctrl+P**             | 方法参数提示                      |
| Ctrl+shift+Alt+N       | 查找类中的方法或者变量            |
| Ctrl+J                 | 自动代码                          |
| Ctrl+E                 | 最近打开的文件                    |
| Ctrl+H                 | 显示类结构图                      |
| Ctrl+Q                 | 显示注释文档                      |
| Alt+F1                 | 查找代码所在位置                  |
| Alt+left/right         | 切换代码视图                      |
| **Alt+Up/Down**        | 在方法间快速移动定位              |
| **Ctrl+Shift+Up/Down** | 代码向上/向下移动                 |
| Ctrl+W                 | 选中代码。连续按有其他效果        |
| Ctrl+P                 | 显示参数信息                      |
|                        |                                   |

