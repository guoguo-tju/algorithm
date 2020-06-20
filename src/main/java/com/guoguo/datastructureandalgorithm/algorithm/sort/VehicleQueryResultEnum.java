package com.guoguo.datastructureandalgorithm.algorithm.sort;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-11-02 16:30
 */
public enum  VehicleQueryResultEnum {

    SUCCESS("10102000", (short)1, "查询成功"),
    NO_DATA("10104008", (short)0, "交通部查询不到数据"),
    TOKEN_EXPIRE("10105002", (short)0, "TOKEN失效"),
    INTER_FAIL("10104000", (short)0, "交通部接口未知错误");


    private String code;

    private short result;

    private String message;

    VehicleQueryResultEnum(String code, short result, String message) {
        this.code = code;
        this.result = result;
        this.message = message;
    }


    public static VehicleQueryResultEnum getEnumByCode(String code){
        return Arrays.stream(VehicleQueryResultEnum.values()).filter(i-> StringUtils.equals(i.getCode(),code)).findFirst().orElse(null);

    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public short getResult() {
        return result;
    }

    public void setResult(short result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}