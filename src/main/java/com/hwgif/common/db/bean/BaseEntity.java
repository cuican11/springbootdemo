package com.hwgif.common.db.bean;

import java.io.Serializable;

/**
 * Created by lc.huang on 2019/11/19.
 * Description
 */
public abstract class BaseEntity implements Serializable {
    public static final int DEFAULT_SYSTEM_USER_ID = 0;
    public static final int STATUS_ENABLE = 1;
    public static final int STATUS_DISABLE = 0;
    public static final int IS_SHOW_TRUE = 1;
    public static final int IS_SHOW_FALSE = 0;
    public static final int IS_DEL_TRUE = 1;
    public static final int IS_DEL_FALSE = 0;
    public static final int IS_VALID_TRUE = 1;
    public static final int IS_VALID_FALSE = 0;
    public static final String DEFAULT_EMPTY_STRING = "";
    public static final String SPACE = " ";
    public static final int DEFAULT_NUMBER = 0;
    public static final double DEFAULT_DOUBLE_ZERO = 0.0D;
    public static final Integer IGNORE_DELETED = Integer.valueOf(1);

    public BaseEntity() {
    }

    public abstract <T extends Serializable> T getId();
}