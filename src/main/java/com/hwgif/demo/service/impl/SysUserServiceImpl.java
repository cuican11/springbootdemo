
package com.hwgif.demo.service.impl;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.*;
import com.hwgif.demo.dao.*;
import com.hwgif.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
@Service
@Transactional
@CacheConfig(cacheNames="loadUserCache")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysPermissionDao sysPermissionDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private SysRolePermissionDao sysRolePermissionDao;

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

	@Cacheable(key = "#id")
	public SysUser getLoadUserById(Integer id){

		SysUser sysUser = sysUserDao.getEntityById(id);

		SysUserRole urCondition = new SysUserRole();
		urCondition.setSysUserId(sysUser.getId());
		List<SysUserRole> userRoles = sysUserRoleDao.getListByObject(urCondition);
		List<Integer> rIds = new ArrayList<>();
		List<SysRole> roles = new ArrayList<>();
		for (SysUserRole userRole : userRoles ) {

			SysRole role = sysRoleDao.getEntityById(userRole.getId());

			SysRolePermission rpCondition = new SysRolePermission();
			rpCondition.setRoleId(role.getId());
			List<SysRolePermission> rps = sysRolePermissionDao.getListByObject(rpCondition);
			List<SysPermission> spList = new ArrayList<>();
			for ( SysRolePermission  rp : rps) {
				SysPermission sp = sysPermissionDao.getEntityById(rp.getRoleId());
				spList.add(sp);
			}
			role.setPermissionList(spList);
			roles.add(role);
		}

		sysUser.setRoleList(roles);

		return sysUser;
	}

	public SysUser getLoadUserByName(String name){

		SysUser temp = new SysUser();
		temp.setUsername(name);
		SysUser sysUser = sysUserDao.getEntityByObject(temp);
        if (null == sysUser){
        	return null;
		}
		SysUserRole urCondition = new SysUserRole();
		urCondition.setSysUserId(sysUser.getId());
		List<SysUserRole> userRoles = sysUserRoleDao.getListByObject(urCondition);
		List<Integer> rIds = new ArrayList<>();
		List<SysRole> roles = new ArrayList<>();
		for (SysUserRole userRole : userRoles ) {

			SysRole role = sysRoleDao.getEntityById(userRole.getId());

			SysRolePermission rpCondition = new SysRolePermission();
			rpCondition.setRoleId(role.getId());
			List<SysRolePermission> rps = sysRolePermissionDao.getListByObject(rpCondition);
			List<SysPermission> spList = new ArrayList<>();
			for ( SysRolePermission  rp : rps) {
				SysPermission sp = sysPermissionDao.getEntityById(rp.getPermissionId());
				spList.add(sp);
			}
			role.setPermissionList(spList);
			roles.add(role);
		}

		sysUser.setRoleList(roles);

		return sysUser;
	}

}
