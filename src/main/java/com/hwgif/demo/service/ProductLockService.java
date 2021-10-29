package com.hwgif.demo.service;


import com.hwgif.common.db.domain.PageControl;
import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.demo.bean.ProductLock;

/**
 * 产品信息表
 * @author lc.huang
 * @date 2021-10-29 9:27:31
 */
public interface ProductLockService {

        Integer insertProductLock(ProductLock productLock);

        ProductLock find(Integer id);

        Integer deleteLogical(Integer id);

        Integer deleteBatch(String[] ids);

        Integer updateProductLock(ProductLock productLock);

        PageControl<ProductLock> pageAndSortById(ProductLock productLock, PageInfo pageInfo);

        PageControl<ProductLock> page(ProductLock productLock, PageInfo pageInfo, String whereSql, String orderSql);

        ProductLock updateStock(Integer id,Integer stock);
 }
