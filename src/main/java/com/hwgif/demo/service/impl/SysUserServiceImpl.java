
package com.hwgif.demo.service.impl;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.SysUser;
import com.hwgif.demo.service.SysUserService;
import com.hwgif.demo.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	public Integer insertSysUser(SysUser sysUser){
		if (sysUser == null) {
		return 0;
	}

		Integer i = sysUserDao.insert(sysUser);
		return i;
	}

	public SysUser find(Integer id){
		return sysUserDao.getEntityById(id);
	}

	public Integer deleteLogical(Integer id){
		SysUser temp = new SysUser();
		temp.setId(id);
		return sysUserDao.update(temp);
	}

	public Integer updateSysUser(SysUser sysUser){
		if (sysUser == null) {
		return 0;
	}

		Integer i = sysUserDao.update(sysUser);
		return i;
	}

	public PageControl<SysUser> pageAndSortById(SysUser sysUser, PageInfo pageInfo){
		return sysUserDao.getPageByObject(sysUser, pageInfo, null, " order by id asc ");
	}

	public PageControl<SysUser> page(SysUser sysUser, PageInfo pageInfo, String whereSql, String orderSql){
		return sysUserDao.getPageByObject(sysUser, pageInfo, whereSql, orderSql);
	}

    /*public Integer delete(Integer id, Integer updateId) {
		SysUser temp = new SysUser();
		temp.setId(id);
		temp.setDeleted(true);
		temp.setUpdateId(updateId);
		return sysUserDao.update(temp);
    }*/


}
