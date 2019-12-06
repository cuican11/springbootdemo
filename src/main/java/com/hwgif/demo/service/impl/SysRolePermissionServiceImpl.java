
package com.hwgif.demo.service.impl;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.SysRolePermission;
import com.hwgif.demo.service.SysRolePermissionService;
import com.hwgif.demo.dao.SysRolePermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

	@Autowired
	private SysRolePermissionDao sysRolePermissionDao;

	public Integer insertSysRolePermission(SysRolePermission sysRolePermission){
		if (sysRolePermission == null) {
		return 0;
	}

		Integer i = sysRolePermissionDao.insert(sysRolePermission);
		return i;
	}

	public SysRolePermission find(Integer id){
		return sysRolePermissionDao.getEntityById(id);
	}

	public Integer deleteLogical(Integer id){
		SysRolePermission temp = new SysRolePermission();
		temp.setId(id);
		return sysRolePermissionDao.update(temp);
	}

	public Integer updateSysRolePermission(SysRolePermission sysRolePermission){
		if (sysRolePermission == null) {
		return 0;
	}

		Integer i = sysRolePermissionDao.update(sysRolePermission);
		return i;
	}

	public PageControl<SysRolePermission> pageAndSortById(SysRolePermission sysRolePermission, PageInfo pageInfo){
		return sysRolePermissionDao.getPageByObject(sysRolePermission, pageInfo, null, " order by id asc ");
	}

	public PageControl<SysRolePermission> page(SysRolePermission sysRolePermission, PageInfo pageInfo, String whereSql, String orderSql){
		return sysRolePermissionDao.getPageByObject(sysRolePermission, pageInfo, whereSql, orderSql);
	}

    /*public Integer delete(Integer id, Integer updateId) {
		SysRolePermission temp = new SysRolePermission();
		temp.setId(id);
		temp.setDeleted(true);
		temp.setUpdateId(updateId);
		return sysRolePermissionDao.update(temp);
    }*/


}
