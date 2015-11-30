/**
*获取指定后缀文件名
*/
publicclass IOTest {  
publicstaticvoid main(String[] args) {  
        File file = new File("D:/"); //获得指定路径 
        FileFilter fileFilter = new FileFilter("xml"); //文件的后缀名 
        String[] files = file.list(fileFilter);  
for(String fileName : files) {  
            System.out.println(fileName);  
        }  
    }  
}  
class FileFilter implements FilenameFilter { //实现FilenameFilter接口 
private String fileExtension;  
public FileFilter(String fileExtension) {  
this.fileExtension = fileExtension;  
    }  
publicboolean accept(File dir, String name) {  
return name.endsWith("." + fileExtension);  
    }  
}

/**
*目录及其子目录下的所有文件
*/
package Mp3IO;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Rusher on 2015/12/1.
 */
public class Mp3IO {
    public static void main(String[] args) {
        //目录
        File dataDir = new File("F:/task4/mp3");
        //存放目录及其子目录下的所有文件对象
        List<File> myfile = new ArrayList<File>();
        //开始遍历
        listDirectory(dataDir, myfile);

        System.out.println("目录下包含 " + myfile.size() + "个文件：");
        for(File file : myfile){
            System.out.println(file.getAbsolutePath());
        }
    }
    /**
     * 遍历目录及其子目录下的所有文件并保存
     * @param path 目录全路径
     * @param myfile 列表：保存文件对象
     */
    public static void listDirectory(File path, List<File> myfile){
        if (!path.exists()){
            System.out.println("文件名称不存在!");
        }
        else
        {
            if (path.isFile()){
                myfile.add(path);
            } else{
                File[] files = path.listFiles();
                for (int i = 0; i < files.length; i++  ){
                    listDirectory(files[i], myfile);
                }
            }
        }
    }
}
