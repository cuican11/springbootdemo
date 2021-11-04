package com.hwgif.common.util;

public class FilePathUtil {

    public static String getRsourceFilesPath(){
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"files";

        return path;
    }
}
