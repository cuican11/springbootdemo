package com.hwgif.demo.dao;

import com.hwgif.common.db.dao.IDao;
import com.hwgif.demo.bean.User;

/**
 * 用户
 * @author lc.huang
 * @date 2019-11-19 16:08:50
 */
public interface UserDao extends IDao<Integer, User> {

    User insertAndCahe(User entity);

    User findUser(Integer id);

    User UpdateUser(User user);
}
