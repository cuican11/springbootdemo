
package com.hwgif.demo.service;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.SysRolePermission;


/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
public interface SysRolePermissionService {

        Integer insertSysRolePermission(SysRolePermission sysRolePermission);

        SysRolePermission find(Integer id);

        Integer deleteLogical(Integer id);

        Integer updateSysRolePermission(SysRolePermission sysRolePermission);

        PageControl<SysRolePermission> pageAndSortById(SysRolePermission sysRolePermission, PageInfo pageInfo);

        PageControl<SysRolePermission> page(SysRolePermission sysRolePermission, PageInfo pageInfo, String whereSql, String orderSql);

//    Integer delete(Integer id, Integer updateId);

 }
