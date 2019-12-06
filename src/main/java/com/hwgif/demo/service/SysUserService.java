
package com.hwgif.demo.service;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demo.bean.SysUser;


/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
public interface SysUserService {

        Integer insertSysUser(SysUser sysUser);

        SysUser find(Integer id);

        Integer deleteLogical(Integer id);

        Integer updateSysUser(SysUser sysUser);

        PageControl<SysUser> pageAndSortById(SysUser sysUser, PageInfo pageInfo);

        PageControl<SysUser> page(SysUser sysUser, PageInfo pageInfo, String whereSql, String orderSql);

//    Integer delete(Integer id, Integer updateId);

 }
