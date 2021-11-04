
package com.hwgif.demo.service;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.User;
import com.hwgif.example.easyexcel.bean.UserExcelBean;

import java.util.List;


/**
 * 用户
 * @author lc.huang
 * @date 2019-11-19 16:08:50
 */
public interface UserService {

        Integer insertUser(User user);

        User find(Integer id);

        Integer deleteLogical(Integer id);

        Integer updateUser(User user);

        PageControl<User> pageAndSortById(User user, PageInfo pageInfo);

        PageControl<User> page(User user, PageInfo pageInfo, String whereSql, String orderSql);

//    Integer delete(Integer id, Integer updateId);

        List<UserExcelBean> getdata(Integer page);
 }
