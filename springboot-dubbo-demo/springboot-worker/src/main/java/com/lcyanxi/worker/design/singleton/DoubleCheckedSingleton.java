package com.lcyanxi.worker.design.singleton;

/**
 * 双重检验锁
 * Created by lichang on 2019/10/9
 */
public class DoubleCheckedSingleton {
    public static volatile DoubleCheckedSingleton singleton;
    private DoubleCheckedSingleton(){}

    public static DoubleCheckedSingleton getInstance(){
        if (singleton==null){
            synchronized (DoubleCheckedSingleton.class){
                if (singleton == null){
                    /**
                     * 1. memory = allocate();  分配内存空间地址
                     * 2. ctorInstance(memory)； 初始化对象
                     * 3. instance = memory; 设置instance指向刚分配的内存空间地址
                     */
                    singleton= new DoubleCheckedSingleton();
                }
            }
        }
        return singleton;
    }
}
