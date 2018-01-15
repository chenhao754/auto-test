package com.ch.autotest.utils;

import com.ch.autotest.body.Auto;

import java.io.File;

/**
 * Created by CH on 2018/1/5/005.
 */
public class FileUtils {

    /**
     * 获得文件的绝对路径，以项目名为根目录
     * */
    public static String getAbsolutePath(String filename){
        return new File("").getAbsolutePath()+filename;
    }

}
