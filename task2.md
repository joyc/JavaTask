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
|                  | ASCII                        | HTML              |
 ----------------- | ---------------------------- | ------------------
| Single backticks | `'Isn't this fun?'`            | 'Isn't this fun?' |
| Quotes           | `"Isn't this fun?"`            | "Isn't this fun?" |
| Dashes           | `-- is en-dash, --- is em-dash` | -- is en-dash, --- is em-dash |
