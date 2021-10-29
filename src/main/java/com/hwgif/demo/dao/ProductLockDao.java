package com.hwgif.demo.dao;
import com.hwgif.common.db.dao.IDao;
import com.hwgif.demo.bean.ProductLock;

/**
 * 产品信息表
 * @author lc.huang
 * @date 2021-10-29 9:27:31
 */
public interface ProductLockDao extends IDao<Integer, ProductLock> {

    Integer updateStock(ProductLock productLock);

    Integer updateStockCommon(ProductLock productLock);
}
