//package com.hwgif.common.util;
//
//import com.hwgif.example.bean.DataExchangePackageUtil;
//import com.hwgif.example.bean.TaxData;
//import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Component;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.Unmarshaller;
//import java.io.*;
//
///**
// * 目的于 xml 处理操作
// *
// */
//@Component
//public class XmlUtil {
//
//    public static <T> T toObject(Class<T> clazz, String xml) {
//        try {
//            JAXBContext context = JAXBContext.newInstance(clazz);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            return (T) unmarshaller.unmarshal(new StringReader(xml));
//        } catch (Exception e) {
//            throw new RuntimeException("");
//        }
//    }
//
//    public static String toXml(Class clazz, Object object) {
//        return toXml(clazz, object, false);
//    }
//
//    public static String toXml(Class clazz, Object object, boolean flag) {
//        try {
//            JAXBContext context = JAXBContext.newInstance(clazz);
//            Marshaller marshaller = context.createMarshaller();
//            //格式化输出
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, flag);
//            //取消xml头部
//            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
//            //取消特殊字符转译
//            marshaller.setProperty("com.sun.xml.bind.characterEscapeHandler", new CharacterEscapeHandler() {
//                @Override
//                public void escape(char[] ch, int start, int length, boolean b, Writer writer) throws IOException {
//                    writer.write(ch, start, length);
//                }
//            });
//            StringWriter writer = new StringWriter();
//            writer.write("<?xml version=\'1.0\' encoding=\'GBK'?>");
//            marshaller.marshal(object, writer);
//            return writer.toString();
//        } catch (Exception e) {
//
//            throw new RuntimeException("接口报文错误");
//        }
//    }
//
//    public static String readFromClassPathFile(String filePath) throws IOException {
//        Resource resource = new ClassPathResource(filePath);
//        InputStream is = resource.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
//        String data = null;
//        String fileText = "";
//        while((data = br.readLine()) != null) {
//            fileText += data;
////            System.out.println(data);
//        }
//        br.close();
//        isr.close();
//        is.close();
//       // System.out.println(fileText);
//        return fileText;
//    }
//
//     public static void main(String[] args) throws IOException{
//
//       String xml = XmlUtil.readFromClassPathFile("files/xml.xml");
//
//       TaxData data = DataExchangePackageUtil.toData(xml);
//         System.out.println(data.getNsrlx());
//    }
//}
