
package com.hwgif.demo.service;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.SysRole;


/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
public interface SysRoleService {

        Integer insertSysRole(SysRole sysRole);

        SysRole find(Integer id);

        Integer deleteLogical(Integer id);

        Integer updateSysRole(SysRole sysRole);

        PageControl<SysRole> pageAndSortById(SysRole sysRole, PageInfo pageInfo);

        PageControl<SysRole> page(SysRole sysRole, PageInfo pageInfo, String whereSql, String orderSql);

//    Integer delete(Integer id, Integer updateId);

 }
