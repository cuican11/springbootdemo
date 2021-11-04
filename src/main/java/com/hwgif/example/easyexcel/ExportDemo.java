package com.hwgif.example.easyexcel;


import com.alibaba.excel.EasyExcel;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.util.FilePathUtil;
import com.hwgif.demo.bean.User;
import com.hwgif.demo.dao.UserDao;
import com.hwgif.demo.service.UserService;
import com.hwgif.example.easyexcel.bean.UserExcelBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * easyExcel 导出demo
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExportDemo {

    @Autowired
    UserDao  userDao;




    /**
     * 数据
     * @return
     */
    private List<UserExcelBean> data() {
        List<UserExcelBean> list = new ArrayList<UserExcelBean>();
        for (int i = 0; i < 10; i++) {
            UserExcelBean data = new UserExcelBean();
            data.setName("字符串" + i);
            data.setNick("字符串" + i);
            data.setPhone("字符串" + i);
            data.setEmail("字符串" + i);
            data.setDate(new Date());
            list.add(data);
        }
        return list;
    }

    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link  }
     * <p>
     * 2. 直接写即可
     */
    public void simpleWrite() {
        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = FilePathUtil.getRsourceFilesPath() + "/simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, UserExcelBean.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });

//        // 写法2
//        fileName = FilePathUtil.getRsourceFilesPath() + "/simpleWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        // 如果这里想使用03 则 传入excelType参数即可
//        EasyExcel.write(fileName, User.class).sheet("模板").doWrite(data());
//
//        // 写法3
//        fileName = FilePathUtil.getRsourceFilesPath() + "/simpleWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写
//        ExcelWriter excelWriter = null;
//        try {
//            excelWriter = EasyExcel.write(fileName, User.class).build();
//            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//            excelWriter.write(data(), writeSheet);
//        } finally {
//            // 千万别忘记finish 会帮忙关闭流
//            if (excelWriter != null) {
//                excelWriter.finish();
//            }
//        }
    }
}
