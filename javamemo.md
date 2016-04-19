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
