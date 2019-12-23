package com.hwgif.demo.dao;

import com.hwgif.common.db.dao.IDao;
import com.hwgif.demo.bean.SysRole;

import java.util.List;

/**
 *  角色
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
public interface SysRoleDao extends IDao<Integer, SysRole> {

    List<SysRole> getListInIds(List<Integer> ids);

}
