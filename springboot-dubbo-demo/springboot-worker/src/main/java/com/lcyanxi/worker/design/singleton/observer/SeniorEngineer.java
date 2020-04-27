package com.lcyanxi.worker.design.singleton.observer;

/**
 * Created by lcyanxi on 2019/11/19
 */

public class SeniorEngineer implements ITalent {
    @Override
    public void newJob(String job) {
        System.out.println("SeniorEngineer 接收到新工作提示："+job);
    }
}
