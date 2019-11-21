
package com.hwgif.demotwo.service;

import com.hwgif.common.db.domain.PageInfo;
import com.hwgif.common.db.domain.PageControl;
import com.hwgif.demotwo.bean.UserNd;


/**
 * 用户
 * @author lc.huang
 * @date 2019-11-20 14:37:23
 */
public interface UserNdService {

        Integer insertUserNd(UserNd userNd);

        UserNd find(Integer id);

        Integer deleteLogical(Integer id);

        Integer updateUserNd(UserNd userNd);

        PageControl<UserNd> pageAndSortById(UserNd userNd, PageInfo pageInfo);

        PageControl<UserNd> page(UserNd userNd, PageInfo pageInfo, String whereSql, String orderSql);

 }
