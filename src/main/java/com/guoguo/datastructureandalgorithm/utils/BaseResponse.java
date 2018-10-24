package com.guoguo.datastructureandalgorithm.utils;

import com.alibaba.fastjson.JSON;

/**
 * @program: algorithm
 * @description: 返回结果的基础类
 * @author: Karl Guo
 * @create: 2018-10-24 11:21
 **/
public class BaseResponse<T> {

    private boolean flag;
    private String msg;
    private int code;
    private T result;


    public BaseResponse() {
    }

    public BaseResponse(boolean flag, String msg, int code) {
        this.flag = flag;
        this.msg = msg;
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public static BaseResponse getFailBaseResponse(String msg) {
        return new BaseResponse(false, msg, 0);
    }

    public static BaseResponse getSuccessRes() {
        return new BaseResponse(true, "", 0);
    }

    public static BaseResponse getFailedRes(String message) {
        return new BaseResponse(false, message, 0);
    }

    public static BaseResponse getSuccessRes(String message, int code) {
        return new BaseResponse(true, message, code);
    }


}
