多态性  
1. 方法的重载与覆写
2. 对象的多态性  
    ①.向上转型：子类对象→父类对象 （自动完成）  
    ②.向下转型：父类对象→子类对象 （强制）  
进行向下转型时，需首先发生对象的向上转型。  
在进行对象的向下转型关系前最好先使用*instanceof*进行判断后再进行相应的转换操作，这样可以避免类型转换异常的出现。  

注意：在类的设计中，不要集成一个已经实现的类，只能继承抽象类和实现接口。因为一旦发生对象向上转型后，所调用的方法一定是被子类所覆写的方法。  
**接口**是解决多继承局限的一种手段，实际中更多的作用是用来制定标准。  
#### 设计模式
**工厂模式**  
```java
class Factory{
	public static Fruit getInstance(String className){
		Fruit f = null;
		if ("apple".equals(className)){
			f = new Apple();
		}
		if ("orange".equals(className)){
			f = new Orange();
		}
		return f;
	}
}
```
程序在接口和子类之间加入了一个过渡端，通过此过渡端取得接口的实例化对象，这个过渡端称为工厂类。  
字符串判断时把字符串常量放在前面会避免空指向异常。 
#### 代理模式
代理模式是指由一个代理主题来操作真实主题，真实主题执行具体的业务操作，而代理主题负责其他相关业务的处理。
```java
package InterfaceDemo;
interface Network{
	public void browse();
}
class Real implements Network{
	public void browse(){
		System.out.println("上网浏览信息");
	}
}
class Proxy implements Network{
	private Network network;
	public Proxy(Network network){
		this.network = network;
	}
	public void check(){
		System.out.println("检查用户是否合法");
	}
	public void browse(){
		this.check();
		this.network.browse();
	}
}
public class ProxyDemo {
	public static void main(String args[]){
		Network net = null;
		net = new Proxy(new Real());
		net.browse();
	}
}
```
#### 适配器模式
如果一个类要实现一个接口，则必须要覆写此接口中的全部抽象方法，那么如果此时一个接口中定义的抽象方法过多，但是在子类中又用不到这么多抽象方法，肯定很麻烦，所以此时就需要一个中间的过渡，但是此时过渡类又不希望被直接使用，所以将此过渡类定义成抽象类最合适，即一个接口首先被一个抽象类先实现（此抽象类通常称为适配器类），并在此抽象类中实现若干方法（方法体为空），则以后的子类直接继承此抽象类，就可以有选择地覆写所需要的方法。
```
package InterfaceDemo;
interface Window{
	public void open();
	public void close();
	public void activated();
	public void iconified();
	public void deiconified();
}
abstract class WindowAdapter implements Window{
	public void open(){}
	public void close(){}
	public void activated(){}
	public void iconified(){}
	public void deiconified(){}
}
class WindowImpl extends WindowAdapter{
	public void open(){
		System.out.println("窗口打开。");
	}
	public void close(){
		System.out.println("窗口关闭。");
	}
}

public class AdapterDemo {
	public static void main(String[] args) {
		Window win = new WindowImpl();
		win.open();
		win.close();
	}
}
```

序号 | 区别点 | 抽象类 | 接口
:---:|---|---|---
1 | 定义 | 包含一个抽象方法的类 | 抽象方法和全局变量的集合
2 | 组成 | 构造方法，抽象方法，普通方法，常量，变量 | 常量，抽象方法
3 | 使用 | 子类继承抽象类（extends） | 子类实现接口（implements）
4 | 关系 | 抽象类可以实现多个接口 | 接口不能继承抽象类，但允许继承多个接口
5 | 常见设计模式 | 模板设计 | 工厂设计，代理设计
6 | 对象 |都通过对象的多态性产生实例化对象 | ← same
7 | 局限 | 抽象类有单继承的局限 | 接口没有此局限
8 | 实际 | 作为一个模板 | 作为一个标准或表示一种能力
9 | 选择 | 如果抽象类和接口都可以使用，则优先使用接口，避免单继承的局限 | ← same 
10 | 特殊 | 一个抽象类中可以包含多个接口，一个接口中可以包含多个抽象类 | ← same 
注意：  
一个类不要去继承一个已经实现好的类，只能继承抽象类或者实现接口，如果接口和抽象类都可以使用，那么悠闲使用接口，避免单继承局限。  

