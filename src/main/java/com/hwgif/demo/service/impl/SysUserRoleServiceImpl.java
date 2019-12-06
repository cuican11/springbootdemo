
package com.hwgif.demo.service.impl;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.SysUserRole;
import com.hwgif.demo.service.SysUserRoleService;
import com.hwgif.demo.dao.SysUserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	public Integer insertSysUserRole(SysUserRole sysUserRole){
		if (sysUserRole == null) {
		return 0;
	}

		Integer i = sysUserRoleDao.insert(sysUserRole);
		return i;
	}

	public SysUserRole find(Integer id){
		return sysUserRoleDao.getEntityById(id);
	}

	public Integer deleteLogical(Integer id){
		SysUserRole temp = new SysUserRole();
		temp.setId(id);
		return sysUserRoleDao.update(temp);
	}

	public Integer updateSysUserRole(SysUserRole sysUserRole){
		if (sysUserRole == null) {
		return 0;
	}

		Integer i = sysUserRoleDao.update(sysUserRole);
		return i;
	}

	public PageControl<SysUserRole> pageAndSortById(SysUserRole sysUserRole, PageInfo pageInfo){
		return sysUserRoleDao.getPageByObject(sysUserRole, pageInfo, null, " order by id asc ");
	}

	public PageControl<SysUserRole> page(SysUserRole sysUserRole, PageInfo pageInfo, String whereSql, String orderSql){
		return sysUserRoleDao.getPageByObject(sysUserRole, pageInfo, whereSql, orderSql);
	}

    /*public Integer delete(Integer id, Integer updateId) {
		SysUserRole temp = new SysUserRole();
		temp.setId(id);
		temp.setDeleted(true);
		temp.setUpdateId(updateId);
		return sysUserRoleDao.update(temp);
    }*/


}
