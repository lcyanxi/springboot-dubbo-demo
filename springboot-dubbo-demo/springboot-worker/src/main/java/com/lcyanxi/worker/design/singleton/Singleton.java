package com.lcyanxi.worker.design.singleton;

/**
 * 饿汉式
 * Created by lichang on 2019/10/9
 */
public class Singleton {
    private static Singleton singleton=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return singleton;
    }

}
