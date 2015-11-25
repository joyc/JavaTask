写一个函数用于求出整数数组中的最大值，要求：  
1. 数组长度为10   
2. 自行填充数组中的整数值   
3. 把查找算法封装到方法中，传入参数为数组，返回最大值   
4. 把结果输出到屏幕   

code:
```java
package com.jkxy.task3;

import java.util.Random;

/**
 * 
 * @author a5095153
 *
 */
public class array {
	public static void main(String[] args) {
		 Random random = new Random();
		 int[] intArray = new int[10]; //创建并开辟10个数的数组空间
//		
//		 int i;
//		 for (i = 1; i < 11 ; i++ ){
//		 System.out.println("Array[i] = "+(i));
//		 }

//		Random random = new Random();
//		int[] array = new int[10];
//		for (int i = 0; i < 10; i++) {
//			array[i] = random.nextInt(10);
//		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(array[i]);
//		}
//		
		for (int i = 0; i < 10; i++){
			int[] intArray = Random.nextInt(10);
		}
		for (int i = 0; i < 10; i++){
			System.out.println(intArray[i]);
		}
	}

}

```
测试结果  
问题
