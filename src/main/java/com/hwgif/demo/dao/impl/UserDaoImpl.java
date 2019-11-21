package com.hwgif.demo.dao.impl;

import com.hwgif.common.db.dao.BaseDao;
import com.hwgif.demo.bean.User;
import com.hwgif.demo.dao.UserDao;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * 用户
 * @author lc.huang
 * @date 2019-11-19 16:08:50
 */
@Repository
@CacheConfig(cacheNames="userCache")
public class UserDaoImpl extends BaseDao<Integer, User> implements UserDao {

    @CachePut(key = "#entity.id")
    public User insertAndCahe(User entity) {
        this.insert(entity);
        return entity;
    }
    @Cacheable(key = "#id")
    public User findUser(Integer id){
        return this.getEntityById(id);
    }

    @CachePut(key = "#user.id")
    public User UpdateUser(User user){
        this.update(user);
        return user;
    }
}
