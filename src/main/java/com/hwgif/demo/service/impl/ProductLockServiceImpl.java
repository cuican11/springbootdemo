package com.hwgif.demo.service.impl;

import com.hwgif.common.CommonResult;
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




	/**
	 * 示例
	* 模拟抢购  jmeter 100线程并发请求 立马重现超扣库存
	* */
	public synchronized ProductLock updateStock(Integer id,Integer stock){
		ProductLock productLock = productLockDao.getEntityById(id);

		if (null == productLock){
			return null;
		}
		System.out.println("库存："+ productLock.getStock()+"  预购："+stock);
		if (productLock.getStock().intValue() < stock) {
			return productLock;
		}
		System.out.println("进入update");
		productLock.setStock(stock);
		productLockDao.updateStock(productLock);
		return productLock;
	}

	/**
	 * 示例
	 * 模拟抢购  jmeter 100线程并发请求 立马重现超扣库存
	 * */
	@Transactional(rollbackFor = RuntimeException.class)
	public synchronized CommonResult updateStockCommon(Integer id, Integer stock){
		ProductLock productLock = productLockDao.getEntityById(id);

		if (null == productLock){
			return CommonResult.failResult("商品不存在");
		}
		System.out.println("库存："+ productLock.getStock()+"  预购："+stock);
		if (productLock.getStock().intValue() < stock) {
			return CommonResult.failResult("库存不足");
		}
		System.out.println("进入update");
		productLock.setStock(stock);
		Integer ret = productLockDao.updateStockCommon(productLock);
		if (ret <= 0){
			throw new RuntimeException("更新失败");
		}
		return CommonResult.successResult("成功更新");
	}

}
