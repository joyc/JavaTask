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
