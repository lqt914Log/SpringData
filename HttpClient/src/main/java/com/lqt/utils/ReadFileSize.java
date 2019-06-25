package com.lqt.utils;

import java.io.File;

/**
 * 读取文件大小
 *
 * @author lqt77
 * @date 2019-06-25-17:00
 */
public class ReadFileSize {

    public static  void main(String [] args){
        File file = new File("D:\\20190604\\peixun\\web_dev\\src\\main\\webapp");
        getDirSize(file);
    }
    public static double getDirSize(File file) {
        //判断文件是否存在
        if (file.exists()) {
            //如果是目录则递归计算其内容的总大小
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                double size = 0;
                for (File f : children){
                    size = getDirSize(f);
                    if(size>50){
                        System.out.println("文件大小为"+size+"KB"+"。。。。文件的路径"+f.getAbsolutePath());
                    }
                }
                return size;
            } else {//如果是文件则直接返回其大小,以“兆”为单位
                double size = (double) file.length() / 1024 ;
                if(size>50.0){
                    System.out.println("文件大小为"+size+"KB"+"。。。。文件的路径"+file.getAbsolutePath());
                }
                return size;
            }
        } else {
            System.out.println("文件或者文件夹不存在，请检查路径是否正确！");
            return 0.0;
        }
    }
}