##### 宠物商店案例
```java
package com.lxhjava;
interface Pet{
	public String getName();
	public String getColor();
	public int getAge();
}
class Cat implements Pet{
	private String name;
	private String color;
	private int age;
	public Cat(String name,String color,int age){
		this.setName(name);
		this.setColor(color);
		this.setAge(age);
	}
	public void setName(String name){
		this.name = name ;
	}
	public void setColor(String color){
		this.color = color;
	}
	public void setAge(int age){
		this.age = age ;
	}
	public String getName(){
		return this.name ;
	}
	public String getColor(){
		return this.color ;
	}
	public int getAge(){
		return this.age ;
	}
}
class Dog implements Pet{
	private String name;
	private String color;
	private int age;
	public Dog(String name,String color,int age){
		this.setName(name);
		this.setColor(color);
		this.setAge(age);
	}
	public void setName(String name){
		this.name = name;
	}
	public void setColor(String color){
		this.color = color;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String  getName(){
		return name;
	}
	public String getColor(){
		return color;
	}
	public int getAge(){
		return age;
	}
}
class PetShop{
	private Pet[] pets;
	private int foot;
	public PetShop(int len){
		if(len>0){
			this.pets = new Pet[len];
		}else{
			this.pets = new Pet[1];
		}
	}
	public boolean add(Pet pet){
		if (this.foot < this.pets.length) {
			this.pets[this.foot] = pet;
			this.foot++;
			return true;
		}else {
			return false;
		}
	}
	public Pet[] search(String keyword){
		Pet[] p = null;
		int count = 0;
		for(int i = 0; i < this.pets.length; i++){
			if (this.pets[i] != null) {
				if (this.pets[i].getName().indexOf(keyword) != -1 
						||this.pets[i].getColor().indexOf(keyword) != -1) {
					count++;
				}
			}
		}
		p = new Pet[count];
		int f = 0;
		for(int i = 0; i < this.pets.length;i++){
			if (this.pets[i]!=null) {
				if (this.pets[i].getName().indexOf(keyword)!=-1
						||this.pets[i].getColor().indexOf(keyword)!=-1) {
					p[f] = this.pets[i];
						f++;
				}
			}
		}
		return p;
	}
}
public class PetShopDemo {
	public static void main(String[] args) {
		PetShop ps = new PetShop(5);
		ps.add(new Cat("白猫", "白色", 2));
		ps.add(new Cat("黑猫", "黑色", 1));
		ps.add(new Cat("花猫", "花色", 3));
		ps.add(new Dog("白狗", "白色", 2));
		ps.add(new Dog("黑狗", "黑色", 1));
		ps.add(new Dog("花狗", "花色", 3));
		print(ps.search("黑"));
	}
	public static void print(Pet p[]) {
		for(int i = 0;i < p.length;i++){
			if (p[i]!=null) {
				System.out.println(p[i].getName()+","
						+p[i].getColor()+","
						+p[i].getAge());
			}
		}
	}
}
```
Object的toString方法
```java
package com.lxhjava;
class Person{
	private String name ;	// 定义name属性
	private int age ;		// 定义age属性
	public Person(String name,int age){
		this.name = name ;
		this.age = age ;
	}
	public boolean equals(Object obj){
		if(this==obj){		// 地址相等
			return true ;	// 肯定是同一个对象
		}
		if(!(obj instanceof Person)){	// 不是Person对象
			return false ;
		}
		Person per = (Person) obj ;	// 向下转型
		if(per.name.equals(this.name)&&per.age == this.age){
			return true ;	// 依次比较内容
		}else{
			return false ;
		}
	}
	public String toString(){
		return "姓名：" + this.name + "；年龄：" + this.age ;
	}
};
public class ObjectDemo03{
	public static void main(String args[]){
		Person per1 = new Person("李兴华",30) ;	 // 实例化Person
		Person per2 = new Person("李兴华",30) ;	 // 实例化Person
		System.out.println(per1.equals(per2)?"是同一个人！" : "不是同一个人！") ;
		System.out.println(per1.equals("hello")?"是同一个人！" : "不是同一个人！") ;
	}
};
```
##### 包装类
| 序号 | 基本数据类型 | 包装类 |
| --- | --- | --- |
| 1 | int | Integer |
| 2 | char | Character |
| 3 | short | Short |
| 4 | long | Long |
| 5 | float | Float |
| 6 | double | Double |
| 7 | boolean | Boolean |
| 8 | byte | Byte |

###### 装箱和拆箱
将一个基本数据类型变为包装类，叫装箱；将一个包装类变为基本数据类型，叫拆箱。  
```java
public class WrapperDemo01{
	public static void main(String args[]){
		int x = 30 ;		// 基本数据类型
		Integer i = new Integer(x) ;	// 装箱：将基本数据类型变为包装类
		int temp = i.intValue()	;// 拆箱：将一个包装类变为基本数据类型
	}
};
```
#### 异常处理Throw和Throws
`throws`  
在定义一个方法是可以使用throws关键字声明，使用throws声明的方法表示此方法不处理异常，而交给方法的调用处进行处理。throws用在方法声明处，表示本方法不处理异常。格式如下：
```java
public 返回值类型 方法名称（参数列表…） throws 异常类{}
```
*在主方法中使用了throws，程序主方法中就不用再使用try……catch了*

