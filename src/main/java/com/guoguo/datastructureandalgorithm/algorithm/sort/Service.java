package com.guoguo.datastructureandalgorithm.algorithm.sort;

/**
 * 描述:
 * 服务类
 *
 * @author guozh
 * @create 2019-11-02 16:44
 */
public class Service {


    public static void main(String[] args) {

        String code = "10102000";

        //获取到message
        VehicleQueryResultEnum enumByCode = VehicleQueryResultEnum.getEnumByCode(code);

        System.out.println(enumByCode.getResult());
        System.out.println(enumByCode.getMessage());

    }

}