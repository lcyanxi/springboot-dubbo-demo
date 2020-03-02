package com.lcyanxi.worker.design.singleton.observer;

/**
 * Created by lcyanxi on 2019/11/19
 */

public class ObserverPatternTest {
    public static void main(String[] args) {
        ITalent talent=new ArchTalent();
        ITalent juniorEngineer=new JuniorEngineer();
        ITalent seniorEngineer = new SeniorEngineer();

        AbstractHR hr=new HeadHunter();
        hr.addTalent(talent);
        hr.addTalent(juniorEngineer);
        hr.addTalent(seniorEngineer);

        hr.publishJob("新东方在线招聘高级开发工程师");
    }
}
