package com.hwgif.demo.dao.impl;

import com.hwgif.common.db.dao.BaseDao;
import com.hwgif.demo.bean.User;
import com.hwgif.demo.dao.UserDao;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<User> exportuser(String whereSql, String orderBySql){
        Map<String,String> params = new HashMap();
        params.put("whereSql",whereSql);
        params.put("orderBy",orderBySql);

        List<User> users =  this.getSqlSession().selectList(this.getMapperNameSpace() + ".exportUser" ,params);

        return users;
    }
}
