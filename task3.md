写一个函数用于求出整数数组中的最大值，要求：  
1. 数组长度为10   
2. 自行填充数组中的整数值   
3. 把查找算法封装到方法中，传入参数为数组，返回最大值   
4. 把结果输出到屏幕   

code:
```java
package com.jkxy.task3;

/**
 * Created by Rusher on 2015/11/30.
 */
public class Main { //创建主类
    public static void main(String[] args){ //创建主函数方法

    int[] myArray ={11,23,15,22,56,27,33,36,48,66}; //给出十组数值

        for (int i = 0; i < myArray.length; i++) {  //遍历并打印数组
            System.out.println(myArray);
        }
        int max = new GetMax().getOne(myArray); //用匿名内部类得到最大值 max
        System.out.println("以上数组中的最大值为："+max);    //打印出最大值max
    }
}

class GetMax {  //内部类构建查找方法

    protected int getOne(int[] myArray){  //保护查找函数方法
        int max = 0;
        max = myArray[0];   //定义初始查找值
        for (int i = 0; i < myArray.length; i++) {  //循环查找方法
            if(myArray[i]>max){
                max = myArray[i];
            }
        }
        return max; //返回最大值
    }
}
```
作业遗留问题：   
1.把查找算法封装到方法中，传入参数为数组 这里不是太懂。有范例或者优秀作业的话，希望参考学习。
2.如果内部类或者外部类有private 属性的话，该如何访问该方法。
3.本机打印设定的数组时候。会显示乱码，是什么原因及如何解决。
谢谢老师！