`throw`  
可以直接使用throw抛出一个异常，抛出时直接抛出异常类的实例化对象即可。throw表示在方法中手工抛出一个异常。*throw不会单独使用。*  
##### 断言
断言就是肯定某一个结果的返回值是正确的，如果最终此结果的返回值是错误的，则通过断言检查肯定会提示错误。如果boolean为true则不显示错误信息false则显示，一般开发中不建议用来检测。定义格式如下：
```java
assert boolean表达式;
assert blooean表达式 : 详细的信息;
```
>异常的最大父类是Throwable，其分为两个子类Exception，Error。前者表示程序处理的异常，后者是JVM的错误信息。自定义异常时，只需继承Exception类即可。

#### 包及访问权限

##### java常用系统包
| 序号 | 包名称 | 作用 |
| --- | --- | --- |
| 1 | java.lang | 此包为基本包，String都保存在此包，jdk1.0后会自动导入。 |
| 2 | java.lang.reflect | 反射机制包，是java.lang子包。 |
| 3 | java.util | 工具包，常见类库，日期操作等都在此包，精通此包便于理解设计思路。 |
| 4 | java.text | 提供文本处理类库。 |
| 5 | java.sql | 数据库操作包，提供各数据库操作的类和接口。 |
| 6 | java.net | 完成网络编程。 |
| 7 | java.io | 输入输出处理。 |
| 8 | java.awt | 包含了构成抽象窗口工具集(abstract window toolkits)的多个类，这些类用来构建和管理GUI。 |
| 9 | javax.swing | 用于建立图形用户界面，组件相对java.awt是轻量级组件。 |

##### 多线程
实现 Runnable 接口相对于继承 Thread 类有如下优势：  
1.适合多个相同程序代码的线程去处理同一资源的情况。  
2.可以避免由 java 单继承特性带来的局限。  
3.增强了程序的健壮性，代码能被多个线程共享，代码与数据是独立的。

线程的5种状态：创建→就绪→运行→阻塞→终止  
创建状态：Thread thread=new Thread();  
就绪状态：调用该线程的start()方法就可启动线程  
运行状态：调用该线程的run()方法  
堵塞状态：sleep(),suspend(),wait()  
死亡状态：调用该线程的stop()方法  

#### Thread类中的主要方法
| 序号 |方 法 名 称|类型|描述|
| --- | --- | --- | --- |
|1|public Thread(Runnable target)|构造|接收Runnable接口子类对象，实例化Thread对象|
|2|public Thread(Runnable target,String name)|构造|接收Runnable接口子类对象，实例化Thread对象并设置线程名称|
|3|public Thread(String name)|构造|实例化Thread对象并设置线程名称|
|4|public static Thread currentThread()|普通|返回目前正在执行的线程|
|5|public final String getName()|普通|返回线程的名称|
|6|public final int getPriority()|普通|返回线程的优先级|
|7|public boolean isInterrupted()|普通|判断线程是否被中断，返回布尔值|
|8|public final boolean isAlive()|普通|判断线程是否在活动，返回布尔值|
|9|public final void join() throws Interrupted Exception|普通|等待线程死亡|
|10|public final synchronized void join(long millis) throws InterruptedException|普通|等待millis毫秒后线程死亡|
|11|public void run()|普通|执行线程|
|12|public final void setName(String name)|普通|设定线程名称|
|13|public final void setPriority(int newPriority)|普通|设定线程优先级|
|14|public static void sleep(long millis) throws InterruptedException|普通|使当前线程休眠millis毫秒|
|15|public void start()|普通|开始执行线程|
|16|public String toString|普通|返回代表线程的字符串|
|17|public static void yield()|普通|暂停当前线程，允许其他线程执行|
|18|public final void setDaemon(boolean on)|普通|将一个线程设置成后台运行|

#### 同步与死锁

同步代码块格式：
```java
synchronized(同步对象){
    需要同步的代码 ;
}
```
同步方法格式：
```java
synchronized 方法返回值 方法名称(参数列表){
}
```
方法定义的完整格式：  
```java
访问权限{public|default|protected|private} [final] [static] [synchronized]   
返回值类型|void 方法名称(参数类型 参数名称,...) [throws Exception1,Exception2] {
 [return [返回值|返回调用处]];
}
```
