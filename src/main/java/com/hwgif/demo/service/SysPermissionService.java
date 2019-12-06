
package com.hwgif.demo.service;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.SysPermission;


/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
public interface SysPermissionService {

        Integer insertSysPermission(SysPermission sysPermission);

        SysPermission find(Integer id);

        Integer deleteLogical(Integer id);

        Integer updateSysPermission(SysPermission sysPermission);

        PageControl<SysPermission> pageAndSortById(SysPermission sysPermission, PageInfo pageInfo);

        PageControl<SysPermission> page(SysPermission sysPermission, PageInfo pageInfo, String whereSql, String orderSql);

//    Integer delete(Integer id, Integer updateId);

 }
