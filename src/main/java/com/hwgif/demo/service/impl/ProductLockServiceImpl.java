package com.hwgif.demo.service.impl;

import com.hwgif.common.db.domain.PageControl;
import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.demo.bean.ProductLock;
import com.hwgif.demo.dao.ProductLockDao;
import com.hwgif.demo.service.ProductLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 产品信息表
 * @author lc.huang
 * @date 2021-10-29 9:27:31
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProductLockServiceImpl implements ProductLockService {

	@Autowired
	private ProductLockDao productLockDao;

	public Integer insertProductLock(ProductLock productLock){
		if (productLock == null) {
		return 0;
	}

		Integer i = productLockDao.insert(productLock);
		return i;
	}

	public ProductLock find(Integer id){
		return productLockDao.getEntityById(id);
	}

	public Integer deleteLogical(Integer id){
		ProductLock temp = new ProductLock();
		temp.setId(id);
//		temp.setIsDel(1);
		return productLockDao.update(temp);
	}

    public Integer deleteBatch(String[] ids){
		if (null == ids || ids.length <= 0){
		return 0;
		}
		return 0;
//		return productLockDao.deleteBatch(ids);
	}

	public Integer updateProductLock(ProductLock productLock){
		if (productLock == null) {
			return 0;
		}

		Integer i = productLockDao.update(productLock);
		return i;
	}

	public PageControl<ProductLock> pageAndSortById(ProductLock productLock, PageInfo pageInfo){
		return productLockDao.getPageByObject(productLock, pageInfo, null, " order by id asc ");
	}

	public PageControl<ProductLock> page(ProductLock productLock, PageInfo pageInfo, String whereSql, String orderSql){
		return productLockDao.getPageByObject(productLock, pageInfo, whereSql, orderSql);
	}




	public ProductLock updateStock(Integer id,Integer stock){
		ProductLock productLock = productLockDao.getEntityById(id);

		if (null == productLock){
			return null;
		}
		System.out.println("库存："+ productLock.getStock()+"  预购："+stock);
		if (productLock.getStock().intValue() < stock) {
			return productLock;
		}
		System.out.println("进入update");
		ProductLock temp = new ProductLock();
		temp.setId(id);
		temp.setStock(stock);
		productLockDao.updateStock(temp);
		return productLock;
	}

}
