package com.hwgif.example.easyexcel.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.hwgif.demo.bean.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UserExcelBean {

    @ExcelProperty("名称")
    private String name;
    @ExcelProperty("昵称")
    private String nick;
    @ExcelProperty("电话")
    private String phone;
    @ExcelProperty("邮箱")
    private String email;
    @ExcelProperty("创建日期")
    private Date date;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String password;

    public UserExcelBean() {
    }

    public UserExcelBean(User user) {
        this.name = user.getName();
        this.nick = user.getNick();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.date = user.getCreateTime();
        this.password = user.getPassword();
    }

    public static List<UserExcelBean> getList(List<User> users){

        List<UserExcelBean> beans = new ArrayList<UserExcelBean>();
        if (null != users && users.size() > 0){
            for (User user:users) {
                beans.add(new UserExcelBean(user));
            }
        }
        return beans;
    }

}
