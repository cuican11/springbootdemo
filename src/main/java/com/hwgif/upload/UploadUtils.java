package com.hwgif.upload;


import com.hwgif.common.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.UUID;

public class UploadUtils {

        private static String UPLOAD_URL = "";
/**
 * 文件上传方法
 */
public static CommonResult uploading(MultipartFile file) {
        //获取文件名
        String realName = file.getOriginalFilename();
        String newName = null;
        if(realName != null && realName != ""){
        //获取文件后缀
        String suffixName = realName.substring(realName.lastIndexOf("."));
        //生成新名字
        newName = UUID.randomUUID().toString().replaceAll("-", "")+suffixName;
        }else {
        return CommonResult.failResult("文件名不可为空");
        }
        //创建流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //创建通道
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
        fis = (FileInputStream)file.getInputStream();
        //开始上传
        fos = new FileOutputStream(UPLOAD_URL+"\\"+newName);
        //通道间传输
        inChannel = fis.getChannel();
        outChannel = fos.getChannel();
        //上传
        inChannel.transferTo(0,inChannel.size(),outChannel);

        }catch (IOException e){
        return CommonResult.failResult("文件上传路径错误");
        }finally {
        //关闭资源
        try {
        if (fis != null) {
        fis.close();
        }
        if (fos != null) {
        fos.close();
        }
        if (inChannel != null) {
        inChannel.close();
        }
        if (outChannel != null) {
        outChannel.close();
        }
        } catch (IOException e) {
        e.printStackTrace();
        }
        }
        return CommonResult.successResult(newName);

        }
}