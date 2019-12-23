
package com.hwgif.demo.dao.impl;

import com.hwgif.common.db.dao.BaseDao;
import com.hwgif.demo.bean.SysRole;
import com.hwgif.demo.dao.SysRoleDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
@Repository
public class SysRoleDaoImpl extends BaseDao<Integer, SysRole> implements SysRoleDao {


    public List<SysRole> getListInIds(List<Integer> ids){
        return this.getSqlSession().selectList(this.getMapperNameSpace() +".getListInIds", ids);
    }
}
