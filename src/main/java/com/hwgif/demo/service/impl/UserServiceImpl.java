
package com.hwgif.demo.service.impl;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.User;
import com.hwgif.demo.service.UserService;
import com.hwgif.demo.dao.UserDao;
import com.hwgif.example.easyexcel.bean.UserExcelBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户
 * @author lc.huang
 * @date 2019-11-19 16:08:50
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public Integer insertUser(User user){
		if (user == null) {
		return 0;
	}

		User i = userDao.insertAndCahe(user);
		return i.getId();
	}


	public User find(Integer id){
		return userDao.findUser(id);
	}

	public Integer deleteLogical(Integer id){
		User temp = new User();
		temp.setId(id);
		temp.setDeleted(true);
		return userDao.update(temp);
	}

	public Integer updateUser(User user){
		if (user == null) {
		return 0;
	}

		Integer i = userDao.update(user);
		return i;
	}

	public PageControl<User> pageAndSortById(User user, PageInfo pageInfo){
		return userDao.getPageByObject(user, pageInfo, null, " order by id asc ");
	}

	public PageControl<User> page(User user, PageInfo pageInfo, String whereSql, String orderSql){
		return userDao.getPageByObject(user, pageInfo, whereSql, orderSql);
	}

	public List<UserExcelBean> getdata(Integer page){
		Integer size = 10000;
		PageInfo pageInfo = new PageInfo(page,size);
		Integer startId = (page - 1) * 10000 + 1;
		List<User> pagedata = userDao.exportuser(" id >= " + startId," order by id asc limit "+ size);
		if (null != pagedata && pagedata.size() > 0){
			return UserExcelBean.getList(pagedata);
		}
		return null;
	}

    /*public Integer delete(Integer id, Integer updateId) {
		User temp = new User();
		temp.setId(id);
		temp.setDeleted(true);
		temp.setUpdateId(updateId);
		return userDao.update(temp);
    }*/


}
