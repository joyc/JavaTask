package task1;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Rusher on 15/12/2.
 */
public class Mp3Read {

    public static void main(String[] args) {    //创建主方法
        File file = new File("src/mp3");    //命名并指定目录
        listFilesMp3(file); //调用自定义方法列出 MP3文件
    }

    // Q1 用递归查询是否为文件夹，这里的递归查询不会写！！！
    public static void listFilesMp3(File file){ //创建自定义方法查找mp3文件，假设为文件夹 // Q2 这里参数的设置

        File[] files = file.listFiles();    // 该文件目录下文件全部放入数组
        for (File f:files){ //循环遍历数组   // Q3 这个写法
            if (f.isDirectory()){
                System.out.println("包含的子文件夹目录是："+f.getAbsolutePath());
                listFilesMp3(f);    //如果是文件夹就重新遍历
            }else{  //如果是文件就打印出路径
                System.out.println(f.getAbsolutePath());
            }
        }

        String[] fileStrings=file.list(new FilenameFilter() {   //这里有点概念模糊

            @Override   //这里不知道是否需要
            public boolean accept(File dir, String name) {  //用java.io包的FilenameFilter接口的accept方法查找
                return name.endsWith(".mp3");  //只查找后缀名为mp3的文件
            }
        });

        for(int i = 0;i < fileStrings.length;i++){   //循环并打印出查找列表数组
            System.out.println("  -  "+fileStrings[i]);
        }
    }

}
