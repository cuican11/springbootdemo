package com.hwgif.common.db.dao;

import com.hwgif.common.db.domain.PageControl;
import com.hwgif.common.db.domain.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lc.huang on 2019/4/11.
 * Description
 */
public interface IDao<T extends Serializable,M> {

    int updateByMapperId(String var1, M var2, String var3);

    List<M> selectByMapperId(String var1, M var2, PageInfo var3, String var4, String var5);

    int insert(M var1);

    int delete(T var1);

    int update(M var1);

    M getEntityById(T var1);

    M getEntityByObject(M var1);

    M getEntityByObject(M var1, String var2);

    int getCountByObject(M var1);

    long getCountByObject(M var1, String var2);

    PageControl<M> getPageByObject(M var1, PageInfo var2, String var3);

    PageControl<M> getPageByObject(M var1, PageInfo var2, String var3, String var4);

    List<M> getAllEntityObject();

    List<M> getListByObject(M var1);

    List<M> getListByObject(M var1, String var2);

    List<M> getListByObject(M var1, PageInfo var2, String var3);

    List<M> getListByObject(M var1, PageInfo var2, String var3, String var4);
}
