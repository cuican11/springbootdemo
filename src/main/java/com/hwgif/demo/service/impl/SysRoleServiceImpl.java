
package com.hwgif.demo.service.impl;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.SysRole;
import com.hwgif.demo.service.SysRoleService;
import com.hwgif.demo.dao.SysRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;

	public Integer insertSysRole(SysRole sysRole){
		if (sysRole == null) {
		return 0;
	}

		Integer i = sysRoleDao.insert(sysRole);
		return i;
	}

	public SysRole find(Integer id){
		return sysRoleDao.getEntityById(id);
	}

	public Integer deleteLogical(Integer id){
		SysRole temp = new SysRole();
		temp.setId(id);
		return sysRoleDao.update(temp);
	}

	public Integer updateSysRole(SysRole sysRole){
		if (sysRole == null) {
		return 0;
	}

		Integer i = sysRoleDao.update(sysRole);
		return i;
	}

	public PageControl<SysRole> pageAndSortById(SysRole sysRole, PageInfo pageInfo){
		return sysRoleDao.getPageByObject(sysRole, pageInfo, null, " order by id asc ");
	}

	public PageControl<SysRole> page(SysRole sysRole, PageInfo pageInfo, String whereSql, String orderSql){
		return sysRoleDao.getPageByObject(sysRole, pageInfo, whereSql, orderSql);
	}

    /*public Integer delete(Integer id, Integer updateId) {
		SysRole temp = new SysRole();
		temp.setId(id);
		temp.setDeleted(true);
		temp.setUpdateId(updateId);
		return sysRoleDao.update(temp);
    }*/


}
