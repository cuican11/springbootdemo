package com.hwgif.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by lc.huang on 2019/11/19.
 * Description
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonResult implements Serializable{
    public static final int CODE_EXCEPTION = -1;
    public static final int CODE_SUCCESS = 1;
    public static final int CODE_ERROR = 0;
    private static final String MSG_EXCEPTION = "异常";
    private static final String MSG_SUCCESS = "成功";
    private static final String MSG_FAIL = "失败";
    private static final Object RESULT_OBJECT = new Object();
    private int code;
    private String msg;
    private Object resultObject;

    public CommonResult() {
    }

    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.resultObject = object;
    }

    public static CommonResult successResult() {
        CommonResult result = new CommonResult(1, "成功", RESULT_OBJECT);
        return result;
    }

    public static CommonResult successResult(Object resultObject) {
        CommonResult result = new CommonResult(1, "成功", resultObject);
        return result;
    }

    public static CommonResult successResult(String msg, Object resultObject) {
        CommonResult result = new CommonResult(1, msg, resultObject);
        return result;
    }

    public static CommonResult successResult(int code, String msg, Object resultObject) {
        CommonResult result = new CommonResult(code, msg, resultObject);
        return result;
    }

    public static CommonResult failResult() {
        CommonResult result = new CommonResult(0, "失败", RESULT_OBJECT);
        return result;
    }

    public static CommonResult failResult(String msg) {
        CommonResult result = new CommonResult(0, msg);
        return result;
    }

    public static CommonResult failResult(Object resultObject) {
        CommonResult result = new CommonResult(0, "失败", resultObject);
        return result;
    }

    public static CommonResult failResult(String msg, Object resultObject) {
        CommonResult result = new CommonResult(0, msg, resultObject);
        return result;
    }

    public static CommonResult failResult(int code, String msg, Object resultObject) {
        CommonResult result = new CommonResult(code, msg, resultObject);
        return result;
    }

    public static CommonResult exceptionResult() {
        CommonResult result = new CommonResult(-1, "异常", RESULT_OBJECT);
        return result;
    }

    public static CommonResult exceptionResult(String msg) {
        CommonResult result = new CommonResult(-1, "异常:"+msg);
        return result;
    }

    public static CommonResult exceptionResult(Object resultObject) {
        CommonResult result = new CommonResult(-1, "异常", resultObject);
        return result;
    }

    public static CommonResult exceptionResult(String msg, Object resultObject) {
        CommonResult result = new CommonResult(-1, msg, resultObject);
        return result;
    }

    public static CommonResult exceptionResult(int code, String msg, Object resultObject) {
        CommonResult result = new CommonResult(code, msg, resultObject);
        return result;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResultObject() {
        return this.resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public String toString() {
        return "CommonResult{code=" + this.code + ", msg=\'" + this.msg + '\'' + ", resultObject=" + this.resultObject + '}';
    }
}
