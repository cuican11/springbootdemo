
package com.hwgif.demotwo.service.impl;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demotwo.bean.UserNd;
import com.hwgif.demotwo.service.UserNdService;
import com.hwgif.demotwo.dao.UserNdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户
 * @author lc.huang
 * @date 2019-11-20 14:37:24
 */
@Service
public class UserNdServiceImpl implements UserNdService {

	@Autowired
	private UserNdDao userNdDao;

	public Integer insertUserNd(UserNd userNd){
		if (userNd == null) {
		return 0;
	}

		Integer i = userNdDao.insert(userNd);
		return i;
	}

	public UserNd find(Integer id){
		return userNdDao.getEntityById(id);
	}

	public Integer deleteLogical(Integer id){
		UserNd temp = new UserNd();
		temp.setId(id);
		temp.setDeleted(true);
		return userNdDao.update(temp);
	}

	public Integer updateUserNd(UserNd userNd){
		if (userNd == null) {
		return 0;
	}

		Integer i = userNdDao.update(userNd);
		return i;
	}

	public PageControl<UserNd> pageAndSortById(UserNd userNd, PageInfo pageInfo){
		return userNdDao.getPageByObject(userNd, pageInfo, null, " order by id asc ");
	}

	public PageControl<UserNd> page(UserNd userNd, PageInfo pageInfo, String whereSql, String orderSql){
		return userNdDao.getPageByObject(userNd, pageInfo, whereSql, orderSql);
	}


}
