
package com.hwgif.demotwo.dao.impl;

import com.hwgif.common.db.dao.BaseDao;
import com.hwgif.demotwo.bean.UserNd;
import com.hwgif.demotwo.dao.UserNdDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 用户
 * @author lc.huang
 * @date 2019-11-20 14:37:23
 */
@Repository
public class UserNdDaoImpl extends BaseDao<Integer, UserNd> implements UserNdDao {
    @Override
    @Resource(name = "sqlSessionFactoryTwo")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

}
