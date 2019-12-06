
package com.hwgif.demo.service.impl;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.SysPermission;
import com.hwgif.demo.service.SysPermissionService;
import com.hwgif.demo.dao.SysPermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

	@Autowired
	private SysPermissionDao sysPermissionDao;

	public Integer insertSysPermission(SysPermission sysPermission){
		if (sysPermission == null) {
		return 0;
	}

		Integer i = sysPermissionDao.insert(sysPermission);
		return i;
	}

	public SysPermission find(Integer id){
		return sysPermissionDao.getEntityById(id);
	}

	public Integer deleteLogical(Integer id){
		SysPermission temp = new SysPermission();
		temp.setId(id);
		return sysPermissionDao.update(temp);
	}

	public Integer updateSysPermission(SysPermission sysPermission){
		if (sysPermission == null) {
		return 0;
	}

		Integer i = sysPermissionDao.update(sysPermission);
		return i;
	}

	public PageControl<SysPermission> pageAndSortById(SysPermission sysPermission, PageInfo pageInfo){
		return sysPermissionDao.getPageByObject(sysPermission, pageInfo, null, " order by id asc ");
	}

	public PageControl<SysPermission> page(SysPermission sysPermission, PageInfo pageInfo, String whereSql, String orderSql){
		return sysPermissionDao.getPageByObject(sysPermission, pageInfo, whereSql, orderSql);
	}

    /*public Integer delete(Integer id, Integer updateId) {
		SysPermission temp = new SysPermission();
		temp.setId(id);
		temp.setDeleted(true);
		temp.setUpdateId(updateId);
		return sysPermissionDao.update(temp);
    }*/


}
