package com.hwgif.demo.dao.impl;


import com.hwgif.common.db.dao.BaseDao;
import com.hwgif.demo.bean.ProductLock;
import com.hwgif.demo.dao.ProductLockDao;
import org.springframework.stereotype.Repository;

/**
 * 产品信息表
 * @author lc.huang
 * @date 2021-10-29 9:27:31
 */
@Repository
public class ProductLockDaoImpl extends BaseDao<Integer, ProductLock> implements ProductLockDao {

    public Integer updateStock(ProductLock productLock){
        return this.getSqlSession().update(this.getMapperNameSpace() + ".updateStock",productLock);
    }

    public Integer updateStockCommon(ProductLock productLock){
        return this.getSqlSession().update(this.getMapperNameSpace() + ".updateStockCommon",productLock);
    }
}
