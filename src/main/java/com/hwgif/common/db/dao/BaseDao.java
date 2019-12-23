package com.hwgif.common.db.dao;

import com.hwgif.common.db.bean.BaseEntity;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.common.db.domain.PageInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lc.huang on 2019/4/12.
 * Description
 */
@Repository
public abstract class BaseDao<T extends Serializable,M extends BaseEntity> extends SqlSessionDaoSupport implements IDao<T,M>{
//    private final HWGLogger logger = HWGLoggerFactory.getLogger(this.getClass());
    public static final String insertSelective = ".insertSelective";
    public static final String updateByPrimaryKeySelective = ".updateByPrimaryKeySelective";
    public static final String selectByPrimaryKey = ".selectByPrimaryKey";
    public static final String selectByPrimaryKeys = ".selectByPrimaryKeys";
    public static final String getListByEntityAndPageInfo = ".getListByEntityAndPageInfo";
    public static final String getTotalByEntity = ".getTotalByEntity";
    public static final String deleteByPrimaryKey = ".deleteByPrimaryKey";
    private Class<M> curClassType = null;

    /**
     * 每个数据源 重写自己的sqlsessionfactory
     * @param sqlSessionFactory
     */
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public String getMapperNameSpace() {//统一规范命名 取得命名空间  DaoImpl名称 对应 mapper nameSpace
        return this.getClass().getName();
    }

    private Map<String, Object> getMapParams(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        HashMap map = new HashMap();
        if(null != entity) {
            map.put("entity", entity);
        }

        if(null != pageInfo) {
            map.put("pageInfo", pageInfo);
        }

        if(null != whereSql) {
            map.put("whereSql", whereSql);
        }

        if(null != orderBySql) {
            map.put("orderBy", orderBySql);
        }

        return map;
    }

    public BaseDao() {  //对M 做了什么？
        if(this.getClass().getGenericSuperclass() instanceof ParameterizedType) {
            this.curClassType = (Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        }

    }

    public M getEntityById(T var){
//        logger.info("这里是id查找",var,null);
        return this.getSqlSession().selectOne(this.getMapperNameSpace()+ ".selectByPrimaryKey",var);
    }

    public M getEntityByObject(M entity) {
        return (M)this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getListByEntityAndPageInfo", this.getMapParams(entity, (PageInfo)null, (String)null, (String)null));
    }

    public M getEntityByObject(M entity, String where) {

        return this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getListByEntityAndPageInfo", this.getMapParams(entity, (PageInfo)null, where, (String)null));
    }

    public int updateByMapperId(String methodIdInMapper, M entity, String whereSql) {
        Integer ret = Integer.valueOf(this.getSqlSession().update(this.getMapperNameSpace() + "." + methodIdInMapper, this.getMapParams(entity, (PageInfo)null, whereSql, (String)null)));
        return ((Integer)ret).intValue();
    }

    public List<M> selectByMapperId(String methodIdInMapper, M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + "." + methodIdInMapper, this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }


    public int insert(M entity) {
        return this.getSqlSession().insert(this.getMapperNameSpace() + ".insertSelective", entity);
    }

    public int update(M entity) {
        Integer ret = Integer.valueOf(this.getSqlSession().update(this.getMapperNameSpace() + ".updateByPrimaryKeySelective", entity));
        return ret.intValue();
    }

    public int delete(T pk) {
        Integer e = Integer.valueOf(this.getSqlSession().delete(this.getMapperNameSpace() + ".deleteByPrimaryKey", pk));
//        this.deleteCacheByPk(pk); // 缓存删除
        return ((Integer)e).intValue();
    }

    public int getCountByObject(M entity ) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntity", this.getMapParams(entity, (PageInfo)null, (String)null, (String)null));
        return ((Integer)e).intValue();
    }

    public long getCountByObject(M entity, String where) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntity", this.getMapParams(entity, (PageInfo)null, where, (String)null));
        return (long)((Integer)e).intValue();
    }

    public PageControl<M> getPageByObject(M entity, PageInfo pageInfo, String whereSql) {
        return this.getPageByObject(entity, pageInfo, whereSql, null);
    }

    public PageControl<M> getPageByObject(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        PageControl page = new PageControl();
        Object list = new ArrayList();
        long total = this.getCountByObject(entity, whereSql);
        if(total > 0L) {
            list = this.getListByObject(entity, pageInfo, whereSql, orderBySql);
        }

        if(list != null) {
            page.setTotal(total);
            page.setContent((List)list);
        }

        page.setNumber(pageInfo.getPage());
        page.setSize(pageInfo.getSize());
        return page;
    }

    public List<M> getAllEntityObject() {
        return this.getListByObject(null, (String)null);
    }

    public List<M> getListByObject(M entity) {
        return this.getListByObject(entity, (PageInfo)null, (String)null, (String)null);
    }

    public List<M> getListByObject(M entity, String whereSql) {
        return this.getListByObject(entity, (PageInfo)null, whereSql, (String)null);
    }

    public List<M> getListByObject(M entity, PageInfo pageInfo, String whereSql) {
        return this.getListByObject(entity, pageInfo, whereSql, (String)null);
    }

    public List<M> getListByObject(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getListByEntityAndPageInfo", this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }
}
