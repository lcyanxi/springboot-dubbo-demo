package com.lcyanxi.worker.design.singleton.observer;

/**
 * Created by lcyanxi on 2019/11/19
 */

public class HeadHunter extends AbstractHR {
    @Override
    public void publishJob(String job) {
        allTalents.forEach(talent -> talent.newJob(job));
    }
}
