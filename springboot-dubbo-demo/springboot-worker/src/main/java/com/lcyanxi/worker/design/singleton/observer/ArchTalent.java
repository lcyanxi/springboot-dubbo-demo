package com.lcyanxi.worker.design.singleton.observer;

/**
 * Created by lcyanxi on 2019/11/19
 */

public class ArchTalent implements ITalent{

    @Override
    public void newJob(String job) {
        System.out.println("ArchTalent 接收到新的工作通知:"+job);
    }
}
