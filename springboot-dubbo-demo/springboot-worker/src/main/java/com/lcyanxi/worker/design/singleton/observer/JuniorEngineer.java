package com.lcyanxi.worker.design.singleton.observer;

/**
 * Created by lcyanxi on 2019/11/19
 */

public class JuniorEngineer implements ITalent {
    @Override
    public void newJob(String job) {
        System.out.println("JuniorEngineer 接收到新工作消息："+job);
    }
}
