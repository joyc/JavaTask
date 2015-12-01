package Mp3IO;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Rusher on 15/12/2.
 */
public class Mp3Read {

    public static void main(String[] args) {    //创建主方法
        listFilesMp3(); //调用自定义方法列出 MP3文件   //不知道对不对 需老师确认并说明
    }

    private static void listFilesMp3(){ //创建自定义方法查找mp3文件

        File file = new File("src/mp3");    //命名并指定目录
        String[] fileStrings=file.list(new FilenameFilter() {   //这里有点概念模糊，需老师解答

            @Override   //这里不知道是否需要
            public boolean accept(File dir, String name) {  //用java.io包的FilenameFilter接口的accept方法查找
                return name.endsWith(".mp3");  //只查找后缀名为mp3的文件
            }
        });
        for(int i = 0;i < fileStrings.length;i++)   //循环并打印出查找列表数组
        {
            System.out.println(fileStrings[i]);
        }
    }
}
