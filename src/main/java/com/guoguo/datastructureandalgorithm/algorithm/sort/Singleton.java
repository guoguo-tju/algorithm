package com.guoguo.datastructureandalgorithm.algorithm.sort;

/**
 * 描述:
 * 单例模式 - 懒汉式
 *
 * @author guozh
 * @create 2019-12-12 22:04
 */
public class Singleton {

    private Singleton(){}

    private static Singleton singleton;

    public Singleton getSingleton(){
        if(singleton == null){
            return new Singleton();
        }
        return null;
    }









}