package com.hwgif.common.controller;

import sun.misc.BASE64Decoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class IOController {

    //向浏览器输出文件
    private void responseFileStream(HttpServletResponse response, String filePath) {
        ServletOutputStream out = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(new File(filePath));
            String[] dir = filePath.split("/");
            String fileName = dir[dir.length - 1];
            String[] array = fileName.split("[.]");
            String fileType = array[array.length - 1].toLowerCase();
            //设置文件ContentType类型
            if ("jpg,jepg,gif,png".contains(fileType)) {//图片类型
                response.setContentType("image/" + fileType);
            } else if ("pdf".contains(fileType)) {//pdf类型
                response.setContentType("application/pdf");
            } else {//自动判断下载文件类型
                response.setContentType("multipart/form-data");
            }
            //设置文件头：最后一个参数是设置下载文件名
            //response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
            out = response.getOutputStream();
            // 读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (FileNotFoundException e) {

        } catch (Exception e) {

            try {
                out.close();
                in.close();
            } catch (Exception ss) {

            }
        }
    }


    /**
     * pdf的base64 字符串数据 输出浏览器成文件下载
     * @param response
     * @param base64Content
     */
    private void responsePdfBase64Content(HttpServletResponse response, String base64Content) {
        BASE64Decoder decoder = new BASE64Decoder();
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ServletOutputStream out = null;
        FileInputStream in = null;
        try {
            byte[] bytes = decoder.decodeBuffer(base64Content);// base64编码内容转换为字节数组
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
            bis = new BufferedInputStream(byteInputStream);
            //设置文件ContentType类型
            //pdf类型
            response.setContentType("application/pdf");
            //设置文件头：最后一个参数是设置下载文件名
            response.setHeader("Content-Disposition", "attachment;fileName=无犯罪记录证明.pdf");
            out = response.getOutputStream();
            // 读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = bis.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (FileNotFoundException e) {

        } catch (Exception e) {

            try {
                out.close();
                in.close();
            } catch (Exception ss) {

            }
        }
    }
}
