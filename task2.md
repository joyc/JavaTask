superlottery
```java
package com.jikexueyuan.task02;

import java.util.Random;

/**
 * Created by Rusher on 2015/11/23.
 */
public class SuperLottery {
    public static void main(String[] args){
/**
 * 声明并为红色绿色球数组和双色球开奖结果数组开辟内存
 */
        int[] red = new int[35];    //  红色球35
        int[] blue = new int[12];   //  绿色球12
        int[] result = new int[7];  //  双色球结果7
/**
 * 循环红色球red
 */
        for (int r = 0; r < red.length; r++) {
            red[r] = r + 1;
        }
/**
 * 循环蓝色球blue
 */
        for (int b = 0; b < blue.length; b++) {
            blue[b] = b + 1;
        }
/**
 * 循环开奖结果result
 */
        for (int r2 = 0; r2 < 5; r2++) {
            int temp = red[new Random().nextInt(34)];
            result[r2] = temp;
            for (int b2 = 5; b2 < 7; b2++) {
                int _temp = blue[new Random().nextInt(12)];
                result[b2] = _temp;
            }
        }
/**
 * 打印开奖结果
 */
        System.out.println("本期大乐透开奖结果是:");
        for (int k = 0; k < result.length; k++) {
            System.out.println(result[k]);
        }

    }

}
```
11/28 修改：
```java
package com.jikexueyuan.task02;

import java.util.Random;

/**
 * Created by Rusher on 2015/11/23.
 * Revised on 2015/11/28
 */
public class SuperLottery {
    /**
     *声明并创建Boolean函数，判断是否重复，重复则返回true
     */
    public static boolean isRepeat (int[] arr, int number){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == number){
                return true;
            }
        }
        return false;
    }

    /**
     *创建主函数main
     */
    public static void main(String[] args){
        int[] red = new int[35];    //声明并创建内存，红色球35个
        int[] blue = new int[12];   //声明并创建内存，蓝色球12个
        int[] result = new int[7];  //声明并创建内存，开奖结果为7个数字
        System.out.println("本期大乐透开奖结果是:");
        /**
         * 循环红色球35个，随机选取不重复5个
         */
        for (int r = 0; r < red.length; r++) {  //遍历红色球数组
            red[r] = r + 1;
        }
        for (int r2 = 0; r2 < 5; r2++) {    //取5个红色球
            int temp_r = red [new Random().nextInt(34)+1];  //随机选取从1到35之间的值
            if (isRepeat(result,temp_r)){  //判断是否重复
                r2--;   //意思不明
                continue;   //结束单次循环
            }
            result[r2] = temp_r;
            System.out.println("红色球："+result[r2]);
        }
        /**
         * 循环蓝色球12个，随机选取不重复2个
         */
        for (int b = 0; b < blue.length; b++){
            blue[b] = b + 1;
        }
        for (int b2 = 0; b2 < 2; b2++){
            int temp_b = blue[new Random().nextInt(11)+1];
            if (isRepeat(result,temp_b)){
                b2--;
                continue;
            }
            result[b2] = temp_b;
            System.out.println("蓝色球："+result[b2]);
        }
        /**
         * 打印开奖结果
         */
        System.out.println("本期大乐透开奖结果是:"+result[r2]+" "+result[b2]);
    }
}
```
