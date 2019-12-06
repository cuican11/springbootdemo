
package com.hwgif.demo.service;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.SysUserRole;


/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
public interface SysUserRoleService {

        Integer insertSysUserRole(SysUserRole sysUserRole);

        SysUserRole find(Integer id);

        Integer deleteLogical(Integer id);

        Integer updateSysUserRole(SysUserRole sysUserRole);

        PageControl<SysUserRole> pageAndSortById(SysUserRole sysUserRole, PageInfo pageInfo);

        PageControl<SysUserRole> page(SysUserRole sysUserRole, PageInfo pageInfo, String whereSql, String orderSql);

//    Integer delete(Integer id, Integer updateId);

 }
